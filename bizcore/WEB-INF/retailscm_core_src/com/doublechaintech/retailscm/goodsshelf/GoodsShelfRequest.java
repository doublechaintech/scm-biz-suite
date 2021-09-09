package com.doublechaintech.retailscm.goodsshelf;

import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.damagespace.DamageSpace;
import com.doublechaintech.retailscm.goodsallocation.GoodsAllocation;
import com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCount;
import com.doublechaintech.retailscm.storagespace.StorageSpace;
import com.doublechaintech.retailscm.supplierspace.SupplierSpace;
import com.doublechaintech.retailscm.damagespace.DamageSpaceRequest;
import com.doublechaintech.retailscm.goodsallocation.GoodsAllocationRequest;
import com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCountRequest;
import com.doublechaintech.retailscm.storagespace.StorageSpaceRequest;
import com.doublechaintech.retailscm.supplierspace.SupplierSpaceRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.goodsshelf.GoodsShelf.*;

public class GoodsShelfRequest extends BaseRequest<GoodsShelf> {
    public static GoodsShelfRequest newInstance() {
        return new GoodsShelfRequest().selectId();
    }

    public String getInternalType() {
        return "GoodsShelf";
    }

    public GoodsShelfRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public GoodsShelfRequest select(String... names) {
        super.select(names);
        return this;
    }

    public GoodsShelfRequest selectAll() {return this.selectId().selectLocation().selectStorageSpace().selectSupplierSpace().selectDamageSpace().selectLastUpdateTime().selectVersion();
    }

    public GoodsShelfRequest selectSelf() {return this.selectId().selectLocation().selectLastUpdateTime().selectVersion();
    }

    public GoodsShelfRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public GoodsShelfRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static GoodsShelfRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public GoodsShelfRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public GoodsShelfRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public GoodsShelfRequest selectId(){
          return select(ID_PROPERTY);
      }

      public GoodsShelfRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public GoodsShelfRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public GoodsShelfRequest filterByLocation(String location) {
          
          if (location == null) {
              return this;
          }
          
          return filterByLocation(QueryOperator.EQUAL, location);
      }
    

      public GoodsShelfRequest filterByLocation(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLocationSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public GoodsShelfRequest selectLocation(){
          return select(LOCATION_PROPERTY);
      }

      public GoodsShelfRequest unselectLocation(){
          return unselect(LOCATION_PROPERTY);
      }

      public SearchCriteria getLocationSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LOCATION_PROPERTY, pQueryOperator, parameters);
      }

      public GoodsShelfRequest orderByLocation(boolean asc){
          addOrderBy(LOCATION_PROPERTY, asc);
          return this;
      }
   
      public GoodsShelfRequest filterByLastUpdateTime(DateTime lastUpdateTime) {
          
          if (lastUpdateTime == null) {
              return this;
          }
          
          return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
      }
    

      public GoodsShelfRequest filterByLastUpdateTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public GoodsShelfRequest selectLastUpdateTime(){
          return select(LAST_UPDATE_TIME_PROPERTY);
      }

      public GoodsShelfRequest unselectLastUpdateTime(){
          return unselect(LAST_UPDATE_TIME_PROPERTY);
      }

      public SearchCriteria getLastUpdateTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public GoodsShelfRequest orderByLastUpdateTime(boolean asc){
          addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
          return this;
      }
   
      public GoodsShelfRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public GoodsShelfRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public GoodsShelfRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public GoodsShelfRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public GoodsShelfRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public GoodsShelfRequest filterByStorageSpace(StorageSpaceRequest storageSpace){
        return filterByStorageSpace(storageSpace, storageSpaceList -> storageSpaceList.stream().map(StorageSpace::getId).collect(Collectors.toSet()));
    }

    public GoodsShelfRequest filterByStorageSpace(StorageSpaceRequest storageSpace, IDRefine<StorageSpace> idRefine) {
        return addSearchCriteria(createStorageSpaceCriteria(storageSpace, idRefine));
    }

    public SearchCriteria createStorageSpaceCriteria(StorageSpaceRequest storageSpace, IDRefine<StorageSpace> idRefine) {
        return new RefinedIdInCriteria(storageSpace, STORAGE_SPACE_PROPERTY, idRefine);
    }
    

    
    public GoodsShelfRequest selectStorageSpace(){
        return selectStorageSpace(StorageSpaceRequest.newInstance().selectSelf());
    }

    public GoodsShelfRequest selectStorageSpace(StorageSpaceRequest storageSpace){
        selectParent(STORAGE_SPACE_PROPERTY, storageSpace);
        return this;
    }
    

    public GoodsShelfRequest unselectStorageSpace(){
        unselectParent(STORAGE_SPACE_PROPERTY);
        return this;
    }

  

    
    public GoodsShelfRequest filterBySupplierSpace(SupplierSpaceRequest supplierSpace){
        return filterBySupplierSpace(supplierSpace, supplierSpaceList -> supplierSpaceList.stream().map(SupplierSpace::getId).collect(Collectors.toSet()));
    }

    public GoodsShelfRequest filterBySupplierSpace(SupplierSpaceRequest supplierSpace, IDRefine<SupplierSpace> idRefine) {
        return addSearchCriteria(createSupplierSpaceCriteria(supplierSpace, idRefine));
    }

    public SearchCriteria createSupplierSpaceCriteria(SupplierSpaceRequest supplierSpace, IDRefine<SupplierSpace> idRefine) {
        return new RefinedIdInCriteria(supplierSpace, SUPPLIER_SPACE_PROPERTY, idRefine);
    }
    

    
    public GoodsShelfRequest selectSupplierSpace(){
        return selectSupplierSpace(SupplierSpaceRequest.newInstance().selectSelf());
    }

    public GoodsShelfRequest selectSupplierSpace(SupplierSpaceRequest supplierSpace){
        selectParent(SUPPLIER_SPACE_PROPERTY, supplierSpace);
        return this;
    }
    

    public GoodsShelfRequest unselectSupplierSpace(){
        unselectParent(SUPPLIER_SPACE_PROPERTY);
        return this;
    }

  

    
    public GoodsShelfRequest filterByDamageSpace(DamageSpaceRequest damageSpace){
        return filterByDamageSpace(damageSpace, damageSpaceList -> damageSpaceList.stream().map(DamageSpace::getId).collect(Collectors.toSet()));
    }

    public GoodsShelfRequest filterByDamageSpace(DamageSpaceRequest damageSpace, IDRefine<DamageSpace> idRefine) {
        return addSearchCriteria(createDamageSpaceCriteria(damageSpace, idRefine));
    }

    public SearchCriteria createDamageSpaceCriteria(DamageSpaceRequest damageSpace, IDRefine<DamageSpace> idRefine) {
        return new RefinedIdInCriteria(damageSpace, DAMAGE_SPACE_PROPERTY, idRefine);
    }
    

    
    public GoodsShelfRequest selectDamageSpace(){
        return selectDamageSpace(DamageSpaceRequest.newInstance().selectSelf());
    }

    public GoodsShelfRequest selectDamageSpace(DamageSpaceRequest damageSpace){
        selectParent(DAMAGE_SPACE_PROPERTY, damageSpace);
        return this;
    }
    

    public GoodsShelfRequest unselectDamageSpace(){
        unselectParent(DAMAGE_SPACE_PROPERTY);
        return this;
    }

  


  

    public GoodsShelfRequest hasGoodsShelfStockCount() {
      return hasGoodsShelfStockCount(GoodsShelfStockCountRequest.newInstance());
    }

    public GoodsShelfRequest hasGoodsShelfStockCount(GoodsShelfStockCountRequest goodsShelfStockCount) {
        return hasGoodsShelfStockCount(goodsShelfStockCount, goodsShelfStockCountList -> goodsShelfStockCountList.stream().map(GoodsShelfStockCount::getShelf).map(GoodsShelf::getId).collect(Collectors.toSet()));
    }

    public GoodsShelfRequest hasGoodsShelfStockCount(GoodsShelfStockCountRequest goodsShelfStockCount, IDRefine<GoodsShelfStockCount> idRefine) {
        goodsShelfStockCount.select(GoodsShelfStockCount.SHELF_PROPERTY);
        return addSearchCriteria(createGoodsShelfStockCountCriteria(goodsShelfStockCount, idRefine));
    }

    public SearchCriteria createGoodsShelfStockCountCriteria(GoodsShelfStockCountRequest goodsShelfStockCount, IDRefine<GoodsShelfStockCount> idRefine){
       return new RefinedIdInCriteria(goodsShelfStockCount, ID_PROPERTY, idRefine);
    }

    public GoodsShelfRequest selectGoodsShelfStockCountList(GoodsShelfStockCountRequest goodsShelfStockCount) {
        selectChild(GoodsShelfStockCount.SHELF_PROPERTY, goodsShelfStockCount);
        return this;
    }

    public GoodsShelfRequest selectGoodsShelfStockCountList() {
        return selectGoodsShelfStockCountList(GoodsShelfStockCountRequest.newInstance().selectAll());
    }

    public GoodsShelfRequest unselectGoodsShelfStockCountList(){
        unselectChild(GoodsShelfStockCount.SHELF_PROPERTY, GoodsShelfStockCount.class);
        return this;
    }
  

    public GoodsShelfRequest hasGoodsAllocation() {
      return hasGoodsAllocation(GoodsAllocationRequest.newInstance());
    }

    public GoodsShelfRequest hasGoodsAllocation(GoodsAllocationRequest goodsAllocation) {
        return hasGoodsAllocation(goodsAllocation, goodsAllocationList -> goodsAllocationList.stream().map(GoodsAllocation::getGoodsShelf).map(GoodsShelf::getId).collect(Collectors.toSet()));
    }

    public GoodsShelfRequest hasGoodsAllocation(GoodsAllocationRequest goodsAllocation, IDRefine<GoodsAllocation> idRefine) {
        goodsAllocation.select(GoodsAllocation.GOODS_SHELF_PROPERTY);
        return addSearchCriteria(createGoodsAllocationCriteria(goodsAllocation, idRefine));
    }

    public SearchCriteria createGoodsAllocationCriteria(GoodsAllocationRequest goodsAllocation, IDRefine<GoodsAllocation> idRefine){
       return new RefinedIdInCriteria(goodsAllocation, ID_PROPERTY, idRefine);
    }

    public GoodsShelfRequest selectGoodsAllocationList(GoodsAllocationRequest goodsAllocation) {
        selectChild(GoodsAllocation.GOODS_SHELF_PROPERTY, goodsAllocation);
        return this;
    }

    public GoodsShelfRequest selectGoodsAllocationList() {
        return selectGoodsAllocationList(GoodsAllocationRequest.newInstance().selectAll());
    }

    public GoodsShelfRequest unselectGoodsAllocationList(){
        unselectChild(GoodsAllocation.GOODS_SHELF_PROPERTY, GoodsAllocation.class);
        return this;
    }
  

   public GoodsShelfRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

