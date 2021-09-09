package com.doublechaintech.retailscm.storagespace;

import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelf;
import com.doublechaintech.retailscm.warehouse.Warehouse;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelfRequest;
import com.doublechaintech.retailscm.warehouse.WarehouseRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.storagespace.StorageSpace.*;

public class StorageSpaceRequest extends BaseRequest<StorageSpace> {
    public static StorageSpaceRequest newInstance() {
        return new StorageSpaceRequest().selectId();
    }

    public String getInternalType() {
        return "StorageSpace";
    }

    public StorageSpaceRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public StorageSpaceRequest select(String... names) {
        super.select(names);
        return this;
    }

    public StorageSpaceRequest selectAll() {return this.selectId().selectLocation().selectContactNumber().selectTotalArea().selectWarehouse().selectLatitude().selectLongitude().selectLastUpdateTime().selectVersion();
    }

    public StorageSpaceRequest selectSelf() {return this.selectId().selectLocation().selectContactNumber().selectTotalArea().selectLatitude().selectLongitude().selectLastUpdateTime().selectVersion();
    }

    public StorageSpaceRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public StorageSpaceRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static StorageSpaceRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public StorageSpaceRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public StorageSpaceRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public StorageSpaceRequest selectId(){
          return select(ID_PROPERTY);
      }

      public StorageSpaceRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public StorageSpaceRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public StorageSpaceRequest filterByLocation(String location) {
          
          if (location == null) {
              return this;
          }
          
          return filterByLocation(QueryOperator.EQUAL, location);
      }
    

      public StorageSpaceRequest filterByLocation(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLocationSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public StorageSpaceRequest selectLocation(){
          return select(LOCATION_PROPERTY);
      }

      public StorageSpaceRequest unselectLocation(){
          return unselect(LOCATION_PROPERTY);
      }

      public SearchCriteria getLocationSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LOCATION_PROPERTY, pQueryOperator, parameters);
      }

      public StorageSpaceRequest orderByLocation(boolean asc){
          addOrderBy(LOCATION_PROPERTY, asc);
          return this;
      }
   
      public StorageSpaceRequest filterByContactNumber(String contactNumber) {
          
          if (contactNumber == null) {
              return this;
          }
          
          return filterByContactNumber(QueryOperator.EQUAL, contactNumber);
      }
    

      public StorageSpaceRequest filterByContactNumber(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getContactNumberSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public StorageSpaceRequest selectContactNumber(){
          return select(CONTACT_NUMBER_PROPERTY);
      }

      public StorageSpaceRequest unselectContactNumber(){
          return unselect(CONTACT_NUMBER_PROPERTY);
      }

      public SearchCriteria getContactNumberSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(CONTACT_NUMBER_PROPERTY, pQueryOperator, parameters);
      }

      public StorageSpaceRequest orderByContactNumber(boolean asc){
          addOrderBy(CONTACT_NUMBER_PROPERTY, asc);
          return this;
      }
   
      public StorageSpaceRequest filterByTotalArea(String totalArea) {
          
          if (totalArea == null) {
              return this;
          }
          
          return filterByTotalArea(QueryOperator.EQUAL, totalArea);
      }
    

      public StorageSpaceRequest filterByTotalArea(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getTotalAreaSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public StorageSpaceRequest selectTotalArea(){
          return select(TOTAL_AREA_PROPERTY);
      }

      public StorageSpaceRequest unselectTotalArea(){
          return unselect(TOTAL_AREA_PROPERTY);
      }

      public SearchCriteria getTotalAreaSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(TOTAL_AREA_PROPERTY, pQueryOperator, parameters);
      }

      public StorageSpaceRequest orderByTotalArea(boolean asc){
          addOrderBy(TOTAL_AREA_PROPERTY, asc);
          return this;
      }
   
      public StorageSpaceRequest filterByLatitude(BigDecimal latitude) {
          
          if (latitude == null) {
              return this;
          }
          
          return filterByLatitude(QueryOperator.EQUAL, latitude);
      }
    

      public StorageSpaceRequest filterByLatitude(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLatitudeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public StorageSpaceRequest selectLatitude(){
          return select(LATITUDE_PROPERTY);
      }

      public StorageSpaceRequest unselectLatitude(){
          return unselect(LATITUDE_PROPERTY);
      }

      public SearchCriteria getLatitudeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LATITUDE_PROPERTY, pQueryOperator, parameters);
      }

      public StorageSpaceRequest orderByLatitude(boolean asc){
          addOrderBy(LATITUDE_PROPERTY, asc);
          return this;
      }
   
      public StorageSpaceRequest filterByLongitude(BigDecimal longitude) {
          
          if (longitude == null) {
              return this;
          }
          
          return filterByLongitude(QueryOperator.EQUAL, longitude);
      }
    

      public StorageSpaceRequest filterByLongitude(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLongitudeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public StorageSpaceRequest selectLongitude(){
          return select(LONGITUDE_PROPERTY);
      }

      public StorageSpaceRequest unselectLongitude(){
          return unselect(LONGITUDE_PROPERTY);
      }

      public SearchCriteria getLongitudeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LONGITUDE_PROPERTY, pQueryOperator, parameters);
      }

      public StorageSpaceRequest orderByLongitude(boolean asc){
          addOrderBy(LONGITUDE_PROPERTY, asc);
          return this;
      }
   
      public StorageSpaceRequest filterByLastUpdateTime(DateTime lastUpdateTime) {
          
          if (lastUpdateTime == null) {
              return this;
          }
          
          return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
      }
    

      public StorageSpaceRequest filterByLastUpdateTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public StorageSpaceRequest selectLastUpdateTime(){
          return select(LAST_UPDATE_TIME_PROPERTY);
      }

      public StorageSpaceRequest unselectLastUpdateTime(){
          return unselect(LAST_UPDATE_TIME_PROPERTY);
      }

      public SearchCriteria getLastUpdateTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public StorageSpaceRequest orderByLastUpdateTime(boolean asc){
          addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
          return this;
      }
   
      public StorageSpaceRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public StorageSpaceRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public StorageSpaceRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public StorageSpaceRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public StorageSpaceRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public StorageSpaceRequest filterByWarehouse(WarehouseRequest warehouse){
        return filterByWarehouse(warehouse, warehouseList -> warehouseList.stream().map(Warehouse::getId).collect(Collectors.toSet()));
    }

    public StorageSpaceRequest filterByWarehouse(WarehouseRequest warehouse, IDRefine<Warehouse> idRefine) {
        return addSearchCriteria(createWarehouseCriteria(warehouse, idRefine));
    }

    public SearchCriteria createWarehouseCriteria(WarehouseRequest warehouse, IDRefine<Warehouse> idRefine) {
        return new RefinedIdInCriteria(warehouse, WAREHOUSE_PROPERTY, idRefine);
    }
    

    
    public StorageSpaceRequest selectWarehouse(){
        return selectWarehouse(WarehouseRequest.newInstance().selectSelf());
    }

    public StorageSpaceRequest selectWarehouse(WarehouseRequest warehouse){
        selectParent(WAREHOUSE_PROPERTY, warehouse);
        return this;
    }
    

    public StorageSpaceRequest unselectWarehouse(){
        unselectParent(WAREHOUSE_PROPERTY);
        return this;
    }

  


  

    public StorageSpaceRequest hasGoodsShelf() {
      return hasGoodsShelf(GoodsShelfRequest.newInstance());
    }

    public StorageSpaceRequest hasGoodsShelf(GoodsShelfRequest goodsShelf) {
        return hasGoodsShelf(goodsShelf, goodsShelfList -> goodsShelfList.stream().map(GoodsShelf::getStorageSpace).map(StorageSpace::getId).collect(Collectors.toSet()));
    }

    public StorageSpaceRequest hasGoodsShelf(GoodsShelfRequest goodsShelf, IDRefine<GoodsShelf> idRefine) {
        goodsShelf.select(GoodsShelf.STORAGE_SPACE_PROPERTY);
        return addSearchCriteria(createGoodsShelfCriteria(goodsShelf, idRefine));
    }

    public SearchCriteria createGoodsShelfCriteria(GoodsShelfRequest goodsShelf, IDRefine<GoodsShelf> idRefine){
       return new RefinedIdInCriteria(goodsShelf, ID_PROPERTY, idRefine);
    }

    public StorageSpaceRequest selectGoodsShelfList(GoodsShelfRequest goodsShelf) {
        selectChild(GoodsShelf.STORAGE_SPACE_PROPERTY, goodsShelf);
        return this;
    }

    public StorageSpaceRequest selectGoodsShelfList() {
        return selectGoodsShelfList(GoodsShelfRequest.newInstance().selectAll());
    }

    public StorageSpaceRequest unselectGoodsShelfList(){
        unselectChild(GoodsShelf.STORAGE_SPACE_PROPERTY, GoodsShelf.class);
        return this;
    }
  

   public StorageSpaceRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

