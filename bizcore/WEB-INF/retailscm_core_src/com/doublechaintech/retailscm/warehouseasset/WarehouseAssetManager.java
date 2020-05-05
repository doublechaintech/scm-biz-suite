
package com.doublechaintech.retailscm.warehouseasset;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface WarehouseAssetManager extends BaseManager{

		

	public WarehouseAsset createWarehouseAsset(RetailscmUserContext userContext, String name,String position,String ownerId) throws Exception;
	public WarehouseAsset updateWarehouseAsset(RetailscmUserContext userContext,String warehouseAssetId, int warehouseAssetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public WarehouseAsset loadWarehouseAsset(RetailscmUserContext userContext, String warehouseAssetId, String [] tokensExpr) throws Exception;
	public WarehouseAsset internalSaveWarehouseAsset(RetailscmUserContext userContext, WarehouseAsset warehouseAsset) throws Exception;
	public WarehouseAsset internalSaveWarehouseAsset(RetailscmUserContext userContext, WarehouseAsset warehouseAsset,Map<String,Object>option) throws Exception;

	public WarehouseAsset transferToAnotherOwner(RetailscmUserContext userContext, String warehouseAssetId, String anotherOwnerId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String warehouseAssetId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, WarehouseAsset newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByOwner(RetailscmUserContext userContext,String ownerId) throws Exception;
	public Object listPageByOwner(RetailscmUserContext userContext,String ownerId, int start, int count) throws Exception;
  

}


