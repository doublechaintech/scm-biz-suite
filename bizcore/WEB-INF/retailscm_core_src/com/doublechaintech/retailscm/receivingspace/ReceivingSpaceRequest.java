package com.doublechaintech.retailscm.receivingspace;

import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.warehouse.Warehouse;
import com.doublechaintech.retailscm.goods.GoodsRequest;
import com.doublechaintech.retailscm.warehouse.WarehouseRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.receivingspace.ReceivingSpace.*;

public class ReceivingSpaceRequest extends BaseRequest<ReceivingSpace> {
    public static ReceivingSpaceRequest newInstance() {
        return new ReceivingSpaceRequest().selectId();
    }

    public String getInternalType() {
        return "ReceivingSpace";
    }

    public ReceivingSpaceRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public ReceivingSpaceRequest select(String... names) {
        super.select(names);
        return this;
    }

    public ReceivingSpaceRequest selectAll() {return this.selectId().selectLocation().selectContactNumber().selectDescription().selectTotalArea().selectWarehouse().selectLatitude().selectLongitude().selectLastUpdateTime().selectVersion();
    }

    public ReceivingSpaceRequest selectSelf() {return this.selectId().selectLocation().selectContactNumber().selectDescription().selectTotalArea().selectLatitude().selectLongitude().selectLastUpdateTime().selectVersion();
    }

    public ReceivingSpaceRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public ReceivingSpaceRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static ReceivingSpaceRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public ReceivingSpaceRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public ReceivingSpaceRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ReceivingSpaceRequest selectId(){
          return select(ID_PROPERTY);
      }

      public ReceivingSpaceRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public ReceivingSpaceRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public ReceivingSpaceRequest filterByLocation(String location) {
          
          if (location == null) {
              return this;
          }
          
          return filterByLocation(QueryOperator.EQUAL, location);
      }
    

      public ReceivingSpaceRequest filterByLocation(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLocationSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ReceivingSpaceRequest selectLocation(){
          return select(LOCATION_PROPERTY);
      }

      public ReceivingSpaceRequest unselectLocation(){
          return unselect(LOCATION_PROPERTY);
      }

      public SearchCriteria getLocationSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LOCATION_PROPERTY, pQueryOperator, parameters);
      }

      public ReceivingSpaceRequest orderByLocation(boolean asc){
          addOrderBy(LOCATION_PROPERTY, asc);
          return this;
      }
   
      public ReceivingSpaceRequest filterByContactNumber(String contactNumber) {
          
          if (contactNumber == null) {
              return this;
          }
          
          return filterByContactNumber(QueryOperator.EQUAL, contactNumber);
      }
    

      public ReceivingSpaceRequest filterByContactNumber(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getContactNumberSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ReceivingSpaceRequest selectContactNumber(){
          return select(CONTACT_NUMBER_PROPERTY);
      }

      public ReceivingSpaceRequest unselectContactNumber(){
          return unselect(CONTACT_NUMBER_PROPERTY);
      }

      public SearchCriteria getContactNumberSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(CONTACT_NUMBER_PROPERTY, pQueryOperator, parameters);
      }

      public ReceivingSpaceRequest orderByContactNumber(boolean asc){
          addOrderBy(CONTACT_NUMBER_PROPERTY, asc);
          return this;
      }
   
      public ReceivingSpaceRequest filterByDescription(String description) {
          
          if (description == null) {
              return this;
          }
          
          return filterByDescription(QueryOperator.EQUAL, description);
      }
    

      public ReceivingSpaceRequest filterByDescription(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ReceivingSpaceRequest selectDescription(){
          return select(DESCRIPTION_PROPERTY);
      }

      public ReceivingSpaceRequest unselectDescription(){
          return unselect(DESCRIPTION_PROPERTY);
      }

      public SearchCriteria getDescriptionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
      }

      public ReceivingSpaceRequest orderByDescription(boolean asc){
          addOrderBy(DESCRIPTION_PROPERTY, asc);
          return this;
      }
   
      public ReceivingSpaceRequest filterByTotalArea(String totalArea) {
          
          if (totalArea == null) {
              return this;
          }
          
          return filterByTotalArea(QueryOperator.EQUAL, totalArea);
      }
    

      public ReceivingSpaceRequest filterByTotalArea(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getTotalAreaSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ReceivingSpaceRequest selectTotalArea(){
          return select(TOTAL_AREA_PROPERTY);
      }

      public ReceivingSpaceRequest unselectTotalArea(){
          return unselect(TOTAL_AREA_PROPERTY);
      }

      public SearchCriteria getTotalAreaSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(TOTAL_AREA_PROPERTY, pQueryOperator, parameters);
      }

      public ReceivingSpaceRequest orderByTotalArea(boolean asc){
          addOrderBy(TOTAL_AREA_PROPERTY, asc);
          return this;
      }
   
      public ReceivingSpaceRequest filterByLatitude(BigDecimal latitude) {
          
          if (latitude == null) {
              return this;
          }
          
          return filterByLatitude(QueryOperator.EQUAL, latitude);
      }
    

      public ReceivingSpaceRequest filterByLatitude(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLatitudeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ReceivingSpaceRequest selectLatitude(){
          return select(LATITUDE_PROPERTY);
      }

      public ReceivingSpaceRequest unselectLatitude(){
          return unselect(LATITUDE_PROPERTY);
      }

      public SearchCriteria getLatitudeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LATITUDE_PROPERTY, pQueryOperator, parameters);
      }

      public ReceivingSpaceRequest orderByLatitude(boolean asc){
          addOrderBy(LATITUDE_PROPERTY, asc);
          return this;
      }
   
      public ReceivingSpaceRequest filterByLongitude(BigDecimal longitude) {
          
          if (longitude == null) {
              return this;
          }
          
          return filterByLongitude(QueryOperator.EQUAL, longitude);
      }
    

      public ReceivingSpaceRequest filterByLongitude(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLongitudeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ReceivingSpaceRequest selectLongitude(){
          return select(LONGITUDE_PROPERTY);
      }

      public ReceivingSpaceRequest unselectLongitude(){
          return unselect(LONGITUDE_PROPERTY);
      }

      public SearchCriteria getLongitudeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LONGITUDE_PROPERTY, pQueryOperator, parameters);
      }

      public ReceivingSpaceRequest orderByLongitude(boolean asc){
          addOrderBy(LONGITUDE_PROPERTY, asc);
          return this;
      }
   
      public ReceivingSpaceRequest filterByLastUpdateTime(DateTime lastUpdateTime) {
          
          if (lastUpdateTime == null) {
              return this;
          }
          
          return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
      }
    

      public ReceivingSpaceRequest filterByLastUpdateTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ReceivingSpaceRequest selectLastUpdateTime(){
          return select(LAST_UPDATE_TIME_PROPERTY);
      }

      public ReceivingSpaceRequest unselectLastUpdateTime(){
          return unselect(LAST_UPDATE_TIME_PROPERTY);
      }

      public SearchCriteria getLastUpdateTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public ReceivingSpaceRequest orderByLastUpdateTime(boolean asc){
          addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
          return this;
      }
   
      public ReceivingSpaceRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public ReceivingSpaceRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ReceivingSpaceRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public ReceivingSpaceRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public ReceivingSpaceRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public ReceivingSpaceRequest filterByWarehouse(WarehouseRequest warehouse){
        return filterByWarehouse(warehouse, warehouseList -> warehouseList.stream().map(Warehouse::getId).collect(Collectors.toSet()));
    }

    public ReceivingSpaceRequest filterByWarehouse(WarehouseRequest warehouse, IDRefine<Warehouse> idRefine) {
        return addSearchCriteria(createWarehouseCriteria(warehouse, idRefine));
    }

    public SearchCriteria createWarehouseCriteria(WarehouseRequest warehouse, IDRefine<Warehouse> idRefine) {
        return new RefinedIdInCriteria(warehouse, WAREHOUSE_PROPERTY, idRefine);
    }
    

    
    public ReceivingSpaceRequest selectWarehouse(){
        return selectWarehouse(WarehouseRequest.newInstance().selectSelf());
    }

    public ReceivingSpaceRequest selectWarehouse(WarehouseRequest warehouse){
        selectParent(WAREHOUSE_PROPERTY, warehouse);
        return this;
    }
    

    public ReceivingSpaceRequest unselectWarehouse(){
        unselectParent(WAREHOUSE_PROPERTY);
        return this;
    }

  


  

    public ReceivingSpaceRequest hasGoods() {
      return hasGoods(GoodsRequest.newInstance());
    }

    public ReceivingSpaceRequest hasGoods(GoodsRequest goods) {
        return hasGoods(goods, goodsList -> goodsList.stream().map(Goods::getReceivingSpace).map(ReceivingSpace::getId).collect(Collectors.toSet()));
    }

    public ReceivingSpaceRequest hasGoods(GoodsRequest goods, IDRefine<Goods> idRefine) {
        goods.select(Goods.RECEIVING_SPACE_PROPERTY);
        return addSearchCriteria(createGoodsCriteria(goods, idRefine));
    }

    public SearchCriteria createGoodsCriteria(GoodsRequest goods, IDRefine<Goods> idRefine){
       return new RefinedIdInCriteria(goods, ID_PROPERTY, idRefine);
    }

    public ReceivingSpaceRequest selectGoodsList(GoodsRequest goods) {
        selectChild(Goods.RECEIVING_SPACE_PROPERTY, goods);
        return this;
    }

    public ReceivingSpaceRequest selectGoodsList() {
        return selectGoodsList(GoodsRequest.newInstance().selectAll());
    }

    public ReceivingSpaceRequest unselectGoodsList(){
        unselectChild(Goods.RECEIVING_SPACE_PROPERTY, Goods.class);
        return this;
    }
  

   public ReceivingSpaceRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

