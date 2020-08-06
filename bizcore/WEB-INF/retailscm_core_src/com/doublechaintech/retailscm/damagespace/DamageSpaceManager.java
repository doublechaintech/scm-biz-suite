
package com.doublechaintech.retailscm.damagespace;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface DamageSpaceManager extends BaseManager{

		

	public DamageSpace createDamageSpace(RetailscmUserContext userContext, String location,String contactNumber,String totalArea,BigDecimal latitude,BigDecimal longitude,String warehouseId) throws Exception;
	public DamageSpace updateDamageSpace(RetailscmUserContext userContext,String damageSpaceId, int damageSpaceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public DamageSpace loadDamageSpace(RetailscmUserContext userContext, String damageSpaceId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public DamageSpace internalSaveDamageSpace(RetailscmUserContext userContext, DamageSpace damageSpace) throws Exception;
	public DamageSpace internalSaveDamageSpace(RetailscmUserContext userContext, DamageSpace damageSpace,Map<String,Object>option) throws Exception;

	public DamageSpace transferToAnotherWarehouse(RetailscmUserContext userContext, String damageSpaceId, String anotherWarehouseId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String damageSpaceId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, DamageSpace newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  GoodsShelfManager getGoodsShelfManager(RetailscmUserContext userContext, String damageSpaceId, String location, String storageSpaceId, String supplierSpaceId ,String [] tokensExpr)  throws Exception;

	public  DamageSpace addGoodsShelf(RetailscmUserContext userContext, String damageSpaceId, String location, String storageSpaceId, String supplierSpaceId , String [] tokensExpr)  throws Exception;
	public  DamageSpace removeGoodsShelf(RetailscmUserContext userContext, String damageSpaceId, String goodsShelfId, int goodsShelfVersion,String [] tokensExpr)  throws Exception;
	public  DamageSpace updateGoodsShelf(RetailscmUserContext userContext, String damageSpaceId, String goodsShelfId, int goodsShelfVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByWarehouse(RetailscmUserContext userContext,String warehouseId) throws Exception;
	public Object listPageByWarehouse(RetailscmUserContext userContext,String warehouseId, int start, int count) throws Exception;
  

}


