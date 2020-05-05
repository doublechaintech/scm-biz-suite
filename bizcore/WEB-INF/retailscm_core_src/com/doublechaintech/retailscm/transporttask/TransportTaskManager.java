
package com.doublechaintech.retailscm.transporttask;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface TransportTaskManager extends BaseManager{

		

	public TransportTask createTransportTask(RetailscmUserContext userContext, String name,String start,Date beginTime,String endId,String driverId,String truckId,String belongsToId,BigDecimal latitude,BigDecimal longitude) throws Exception;
	public TransportTask updateTransportTask(RetailscmUserContext userContext,String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public TransportTask loadTransportTask(RetailscmUserContext userContext, String transportTaskId, String [] tokensExpr) throws Exception;
	public TransportTask internalSaveTransportTask(RetailscmUserContext userContext, TransportTask transportTask) throws Exception;
	public TransportTask internalSaveTransportTask(RetailscmUserContext userContext, TransportTask transportTask,Map<String,Object>option) throws Exception;

	public TransportTask transferToAnotherEnd(RetailscmUserContext userContext, String transportTaskId, String anotherEndId)  throws Exception;
 	public TransportTask transferToAnotherDriver(RetailscmUserContext userContext, String transportTaskId, String anotherDriverId)  throws Exception;
 	public TransportTask transferToAnotherTruck(RetailscmUserContext userContext, String transportTaskId, String anotherTruckId)  throws Exception;
 	public TransportTask transferToAnotherBelongsTo(RetailscmUserContext userContext, String transportTaskId, String anotherBelongsToId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String transportTaskId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, TransportTask newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  GoodsManager getGoodsManager(RetailscmUserContext userContext, String transportTaskId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String retailStoreId, String bizOrderId, String retailStoreOrderId ,String [] tokensExpr)  throws Exception;

	public  TransportTask addGoods(RetailscmUserContext userContext, String transportTaskId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String retailStoreId, String bizOrderId, String retailStoreOrderId , String [] tokensExpr)  throws Exception;
	public  TransportTask removeGoods(RetailscmUserContext userContext, String transportTaskId, String goodsId, int goodsVersion,String [] tokensExpr)  throws Exception;
	public  TransportTask updateGoods(RetailscmUserContext userContext, String transportTaskId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  TransportTaskTrackManager getTransportTaskTrackManager(RetailscmUserContext userContext, String transportTaskId, Date trackTime, BigDecimal latitude, BigDecimal longitude ,String [] tokensExpr)  throws Exception;

	public  TransportTask addTransportTaskTrack(RetailscmUserContext userContext, String transportTaskId, Date trackTime, BigDecimal latitude, BigDecimal longitude , String [] tokensExpr)  throws Exception;
	public  TransportTask removeTransportTaskTrack(RetailscmUserContext userContext, String transportTaskId, String transportTaskTrackId, int transportTaskTrackVersion,String [] tokensExpr)  throws Exception;
	public  TransportTask updateTransportTaskTrack(RetailscmUserContext userContext, String transportTaskId, String transportTaskTrackId, int transportTaskTrackVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByEnd(RetailscmUserContext userContext,String endId) throws Exception;
	public Object listPageByEnd(RetailscmUserContext userContext,String endId, int start, int count) throws Exception;
  
	public Object listByDriver(RetailscmUserContext userContext,String driverId) throws Exception;
	public Object listPageByDriver(RetailscmUserContext userContext,String driverId, int start, int count) throws Exception;
  
	public Object listByTruck(RetailscmUserContext userContext,String truckId) throws Exception;
	public Object listPageByTruck(RetailscmUserContext userContext,String truckId, int start, int count) throws Exception;
  
	public Object listByBelongsTo(RetailscmUserContext userContext,String belongsToId) throws Exception;
	public Object listPageByBelongsTo(RetailscmUserContext userContext,String belongsToId, int start, int count) throws Exception;
  

}


