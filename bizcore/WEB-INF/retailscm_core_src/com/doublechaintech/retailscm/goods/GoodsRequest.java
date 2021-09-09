package com.doublechaintech.retailscm.goods;

import com.doublechaintech.retailscm.search.*;
import java.util.Date;
import com.doublechaintech.retailscm.goodsallocation.GoodsAllocation;
import com.doublechaintech.retailscm.goodsmovement.GoodsMovement;
import com.doublechaintech.retailscm.receivingspace.ReceivingSpace;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;
import com.doublechaintech.retailscm.shippingspace.ShippingSpace;
import com.doublechaintech.retailscm.sku.Sku;
import com.doublechaintech.retailscm.smartpallet.SmartPallet;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;
import com.doublechaintech.retailscm.transporttask.TransportTask;
import com.doublechaintech.retailscm.goodsallocation.GoodsAllocationRequest;
import com.doublechaintech.retailscm.goodsmovement.GoodsMovementRequest;
import com.doublechaintech.retailscm.receivingspace.ReceivingSpaceRequest;
import com.doublechaintech.retailscm.retailstore.RetailStoreRequest;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderRequest;
import com.doublechaintech.retailscm.shippingspace.ShippingSpaceRequest;
import com.doublechaintech.retailscm.sku.SkuRequest;
import com.doublechaintech.retailscm.smartpallet.SmartPalletRequest;
import com.doublechaintech.retailscm.supplyorder.SupplyOrderRequest;
import com.doublechaintech.retailscm.transporttask.TransportTaskRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.goods.Goods.*;

public class GoodsRequest extends BaseRequest<Goods> {
    public static GoodsRequest newInstance() {
        return new GoodsRequest().selectId();
    }

    public String getInternalType() {
        return "Goods";
    }

    public GoodsRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public GoodsRequest select(String... names) {
        super.select(names);
        return this;
    }

    public GoodsRequest selectAll() {return this.selectId().selectName().selectRfid().selectUom().selectMaxPackage().selectExpireTime().selectSku().selectReceivingSpace().selectGoodsAllocation().selectSmartPallet().selectShippingSpace().selectTransportTask().selectRetailStore().selectBizOrder().selectRetailStoreOrder().selectVersion();
    }

    public GoodsRequest selectSelf() {return this.selectId().selectName().selectRfid().selectUom().selectMaxPackage().selectExpireTime().selectVersion();
    }

    public GoodsRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public GoodsRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static GoodsRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public GoodsRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public GoodsRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public GoodsRequest selectId(){
          return select(ID_PROPERTY);
      }

      public GoodsRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public GoodsRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public GoodsRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public GoodsRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public GoodsRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public GoodsRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public GoodsRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public GoodsRequest filterByRfid(String rfid) {
          
          if (rfid == null) {
              return this;
          }
          
          return filterByRfid(QueryOperator.EQUAL, rfid);
      }
    

      public GoodsRequest filterByRfid(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getRfidSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public GoodsRequest selectRfid(){
          return select(RFID_PROPERTY);
      }

      public GoodsRequest unselectRfid(){
          return unselect(RFID_PROPERTY);
      }

      public SearchCriteria getRfidSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(RFID_PROPERTY, pQueryOperator, parameters);
      }

      public GoodsRequest orderByRfid(boolean asc){
          addOrderBy(RFID_PROPERTY, asc);
          return this;
      }
   
      public GoodsRequest filterByUom(String uom) {
          
          if (uom == null) {
              return this;
          }
          
          return filterByUom(QueryOperator.EQUAL, uom);
      }
    

      public GoodsRequest filterByUom(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getUomSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public GoodsRequest selectUom(){
          return select(UOM_PROPERTY);
      }

      public GoodsRequest unselectUom(){
          return unselect(UOM_PROPERTY);
      }

      public SearchCriteria getUomSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(UOM_PROPERTY, pQueryOperator, parameters);
      }

      public GoodsRequest orderByUom(boolean asc){
          addOrderBy(UOM_PROPERTY, asc);
          return this;
      }
   
      public GoodsRequest filterByMaxPackage(int maxPackage) {
          
          return filterByMaxPackage(QueryOperator.EQUAL, maxPackage);
      }
    

      public GoodsRequest filterByMaxPackage(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getMaxPackageSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public GoodsRequest selectMaxPackage(){
          return select(MAX_PACKAGE_PROPERTY);
      }

      public GoodsRequest unselectMaxPackage(){
          return unselect(MAX_PACKAGE_PROPERTY);
      }

      public SearchCriteria getMaxPackageSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(MAX_PACKAGE_PROPERTY, pQueryOperator, parameters);
      }

      public GoodsRequest orderByMaxPackage(boolean asc){
          addOrderBy(MAX_PACKAGE_PROPERTY, asc);
          return this;
      }
   
      public GoodsRequest filterByExpireTime(Date expireTime) {
          
          if (expireTime == null) {
              return this;
          }
          
          return filterByExpireTime(QueryOperator.EQUAL, expireTime);
      }
    

      public GoodsRequest filterByExpireTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getExpireTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public GoodsRequest selectExpireTime(){
          return select(EXPIRE_TIME_PROPERTY);
      }

      public GoodsRequest unselectExpireTime(){
          return unselect(EXPIRE_TIME_PROPERTY);
      }

      public SearchCriteria getExpireTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(EXPIRE_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public GoodsRequest orderByExpireTime(boolean asc){
          addOrderBy(EXPIRE_TIME_PROPERTY, asc);
          return this;
      }
   
      public GoodsRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public GoodsRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public GoodsRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public GoodsRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public GoodsRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public GoodsRequest filterBySku(SkuRequest sku){
        return filterBySku(sku, skuList -> skuList.stream().map(Sku::getId).collect(Collectors.toSet()));
    }

    public GoodsRequest filterBySku(SkuRequest sku, IDRefine<Sku> idRefine) {
        return addSearchCriteria(createSkuCriteria(sku, idRefine));
    }

    public SearchCriteria createSkuCriteria(SkuRequest sku, IDRefine<Sku> idRefine) {
        return new RefinedIdInCriteria(sku, SKU_PROPERTY, idRefine);
    }
    

    
    public GoodsRequest selectSku(){
        return selectSku(SkuRequest.newInstance().selectSelf());
    }

    public GoodsRequest selectSku(SkuRequest sku){
        selectParent(SKU_PROPERTY, sku);
        return this;
    }
    

    public GoodsRequest unselectSku(){
        unselectParent(SKU_PROPERTY);
        return this;
    }

  

    
    public GoodsRequest filterByReceivingSpace(ReceivingSpaceRequest receivingSpace){
        return filterByReceivingSpace(receivingSpace, receivingSpaceList -> receivingSpaceList.stream().map(ReceivingSpace::getId).collect(Collectors.toSet()));
    }

    public GoodsRequest filterByReceivingSpace(ReceivingSpaceRequest receivingSpace, IDRefine<ReceivingSpace> idRefine) {
        return addSearchCriteria(createReceivingSpaceCriteria(receivingSpace, idRefine));
    }

    public SearchCriteria createReceivingSpaceCriteria(ReceivingSpaceRequest receivingSpace, IDRefine<ReceivingSpace> idRefine) {
        return new RefinedIdInCriteria(receivingSpace, RECEIVING_SPACE_PROPERTY, idRefine);
    }
    

    
    public GoodsRequest selectReceivingSpace(){
        return selectReceivingSpace(ReceivingSpaceRequest.newInstance().selectSelf());
    }

    public GoodsRequest selectReceivingSpace(ReceivingSpaceRequest receivingSpace){
        selectParent(RECEIVING_SPACE_PROPERTY, receivingSpace);
        return this;
    }
    

    public GoodsRequest unselectReceivingSpace(){
        unselectParent(RECEIVING_SPACE_PROPERTY);
        return this;
    }

  

    
    public GoodsRequest filterByGoodsAllocation(GoodsAllocationRequest goodsAllocation){
        return filterByGoodsAllocation(goodsAllocation, goodsAllocationList -> goodsAllocationList.stream().map(GoodsAllocation::getId).collect(Collectors.toSet()));
    }

    public GoodsRequest filterByGoodsAllocation(GoodsAllocationRequest goodsAllocation, IDRefine<GoodsAllocation> idRefine) {
        return addSearchCriteria(createGoodsAllocationCriteria(goodsAllocation, idRefine));
    }

    public SearchCriteria createGoodsAllocationCriteria(GoodsAllocationRequest goodsAllocation, IDRefine<GoodsAllocation> idRefine) {
        return new RefinedIdInCriteria(goodsAllocation, GOODS_ALLOCATION_PROPERTY, idRefine);
    }
    

    
    public GoodsRequest selectGoodsAllocation(){
        return selectGoodsAllocation(GoodsAllocationRequest.newInstance().selectSelf());
    }

    public GoodsRequest selectGoodsAllocation(GoodsAllocationRequest goodsAllocation){
        selectParent(GOODS_ALLOCATION_PROPERTY, goodsAllocation);
        return this;
    }
    

    public GoodsRequest unselectGoodsAllocation(){
        unselectParent(GOODS_ALLOCATION_PROPERTY);
        return this;
    }

  

    
    public GoodsRequest filterBySmartPallet(SmartPalletRequest smartPallet){
        return filterBySmartPallet(smartPallet, smartPalletList -> smartPalletList.stream().map(SmartPallet::getId).collect(Collectors.toSet()));
    }

    public GoodsRequest filterBySmartPallet(SmartPalletRequest smartPallet, IDRefine<SmartPallet> idRefine) {
        return addSearchCriteria(createSmartPalletCriteria(smartPallet, idRefine));
    }

    public SearchCriteria createSmartPalletCriteria(SmartPalletRequest smartPallet, IDRefine<SmartPallet> idRefine) {
        return new RefinedIdInCriteria(smartPallet, SMART_PALLET_PROPERTY, idRefine);
    }
    

    
    public GoodsRequest selectSmartPallet(){
        return selectSmartPallet(SmartPalletRequest.newInstance().selectSelf());
    }

    public GoodsRequest selectSmartPallet(SmartPalletRequest smartPallet){
        selectParent(SMART_PALLET_PROPERTY, smartPallet);
        return this;
    }
    

    public GoodsRequest unselectSmartPallet(){
        unselectParent(SMART_PALLET_PROPERTY);
        return this;
    }

  

    
    public GoodsRequest filterByShippingSpace(ShippingSpaceRequest shippingSpace){
        return filterByShippingSpace(shippingSpace, shippingSpaceList -> shippingSpaceList.stream().map(ShippingSpace::getId).collect(Collectors.toSet()));
    }

    public GoodsRequest filterByShippingSpace(ShippingSpaceRequest shippingSpace, IDRefine<ShippingSpace> idRefine) {
        return addSearchCriteria(createShippingSpaceCriteria(shippingSpace, idRefine));
    }

    public SearchCriteria createShippingSpaceCriteria(ShippingSpaceRequest shippingSpace, IDRefine<ShippingSpace> idRefine) {
        return new RefinedIdInCriteria(shippingSpace, SHIPPING_SPACE_PROPERTY, idRefine);
    }
    

    
    public GoodsRequest selectShippingSpace(){
        return selectShippingSpace(ShippingSpaceRequest.newInstance().selectSelf());
    }

    public GoodsRequest selectShippingSpace(ShippingSpaceRequest shippingSpace){
        selectParent(SHIPPING_SPACE_PROPERTY, shippingSpace);
        return this;
    }
    

    public GoodsRequest unselectShippingSpace(){
        unselectParent(SHIPPING_SPACE_PROPERTY);
        return this;
    }

  

    
    public GoodsRequest filterByTransportTask(TransportTaskRequest transportTask){
        return filterByTransportTask(transportTask, transportTaskList -> transportTaskList.stream().map(TransportTask::getId).collect(Collectors.toSet()));
    }

    public GoodsRequest filterByTransportTask(TransportTaskRequest transportTask, IDRefine<TransportTask> idRefine) {
        return addSearchCriteria(createTransportTaskCriteria(transportTask, idRefine));
    }

    public SearchCriteria createTransportTaskCriteria(TransportTaskRequest transportTask, IDRefine<TransportTask> idRefine) {
        return new RefinedIdInCriteria(transportTask, TRANSPORT_TASK_PROPERTY, idRefine);
    }
    

    
    public GoodsRequest selectTransportTask(){
        return selectTransportTask(TransportTaskRequest.newInstance().selectSelf());
    }

    public GoodsRequest selectTransportTask(TransportTaskRequest transportTask){
        selectParent(TRANSPORT_TASK_PROPERTY, transportTask);
        return this;
    }
    

    public GoodsRequest unselectTransportTask(){
        unselectParent(TRANSPORT_TASK_PROPERTY);
        return this;
    }

  

    
    public GoodsRequest filterByRetailStore(RetailStoreRequest retailStore){
        return filterByRetailStore(retailStore, retailStoreList -> retailStoreList.stream().map(RetailStore::getId).collect(Collectors.toSet()));
    }

    public GoodsRequest filterByRetailStore(RetailStoreRequest retailStore, IDRefine<RetailStore> idRefine) {
        return addSearchCriteria(createRetailStoreCriteria(retailStore, idRefine));
    }

    public SearchCriteria createRetailStoreCriteria(RetailStoreRequest retailStore, IDRefine<RetailStore> idRefine) {
        return new RefinedIdInCriteria(retailStore, RETAIL_STORE_PROPERTY, idRefine);
    }
    

    
    public GoodsRequest selectRetailStore(){
        return selectRetailStore(RetailStoreRequest.newInstance().selectSelf());
    }

    public GoodsRequest selectRetailStore(RetailStoreRequest retailStore){
        selectParent(RETAIL_STORE_PROPERTY, retailStore);
        return this;
    }
    

    public GoodsRequest unselectRetailStore(){
        unselectParent(RETAIL_STORE_PROPERTY);
        return this;
    }

  

    
    public GoodsRequest filterByBizOrder(SupplyOrderRequest bizOrder){
        return filterByBizOrder(bizOrder, bizOrderList -> bizOrderList.stream().map(SupplyOrder::getId).collect(Collectors.toSet()));
    }

    public GoodsRequest filterByBizOrder(SupplyOrderRequest bizOrder, IDRefine<SupplyOrder> idRefine) {
        return addSearchCriteria(createBizOrderCriteria(bizOrder, idRefine));
    }

    public SearchCriteria createBizOrderCriteria(SupplyOrderRequest bizOrder, IDRefine<SupplyOrder> idRefine) {
        return new RefinedIdInCriteria(bizOrder, BIZ_ORDER_PROPERTY, idRefine);
    }
    

    
    public GoodsRequest selectBizOrder(){
        return selectBizOrder(SupplyOrderRequest.newInstance().selectSelf());
    }

    public GoodsRequest selectBizOrder(SupplyOrderRequest bizOrder){
        selectParent(BIZ_ORDER_PROPERTY, bizOrder);
        return this;
    }
    

    public GoodsRequest unselectBizOrder(){
        unselectParent(BIZ_ORDER_PROPERTY);
        return this;
    }

  

    
    public GoodsRequest filterByRetailStoreOrder(RetailStoreOrderRequest retailStoreOrder){
        return filterByRetailStoreOrder(retailStoreOrder, retailStoreOrderList -> retailStoreOrderList.stream().map(RetailStoreOrder::getId).collect(Collectors.toSet()));
    }

    public GoodsRequest filterByRetailStoreOrder(RetailStoreOrderRequest retailStoreOrder, IDRefine<RetailStoreOrder> idRefine) {
        return addSearchCriteria(createRetailStoreOrderCriteria(retailStoreOrder, idRefine));
    }

    public SearchCriteria createRetailStoreOrderCriteria(RetailStoreOrderRequest retailStoreOrder, IDRefine<RetailStoreOrder> idRefine) {
        return new RefinedIdInCriteria(retailStoreOrder, RETAIL_STORE_ORDER_PROPERTY, idRefine);
    }
    

    
    public GoodsRequest selectRetailStoreOrder(){
        return selectRetailStoreOrder(RetailStoreOrderRequest.newInstance().selectSelf());
    }

    public GoodsRequest selectRetailStoreOrder(RetailStoreOrderRequest retailStoreOrder){
        selectParent(RETAIL_STORE_ORDER_PROPERTY, retailStoreOrder);
        return this;
    }
    

    public GoodsRequest unselectRetailStoreOrder(){
        unselectParent(RETAIL_STORE_ORDER_PROPERTY);
        return this;
    }

  


  

    public GoodsRequest hasGoodsMovement() {
      return hasGoodsMovement(GoodsMovementRequest.newInstance());
    }

    public GoodsRequest hasGoodsMovement(GoodsMovementRequest goodsMovement) {
        return hasGoodsMovement(goodsMovement, goodsMovementList -> goodsMovementList.stream().map(GoodsMovement::getGoods).map(Goods::getId).collect(Collectors.toSet()));
    }

    public GoodsRequest hasGoodsMovement(GoodsMovementRequest goodsMovement, IDRefine<GoodsMovement> idRefine) {
        goodsMovement.select(GoodsMovement.GOODS_PROPERTY);
        return addSearchCriteria(createGoodsMovementCriteria(goodsMovement, idRefine));
    }

    public SearchCriteria createGoodsMovementCriteria(GoodsMovementRequest goodsMovement, IDRefine<GoodsMovement> idRefine){
       return new RefinedIdInCriteria(goodsMovement, ID_PROPERTY, idRefine);
    }

    public GoodsRequest selectGoodsMovementList(GoodsMovementRequest goodsMovement) {
        selectChild(GoodsMovement.GOODS_PROPERTY, goodsMovement);
        return this;
    }

    public GoodsRequest selectGoodsMovementList() {
        return selectGoodsMovementList(GoodsMovementRequest.newInstance().selectAll());
    }

    public GoodsRequest unselectGoodsMovementList(){
        unselectChild(GoodsMovement.GOODS_PROPERTY, GoodsMovement.class);
        return this;
    }
  

   public GoodsRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

