
package com.doublechaintech.retailscm.goods;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;
import com.doublechaintech.retailscm.goodsallocation.GoodsAllocation;
import com.doublechaintech.retailscm.goodspackaging.GoodsPackaging;
import com.doublechaintech.retailscm.sku.Sku;
import com.doublechaintech.retailscm.receivingspace.ReceivingSpace;
import com.doublechaintech.retailscm.smartpallet.SmartPallet;
import com.doublechaintech.retailscm.shippingspace.ShippingSpace;
import com.doublechaintech.retailscm.transporttask.TransportTask;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;

public class GoodsMapper extends BaseRowMapper<Goods>{
	
	protected Goods internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Goods goods = getGoods();		
		 		
 		setId(goods, rs, rowNumber); 		
 		setName(goods, rs, rowNumber); 		
 		setRfid(goods, rs, rowNumber); 		
 		setUom(goods, rs, rowNumber); 		
 		setMaxPackage(goods, rs, rowNumber); 		
 		setExpireTime(goods, rs, rowNumber); 		
 		setSku(goods, rs, rowNumber); 		
 		setReceivingSpace(goods, rs, rowNumber); 		
 		setGoodsAllocation(goods, rs, rowNumber); 		
 		setSmartPallet(goods, rs, rowNumber); 		
 		setShippingSpace(goods, rs, rowNumber); 		
 		setTransportTask(goods, rs, rowNumber); 		
 		setRetailStore(goods, rs, rowNumber); 		
 		setBizOrder(goods, rs, rowNumber); 		
 		setRetailStoreOrder(goods, rs, rowNumber); 		
 		setPackaging(goods, rs, rowNumber); 		
 		setCurrentStatus(goods, rs, rowNumber); 		
 		setVersion(goods, rs, rowNumber);

		return goods;
	}
	
	protected Goods getGoods(){
		return new Goods();
	}		
		
	protected void setId(Goods goods, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(GoodsTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		goods.setId(id);
	}
		
	protected void setName(Goods goods, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(GoodsTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		goods.setName(name);
	}
		
	protected void setRfid(Goods goods, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String rfid = rs.getString(GoodsTable.COLUMN_RFID);
		if(rfid == null){
			//do nothing when nothing found in database
			return;
		}
		
		goods.setRfid(rfid);
	}
		
	protected void setUom(Goods goods, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String uom = rs.getString(GoodsTable.COLUMN_UOM);
		if(uom == null){
			//do nothing when nothing found in database
			return;
		}
		
		goods.setUom(uom);
	}
		
	protected void setMaxPackage(Goods goods, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer maxPackage = rs.getInt(GoodsTable.COLUMN_MAX_PACKAGE);
		if(maxPackage == null){
			//do nothing when nothing found in database
			return;
		}
		
		goods.setMaxPackage(maxPackage);
	}
		
	protected void setExpireTime(Goods goods, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date expireTime = rs.getDate(GoodsTable.COLUMN_EXPIRE_TIME);
		if(expireTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		goods.setExpireTime(expireTime);
	}
		 		
 	protected void setSku(Goods goods, ResultSet rs, int rowNumber) throws SQLException{
 		String skuId = rs.getString(GoodsTable.COLUMN_SKU);
 		if( skuId == null){
 			return;
 		}
 		if( skuId.isEmpty()){
 			return;
 		}
 		Sku lsku = goods.getSku();
 		if( lsku != null ){
 			//if the root object 'goods' already have the property, just set the id for it;
 			lsku.setId(skuId);
 			
 			return;
 		}
 		goods.setSku(createEmptySku(skuId));
 	}
 	 		
 	protected void setReceivingSpace(Goods goods, ResultSet rs, int rowNumber) throws SQLException{
 		String receivingSpaceId = rs.getString(GoodsTable.COLUMN_RECEIVING_SPACE);
 		if( receivingSpaceId == null){
 			return;
 		}
 		if( receivingSpaceId.isEmpty()){
 			return;
 		}
 		ReceivingSpace lreceivingSpace = goods.getReceivingSpace();
 		if( lreceivingSpace != null ){
 			//if the root object 'goods' already have the property, just set the id for it;
 			lreceivingSpace.setId(receivingSpaceId);
 			
 			return;
 		}
 		goods.setReceivingSpace(createEmptyReceivingSpace(receivingSpaceId));
 	}
 	 		
 	protected void setGoodsAllocation(Goods goods, ResultSet rs, int rowNumber) throws SQLException{
 		String goodsAllocationId = rs.getString(GoodsTable.COLUMN_GOODS_ALLOCATION);
 		if( goodsAllocationId == null){
 			return;
 		}
 		if( goodsAllocationId.isEmpty()){
 			return;
 		}
 		GoodsAllocation lgoodsAllocation = goods.getGoodsAllocation();
 		if( lgoodsAllocation != null ){
 			//if the root object 'goods' already have the property, just set the id for it;
 			lgoodsAllocation.setId(goodsAllocationId);
 			
 			return;
 		}
 		goods.setGoodsAllocation(createEmptyGoodsAllocation(goodsAllocationId));
 	}
 	 		
 	protected void setSmartPallet(Goods goods, ResultSet rs, int rowNumber) throws SQLException{
 		String smartPalletId = rs.getString(GoodsTable.COLUMN_SMART_PALLET);
 		if( smartPalletId == null){
 			return;
 		}
 		if( smartPalletId.isEmpty()){
 			return;
 		}
 		SmartPallet lsmartPallet = goods.getSmartPallet();
 		if( lsmartPallet != null ){
 			//if the root object 'goods' already have the property, just set the id for it;
 			lsmartPallet.setId(smartPalletId);
 			
 			return;
 		}
 		goods.setSmartPallet(createEmptySmartPallet(smartPalletId));
 	}
 	 		
 	protected void setShippingSpace(Goods goods, ResultSet rs, int rowNumber) throws SQLException{
 		String shippingSpaceId = rs.getString(GoodsTable.COLUMN_SHIPPING_SPACE);
 		if( shippingSpaceId == null){
 			return;
 		}
 		if( shippingSpaceId.isEmpty()){
 			return;
 		}
 		ShippingSpace lshippingSpace = goods.getShippingSpace();
 		if( lshippingSpace != null ){
 			//if the root object 'goods' already have the property, just set the id for it;
 			lshippingSpace.setId(shippingSpaceId);
 			
 			return;
 		}
 		goods.setShippingSpace(createEmptyShippingSpace(shippingSpaceId));
 	}
 	 		
 	protected void setTransportTask(Goods goods, ResultSet rs, int rowNumber) throws SQLException{
 		String transportTaskId = rs.getString(GoodsTable.COLUMN_TRANSPORT_TASK);
 		if( transportTaskId == null){
 			return;
 		}
 		if( transportTaskId.isEmpty()){
 			return;
 		}
 		TransportTask ltransportTask = goods.getTransportTask();
 		if( ltransportTask != null ){
 			//if the root object 'goods' already have the property, just set the id for it;
 			ltransportTask.setId(transportTaskId);
 			
 			return;
 		}
 		goods.setTransportTask(createEmptyTransportTask(transportTaskId));
 	}
 	 		
 	protected void setRetailStore(Goods goods, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreId = rs.getString(GoodsTable.COLUMN_RETAIL_STORE);
 		if( retailStoreId == null){
 			return;
 		}
 		if( retailStoreId.isEmpty()){
 			return;
 		}
 		RetailStore lretailStore = goods.getRetailStore();
 		if( lretailStore != null ){
 			//if the root object 'goods' already have the property, just set the id for it;
 			lretailStore.setId(retailStoreId);
 			
 			return;
 		}
 		goods.setRetailStore(createEmptyRetailStore(retailStoreId));
 	}
 	 		
 	protected void setBizOrder(Goods goods, ResultSet rs, int rowNumber) throws SQLException{
 		String supplyOrderId = rs.getString(GoodsTable.COLUMN_BIZ_ORDER);
 		if( supplyOrderId == null){
 			return;
 		}
 		if( supplyOrderId.isEmpty()){
 			return;
 		}
 		SupplyOrder lsupplyOrder = goods.getBizOrder();
 		if( lsupplyOrder != null ){
 			//if the root object 'goods' already have the property, just set the id for it;
 			lsupplyOrder.setId(supplyOrderId);
 			
 			return;
 		}
 		goods.setBizOrder(createEmptyBizOrder(supplyOrderId));
 	}
 	 		
 	protected void setRetailStoreOrder(Goods goods, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreOrderId = rs.getString(GoodsTable.COLUMN_RETAIL_STORE_ORDER);
 		if( retailStoreOrderId == null){
 			return;
 		}
 		if( retailStoreOrderId.isEmpty()){
 			return;
 		}
 		RetailStoreOrder lretailStoreOrder = goods.getRetailStoreOrder();
 		if( lretailStoreOrder != null ){
 			//if the root object 'goods' already have the property, just set the id for it;
 			lretailStoreOrder.setId(retailStoreOrderId);
 			
 			return;
 		}
 		goods.setRetailStoreOrder(createEmptyRetailStoreOrder(retailStoreOrderId));
 	}
 	 		
 	protected void setPackaging(Goods goods, ResultSet rs, int rowNumber) throws SQLException{
 		String goodsPackagingId = rs.getString(GoodsTable.COLUMN_PACKAGING);
 		if( goodsPackagingId == null){
 			return;
 		}
 		if( goodsPackagingId.isEmpty()){
 			return;
 		}
 		GoodsPackaging lgoodsPackaging = goods.getPackaging();
 		if( lgoodsPackaging != null ){
 			//if the root object 'goods' already have the property, just set the id for it;
 			lgoodsPackaging.setId(goodsPackagingId);
 			
 			return;
 		}
 		goods.setPackaging(createEmptyPackaging(goodsPackagingId));
 	}
 	
	protected void setCurrentStatus(Goods goods, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String currentStatus = rs.getString(GoodsTable.COLUMN_CURRENT_STATUS);
		if(currentStatus == null){
			//do nothing when nothing found in database
			return;
		}
		
		goods.setCurrentStatus(currentStatus);
	}
		
	protected void setVersion(Goods goods, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(GoodsTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		goods.setVersion(version);
	}
		
		

 	protected Sku  createEmptySku(String skuId){
 		Sku sku = new Sku();
 		sku.setId(skuId);
 		sku.setVersion(Integer.MAX_VALUE);
 		return sku;
 	}
 	
 	protected ReceivingSpace  createEmptyReceivingSpace(String receivingSpaceId){
 		ReceivingSpace receivingSpace = new ReceivingSpace();
 		receivingSpace.setId(receivingSpaceId);
 		receivingSpace.setVersion(Integer.MAX_VALUE);
 		return receivingSpace;
 	}
 	
 	protected GoodsAllocation  createEmptyGoodsAllocation(String goodsAllocationId){
 		GoodsAllocation goodsAllocation = new GoodsAllocation();
 		goodsAllocation.setId(goodsAllocationId);
 		goodsAllocation.setVersion(Integer.MAX_VALUE);
 		return goodsAllocation;
 	}
 	
 	protected SmartPallet  createEmptySmartPallet(String smartPalletId){
 		SmartPallet smartPallet = new SmartPallet();
 		smartPallet.setId(smartPalletId);
 		smartPallet.setVersion(Integer.MAX_VALUE);
 		return smartPallet;
 	}
 	
 	protected ShippingSpace  createEmptyShippingSpace(String shippingSpaceId){
 		ShippingSpace shippingSpace = new ShippingSpace();
 		shippingSpace.setId(shippingSpaceId);
 		shippingSpace.setVersion(Integer.MAX_VALUE);
 		return shippingSpace;
 	}
 	
 	protected TransportTask  createEmptyTransportTask(String transportTaskId){
 		TransportTask transportTask = new TransportTask();
 		transportTask.setId(transportTaskId);
 		transportTask.setVersion(Integer.MAX_VALUE);
 		return transportTask;
 	}
 	
 	protected RetailStore  createEmptyRetailStore(String retailStoreId){
 		RetailStore retailStore = new RetailStore();
 		retailStore.setId(retailStoreId);
 		retailStore.setVersion(Integer.MAX_VALUE);
 		return retailStore;
 	}
 	
 	protected SupplyOrder  createEmptyBizOrder(String supplyOrderId){
 		SupplyOrder supplyOrder = new SupplyOrder();
 		supplyOrder.setId(supplyOrderId);
 		supplyOrder.setVersion(Integer.MAX_VALUE);
 		return supplyOrder;
 	}
 	
 	protected RetailStoreOrder  createEmptyRetailStoreOrder(String retailStoreOrderId){
 		RetailStoreOrder retailStoreOrder = new RetailStoreOrder();
 		retailStoreOrder.setId(retailStoreOrderId);
 		retailStoreOrder.setVersion(Integer.MAX_VALUE);
 		return retailStoreOrder;
 	}
 	
 	protected GoodsPackaging  createEmptyPackaging(String goodsPackagingId){
 		GoodsPackaging goodsPackaging = new GoodsPackaging();
 		goodsPackaging.setId(goodsPackagingId);
 		goodsPackaging.setVersion(Integer.MAX_VALUE);
 		return goodsPackaging;
 	}
 	
}


