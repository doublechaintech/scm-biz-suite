
package com.doublechaintech.retailscm.storagespace;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface StorageSpaceManager extends BaseManager{

		

	public StorageSpace createStorageSpace(RetailscmUserContext userContext, String location,String contactNumber,String totalArea,String warehouseId,BigDecimal latitude,BigDecimal longitude) throws Exception;
	public StorageSpace updateStorageSpace(RetailscmUserContext userContext,String storageSpaceId, int storageSpaceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public StorageSpace loadStorageSpace(RetailscmUserContext userContext, String storageSpaceId, String [] tokensExpr) throws Exception;
	public StorageSpace internalSaveStorageSpace(RetailscmUserContext userContext, StorageSpace storageSpace) throws Exception;
	public StorageSpace internalSaveStorageSpace(RetailscmUserContext userContext, StorageSpace storageSpace,Map<String,Object>option) throws Exception;

	public StorageSpace transferToAnotherWarehouse(RetailscmUserContext userContext, String storageSpaceId, String anotherWarehouseId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String storageSpaceId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, StorageSpace newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  GoodsShelfManager getGoodsShelfManager(RetailscmUserContext userContext, String storageSpaceId, String location, String supplierSpaceId, String damageSpaceId ,String [] tokensExpr)  throws Exception;

	public  StorageSpace addGoodsShelf(RetailscmUserContext userContext, String storageSpaceId, String location, String supplierSpaceId, String damageSpaceId , String [] tokensExpr)  throws Exception;
	public  StorageSpace removeGoodsShelf(RetailscmUserContext userContext, String storageSpaceId, String goodsShelfId, int goodsShelfVersion,String [] tokensExpr)  throws Exception;
	public  StorageSpace updateGoodsShelf(RetailscmUserContext userContext, String storageSpaceId, String goodsShelfId, int goodsShelfVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByWarehouse(RetailscmUserContext userContext,String warehouseId) throws Exception;
	public Object listPageByWarehouse(RetailscmUserContext userContext,String warehouseId, int start, int count) throws Exception;
  

}


