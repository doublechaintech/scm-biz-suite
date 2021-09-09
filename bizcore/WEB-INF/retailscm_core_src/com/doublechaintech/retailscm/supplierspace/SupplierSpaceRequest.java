package com.doublechaintech.retailscm.supplierspace;

import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelf;
import com.doublechaintech.retailscm.warehouse.Warehouse;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelfRequest;
import com.doublechaintech.retailscm.warehouse.WarehouseRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.supplierspace.SupplierSpace.*;

public class SupplierSpaceRequest extends BaseRequest<SupplierSpace> {
    public static SupplierSpaceRequest newInstance() {
        return new SupplierSpaceRequest().selectId();
    }

    public String getInternalType() {
        return "SupplierSpace";
    }

    public SupplierSpaceRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public SupplierSpaceRequest select(String... names) {
        super.select(names);
        return this;
    }

    public SupplierSpaceRequest selectAll() {return this.selectId().selectLocation().selectContactNumber().selectTotalArea().selectWarehouse().selectLatitude().selectLongitude().selectLastUpdateTime().selectVersion();
    }

    public SupplierSpaceRequest selectSelf() {return this.selectId().selectLocation().selectContactNumber().selectTotalArea().selectLatitude().selectLongitude().selectLastUpdateTime().selectVersion();
    }

    public SupplierSpaceRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public SupplierSpaceRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static SupplierSpaceRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public SupplierSpaceRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public SupplierSpaceRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SupplierSpaceRequest selectId(){
          return select(ID_PROPERTY);
      }

      public SupplierSpaceRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public SupplierSpaceRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public SupplierSpaceRequest filterByLocation(String location) {
          
          if (location == null) {
              return this;
          }
          
          return filterByLocation(QueryOperator.EQUAL, location);
      }
    

      public SupplierSpaceRequest filterByLocation(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLocationSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SupplierSpaceRequest selectLocation(){
          return select(LOCATION_PROPERTY);
      }

      public SupplierSpaceRequest unselectLocation(){
          return unselect(LOCATION_PROPERTY);
      }

      public SearchCriteria getLocationSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LOCATION_PROPERTY, pQueryOperator, parameters);
      }

      public SupplierSpaceRequest orderByLocation(boolean asc){
          addOrderBy(LOCATION_PROPERTY, asc);
          return this;
      }
   
      public SupplierSpaceRequest filterByContactNumber(String contactNumber) {
          
          if (contactNumber == null) {
              return this;
          }
          
          return filterByContactNumber(QueryOperator.EQUAL, contactNumber);
      }
    

      public SupplierSpaceRequest filterByContactNumber(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getContactNumberSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SupplierSpaceRequest selectContactNumber(){
          return select(CONTACT_NUMBER_PROPERTY);
      }

      public SupplierSpaceRequest unselectContactNumber(){
          return unselect(CONTACT_NUMBER_PROPERTY);
      }

      public SearchCriteria getContactNumberSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(CONTACT_NUMBER_PROPERTY, pQueryOperator, parameters);
      }

      public SupplierSpaceRequest orderByContactNumber(boolean asc){
          addOrderBy(CONTACT_NUMBER_PROPERTY, asc);
          return this;
      }
   
      public SupplierSpaceRequest filterByTotalArea(String totalArea) {
          
          if (totalArea == null) {
              return this;
          }
          
          return filterByTotalArea(QueryOperator.EQUAL, totalArea);
      }
    

      public SupplierSpaceRequest filterByTotalArea(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getTotalAreaSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SupplierSpaceRequest selectTotalArea(){
          return select(TOTAL_AREA_PROPERTY);
      }

      public SupplierSpaceRequest unselectTotalArea(){
          return unselect(TOTAL_AREA_PROPERTY);
      }

      public SearchCriteria getTotalAreaSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(TOTAL_AREA_PROPERTY, pQueryOperator, parameters);
      }

      public SupplierSpaceRequest orderByTotalArea(boolean asc){
          addOrderBy(TOTAL_AREA_PROPERTY, asc);
          return this;
      }
   
      public SupplierSpaceRequest filterByLatitude(BigDecimal latitude) {
          
          if (latitude == null) {
              return this;
          }
          
          return filterByLatitude(QueryOperator.EQUAL, latitude);
      }
    

      public SupplierSpaceRequest filterByLatitude(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLatitudeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SupplierSpaceRequest selectLatitude(){
          return select(LATITUDE_PROPERTY);
      }

      public SupplierSpaceRequest unselectLatitude(){
          return unselect(LATITUDE_PROPERTY);
      }

      public SearchCriteria getLatitudeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LATITUDE_PROPERTY, pQueryOperator, parameters);
      }

      public SupplierSpaceRequest orderByLatitude(boolean asc){
          addOrderBy(LATITUDE_PROPERTY, asc);
          return this;
      }
   
      public SupplierSpaceRequest filterByLongitude(BigDecimal longitude) {
          
          if (longitude == null) {
              return this;
          }
          
          return filterByLongitude(QueryOperator.EQUAL, longitude);
      }
    

      public SupplierSpaceRequest filterByLongitude(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLongitudeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SupplierSpaceRequest selectLongitude(){
          return select(LONGITUDE_PROPERTY);
      }

      public SupplierSpaceRequest unselectLongitude(){
          return unselect(LONGITUDE_PROPERTY);
      }

      public SearchCriteria getLongitudeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LONGITUDE_PROPERTY, pQueryOperator, parameters);
      }

      public SupplierSpaceRequest orderByLongitude(boolean asc){
          addOrderBy(LONGITUDE_PROPERTY, asc);
          return this;
      }
   
      public SupplierSpaceRequest filterByLastUpdateTime(DateTime lastUpdateTime) {
          
          if (lastUpdateTime == null) {
              return this;
          }
          
          return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
      }
    

      public SupplierSpaceRequest filterByLastUpdateTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SupplierSpaceRequest selectLastUpdateTime(){
          return select(LAST_UPDATE_TIME_PROPERTY);
      }

      public SupplierSpaceRequest unselectLastUpdateTime(){
          return unselect(LAST_UPDATE_TIME_PROPERTY);
      }

      public SearchCriteria getLastUpdateTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public SupplierSpaceRequest orderByLastUpdateTime(boolean asc){
          addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
          return this;
      }
   
      public SupplierSpaceRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public SupplierSpaceRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SupplierSpaceRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public SupplierSpaceRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public SupplierSpaceRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public SupplierSpaceRequest filterByWarehouse(WarehouseRequest warehouse){
        return filterByWarehouse(warehouse, warehouseList -> warehouseList.stream().map(Warehouse::getId).collect(Collectors.toSet()));
    }

    public SupplierSpaceRequest filterByWarehouse(WarehouseRequest warehouse, IDRefine<Warehouse> idRefine) {
        return addSearchCriteria(createWarehouseCriteria(warehouse, idRefine));
    }

    public SearchCriteria createWarehouseCriteria(WarehouseRequest warehouse, IDRefine<Warehouse> idRefine) {
        return new RefinedIdInCriteria(warehouse, WAREHOUSE_PROPERTY, idRefine);
    }
    

    
    public SupplierSpaceRequest selectWarehouse(){
        return selectWarehouse(WarehouseRequest.newInstance().selectSelf());
    }

    public SupplierSpaceRequest selectWarehouse(WarehouseRequest warehouse){
        selectParent(WAREHOUSE_PROPERTY, warehouse);
        return this;
    }
    

    public SupplierSpaceRequest unselectWarehouse(){
        unselectParent(WAREHOUSE_PROPERTY);
        return this;
    }

  


  

    public SupplierSpaceRequest hasGoodsShelf() {
      return hasGoodsShelf(GoodsShelfRequest.newInstance());
    }

    public SupplierSpaceRequest hasGoodsShelf(GoodsShelfRequest goodsShelf) {
        return hasGoodsShelf(goodsShelf, goodsShelfList -> goodsShelfList.stream().map(GoodsShelf::getSupplierSpace).map(SupplierSpace::getId).collect(Collectors.toSet()));
    }

    public SupplierSpaceRequest hasGoodsShelf(GoodsShelfRequest goodsShelf, IDRefine<GoodsShelf> idRefine) {
        goodsShelf.select(GoodsShelf.SUPPLIER_SPACE_PROPERTY);
        return addSearchCriteria(createGoodsShelfCriteria(goodsShelf, idRefine));
    }

    public SearchCriteria createGoodsShelfCriteria(GoodsShelfRequest goodsShelf, IDRefine<GoodsShelf> idRefine){
       return new RefinedIdInCriteria(goodsShelf, ID_PROPERTY, idRefine);
    }

    public SupplierSpaceRequest selectGoodsShelfList(GoodsShelfRequest goodsShelf) {
        selectChild(GoodsShelf.SUPPLIER_SPACE_PROPERTY, goodsShelf);
        return this;
    }

    public SupplierSpaceRequest selectGoodsShelfList() {
        return selectGoodsShelfList(GoodsShelfRequest.newInstance().selectAll());
    }

    public SupplierSpaceRequest unselectGoodsShelfList(){
        unselectChild(GoodsShelf.SUPPLIER_SPACE_PROPERTY, GoodsShelf.class);
        return this;
    }
  

   public SupplierSpaceRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

