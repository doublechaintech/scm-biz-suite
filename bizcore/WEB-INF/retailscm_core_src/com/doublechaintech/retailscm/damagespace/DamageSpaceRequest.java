package com.doublechaintech.retailscm.damagespace;

import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelf;
import com.doublechaintech.retailscm.warehouse.Warehouse;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelfRequest;
import com.doublechaintech.retailscm.warehouse.WarehouseRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.damagespace.DamageSpace.*;

public class DamageSpaceRequest extends BaseRequest<DamageSpace> {
    public static DamageSpaceRequest newInstance() {
        return new DamageSpaceRequest().selectId();
    }

    public String getInternalType() {
        return "DamageSpace";
    }

    public DamageSpaceRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public DamageSpaceRequest select(String... names) {
        super.select(names);
        return this;
    }

    public DamageSpaceRequest selectAll() {return this.selectId().selectLocation().selectContactNumber().selectTotalArea().selectLatitude().selectLongitude().selectWarehouse().selectLastUpdateTime().selectVersion();
    }

    public DamageSpaceRequest selectSelf() {return this.selectId().selectLocation().selectContactNumber().selectTotalArea().selectLatitude().selectLongitude().selectLastUpdateTime().selectVersion();
    }

    public DamageSpaceRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public DamageSpaceRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static DamageSpaceRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public DamageSpaceRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public DamageSpaceRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public DamageSpaceRequest selectId(){
          return select(ID_PROPERTY);
      }

      public DamageSpaceRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public DamageSpaceRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public DamageSpaceRequest filterByLocation(String location) {
          
          if (location == null) {
              return this;
          }
          
          return filterByLocation(QueryOperator.EQUAL, location);
      }
    

      public DamageSpaceRequest filterByLocation(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLocationSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public DamageSpaceRequest selectLocation(){
          return select(LOCATION_PROPERTY);
      }

      public DamageSpaceRequest unselectLocation(){
          return unselect(LOCATION_PROPERTY);
      }

      public SearchCriteria getLocationSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LOCATION_PROPERTY, pQueryOperator, parameters);
      }

      public DamageSpaceRequest orderByLocation(boolean asc){
          addOrderBy(LOCATION_PROPERTY, asc);
          return this;
      }
   
      public DamageSpaceRequest filterByContactNumber(String contactNumber) {
          
          if (contactNumber == null) {
              return this;
          }
          
          return filterByContactNumber(QueryOperator.EQUAL, contactNumber);
      }
    

      public DamageSpaceRequest filterByContactNumber(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getContactNumberSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public DamageSpaceRequest selectContactNumber(){
          return select(CONTACT_NUMBER_PROPERTY);
      }

      public DamageSpaceRequest unselectContactNumber(){
          return unselect(CONTACT_NUMBER_PROPERTY);
      }

      public SearchCriteria getContactNumberSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(CONTACT_NUMBER_PROPERTY, pQueryOperator, parameters);
      }

      public DamageSpaceRequest orderByContactNumber(boolean asc){
          addOrderBy(CONTACT_NUMBER_PROPERTY, asc);
          return this;
      }
   
      public DamageSpaceRequest filterByTotalArea(String totalArea) {
          
          if (totalArea == null) {
              return this;
          }
          
          return filterByTotalArea(QueryOperator.EQUAL, totalArea);
      }
    

      public DamageSpaceRequest filterByTotalArea(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getTotalAreaSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public DamageSpaceRequest selectTotalArea(){
          return select(TOTAL_AREA_PROPERTY);
      }

      public DamageSpaceRequest unselectTotalArea(){
          return unselect(TOTAL_AREA_PROPERTY);
      }

      public SearchCriteria getTotalAreaSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(TOTAL_AREA_PROPERTY, pQueryOperator, parameters);
      }

      public DamageSpaceRequest orderByTotalArea(boolean asc){
          addOrderBy(TOTAL_AREA_PROPERTY, asc);
          return this;
      }
   
      public DamageSpaceRequest filterByLatitude(BigDecimal latitude) {
          
          if (latitude == null) {
              return this;
          }
          
          return filterByLatitude(QueryOperator.EQUAL, latitude);
      }
    

      public DamageSpaceRequest filterByLatitude(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLatitudeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public DamageSpaceRequest selectLatitude(){
          return select(LATITUDE_PROPERTY);
      }

      public DamageSpaceRequest unselectLatitude(){
          return unselect(LATITUDE_PROPERTY);
      }

      public SearchCriteria getLatitudeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LATITUDE_PROPERTY, pQueryOperator, parameters);
      }

      public DamageSpaceRequest orderByLatitude(boolean asc){
          addOrderBy(LATITUDE_PROPERTY, asc);
          return this;
      }
   
      public DamageSpaceRequest filterByLongitude(BigDecimal longitude) {
          
          if (longitude == null) {
              return this;
          }
          
          return filterByLongitude(QueryOperator.EQUAL, longitude);
      }
    

      public DamageSpaceRequest filterByLongitude(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLongitudeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public DamageSpaceRequest selectLongitude(){
          return select(LONGITUDE_PROPERTY);
      }

      public DamageSpaceRequest unselectLongitude(){
          return unselect(LONGITUDE_PROPERTY);
      }

      public SearchCriteria getLongitudeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LONGITUDE_PROPERTY, pQueryOperator, parameters);
      }

      public DamageSpaceRequest orderByLongitude(boolean asc){
          addOrderBy(LONGITUDE_PROPERTY, asc);
          return this;
      }
   
      public DamageSpaceRequest filterByLastUpdateTime(DateTime lastUpdateTime) {
          
          if (lastUpdateTime == null) {
              return this;
          }
          
          return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
      }
    

      public DamageSpaceRequest filterByLastUpdateTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public DamageSpaceRequest selectLastUpdateTime(){
          return select(LAST_UPDATE_TIME_PROPERTY);
      }

      public DamageSpaceRequest unselectLastUpdateTime(){
          return unselect(LAST_UPDATE_TIME_PROPERTY);
      }

      public SearchCriteria getLastUpdateTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public DamageSpaceRequest orderByLastUpdateTime(boolean asc){
          addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
          return this;
      }
   
      public DamageSpaceRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public DamageSpaceRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public DamageSpaceRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public DamageSpaceRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public DamageSpaceRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public DamageSpaceRequest filterByWarehouse(WarehouseRequest warehouse){
        return filterByWarehouse(warehouse, warehouseList -> warehouseList.stream().map(Warehouse::getId).collect(Collectors.toSet()));
    }

    public DamageSpaceRequest filterByWarehouse(WarehouseRequest warehouse, IDRefine<Warehouse> idRefine) {
        return addSearchCriteria(createWarehouseCriteria(warehouse, idRefine));
    }

    public SearchCriteria createWarehouseCriteria(WarehouseRequest warehouse, IDRefine<Warehouse> idRefine) {
        return new RefinedIdInCriteria(warehouse, WAREHOUSE_PROPERTY, idRefine);
    }
    

    
    public DamageSpaceRequest selectWarehouse(){
        return selectWarehouse(WarehouseRequest.newInstance().selectSelf());
    }

    public DamageSpaceRequest selectWarehouse(WarehouseRequest warehouse){
        selectParent(WAREHOUSE_PROPERTY, warehouse);
        return this;
    }
    

    public DamageSpaceRequest unselectWarehouse(){
        unselectParent(WAREHOUSE_PROPERTY);
        return this;
    }

  


  

    public DamageSpaceRequest hasGoodsShelf() {
      return hasGoodsShelf(GoodsShelfRequest.newInstance());
    }

    public DamageSpaceRequest hasGoodsShelf(GoodsShelfRequest goodsShelf) {
        return hasGoodsShelf(goodsShelf, goodsShelfList -> goodsShelfList.stream().map(GoodsShelf::getDamageSpace).map(DamageSpace::getId).collect(Collectors.toSet()));
    }

    public DamageSpaceRequest hasGoodsShelf(GoodsShelfRequest goodsShelf, IDRefine<GoodsShelf> idRefine) {
        goodsShelf.select(GoodsShelf.DAMAGE_SPACE_PROPERTY);
        return addSearchCriteria(createGoodsShelfCriteria(goodsShelf, idRefine));
    }

    public SearchCriteria createGoodsShelfCriteria(GoodsShelfRequest goodsShelf, IDRefine<GoodsShelf> idRefine){
       return new RefinedIdInCriteria(goodsShelf, ID_PROPERTY, idRefine);
    }

    public DamageSpaceRequest selectGoodsShelfList(GoodsShelfRequest goodsShelf) {
        selectChild(GoodsShelf.DAMAGE_SPACE_PROPERTY, goodsShelf);
        return this;
    }

    public DamageSpaceRequest selectGoodsShelfList() {
        return selectGoodsShelfList(GoodsShelfRequest.newInstance().selectAll());
    }

    public DamageSpaceRequest unselectGoodsShelfList(){
        unselectChild(GoodsShelf.DAMAGE_SPACE_PROPERTY, GoodsShelf.class);
        return this;
    }
  

   public DamageSpaceRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

