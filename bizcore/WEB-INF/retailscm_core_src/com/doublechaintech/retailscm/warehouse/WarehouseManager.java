
package com.doublechaintech.retailscm.warehouse;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface WarehouseManager extends BaseManager{

		

	public Warehouse createWarehouse(RetailscmUserContext userContext, String location,String contactNumber,String totalArea,String ownerId,BigDecimal latitude,BigDecimal longitude) throws Exception;
	public Warehouse updateWarehouse(RetailscmUserContext userContext,String warehouseId, int warehouseVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Warehouse loadWarehouse(RetailscmUserContext userContext, String warehouseId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public Warehouse internalSaveWarehouse(RetailscmUserContext userContext, Warehouse warehouse) throws Exception;
	public Warehouse internalSaveWarehouse(RetailscmUserContext userContext, Warehouse warehouse,Map<String,Object>option) throws Exception;

	public Warehouse transferToAnotherOwner(RetailscmUserContext userContext, String warehouseId, String anotherOwnerId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String warehouseId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, Warehouse newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  StorageSpaceManager getStorageSpaceManager(RetailscmUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude ,String [] tokensExpr)  throws Exception;

	public  Warehouse addStorageSpace(RetailscmUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude , String [] tokensExpr)  throws Exception;
	public  Warehouse removeStorageSpace(RetailscmUserContext userContext, String warehouseId, String storageSpaceId, int storageSpaceVersion,String [] tokensExpr)  throws Exception;
	public  Warehouse updateStorageSpace(RetailscmUserContext userContext, String warehouseId, String storageSpaceId, int storageSpaceVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  SmartPalletManager getSmartPalletManager(RetailscmUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude ,String [] tokensExpr)  throws Exception;

	public  Warehouse addSmartPallet(RetailscmUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude , String [] tokensExpr)  throws Exception;
	public  Warehouse removeSmartPallet(RetailscmUserContext userContext, String warehouseId, String smartPalletId, int smartPalletVersion,String [] tokensExpr)  throws Exception;
	public  Warehouse updateSmartPallet(RetailscmUserContext userContext, String warehouseId, String smartPalletId, int smartPalletVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  SupplierSpaceManager getSupplierSpaceManager(RetailscmUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude ,String [] tokensExpr)  throws Exception;

	public  Warehouse addSupplierSpace(RetailscmUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude , String [] tokensExpr)  throws Exception;
	public  Warehouse removeSupplierSpace(RetailscmUserContext userContext, String warehouseId, String supplierSpaceId, int supplierSpaceVersion,String [] tokensExpr)  throws Exception;
	public  Warehouse updateSupplierSpace(RetailscmUserContext userContext, String warehouseId, String supplierSpaceId, int supplierSpaceVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ReceivingSpaceManager getReceivingSpaceManager(RetailscmUserContext userContext, String warehouseId, String location, String contactNumber, String description, String totalArea, BigDecimal latitude, BigDecimal longitude ,String [] tokensExpr)  throws Exception;

	public  Warehouse addReceivingSpace(RetailscmUserContext userContext, String warehouseId, String location, String contactNumber, String description, String totalArea, BigDecimal latitude, BigDecimal longitude , String [] tokensExpr)  throws Exception;
	public  Warehouse removeReceivingSpace(RetailscmUserContext userContext, String warehouseId, String receivingSpaceId, int receivingSpaceVersion,String [] tokensExpr)  throws Exception;
	public  Warehouse updateReceivingSpace(RetailscmUserContext userContext, String warehouseId, String receivingSpaceId, int receivingSpaceVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ShippingSpaceManager getShippingSpaceManager(RetailscmUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude, String description ,String [] tokensExpr)  throws Exception;

	public  Warehouse addShippingSpace(RetailscmUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude, String description , String [] tokensExpr)  throws Exception;
	public  Warehouse removeShippingSpace(RetailscmUserContext userContext, String warehouseId, String shippingSpaceId, int shippingSpaceVersion,String [] tokensExpr)  throws Exception;
	public  Warehouse updateShippingSpace(RetailscmUserContext userContext, String warehouseId, String shippingSpaceId, int shippingSpaceVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  DamageSpaceManager getDamageSpaceManager(RetailscmUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude ,String [] tokensExpr)  throws Exception;

	public  Warehouse addDamageSpace(RetailscmUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude , String [] tokensExpr)  throws Exception;
	public  Warehouse removeDamageSpace(RetailscmUserContext userContext, String warehouseId, String damageSpaceId, int damageSpaceVersion,String [] tokensExpr)  throws Exception;
	public  Warehouse updateDamageSpace(RetailscmUserContext userContext, String warehouseId, String damageSpaceId, int damageSpaceVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  WarehouseAssetManager getWarehouseAssetManager(RetailscmUserContext userContext, String warehouseId, String name, String position ,String [] tokensExpr)  throws Exception;

	public  Warehouse addWarehouseAsset(RetailscmUserContext userContext, String warehouseId, String name, String position , String [] tokensExpr)  throws Exception;
	public  Warehouse removeWarehouseAsset(RetailscmUserContext userContext, String warehouseId, String warehouseAssetId, int warehouseAssetVersion,String [] tokensExpr)  throws Exception;
	public  Warehouse updateWarehouseAsset(RetailscmUserContext userContext, String warehouseId, String warehouseAssetId, int warehouseAssetVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByOwner(RetailscmUserContext userContext,String ownerId) throws Exception;
	public Object listPageByOwner(RetailscmUserContext userContext,String ownerId, int start, int count) throws Exception;
  

}


