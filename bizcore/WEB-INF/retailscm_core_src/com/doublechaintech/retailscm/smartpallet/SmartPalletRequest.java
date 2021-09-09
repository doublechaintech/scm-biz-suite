package com.doublechaintech.retailscm.smartpallet;

import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.warehouse.Warehouse;
import com.doublechaintech.retailscm.goods.GoodsRequest;
import com.doublechaintech.retailscm.warehouse.WarehouseRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.smartpallet.SmartPallet.*;

public class SmartPalletRequest extends BaseRequest<SmartPallet> {
    public static SmartPalletRequest newInstance() {
        return new SmartPalletRequest().selectId();
    }

    public String getInternalType() {
        return "SmartPallet";
    }

    public SmartPalletRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public SmartPalletRequest select(String... names) {
        super.select(names);
        return this;
    }

    public SmartPalletRequest selectAll() {return this.selectId().selectLocation().selectContactNumber().selectTotalArea().selectLatitude().selectLongitude().selectWarehouse().selectLastUpdateTime().selectVersion();
    }

    public SmartPalletRequest selectSelf() {return this.selectId().selectLocation().selectContactNumber().selectTotalArea().selectLatitude().selectLongitude().selectLastUpdateTime().selectVersion();
    }

    public SmartPalletRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public SmartPalletRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static SmartPalletRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public SmartPalletRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public SmartPalletRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SmartPalletRequest selectId(){
          return select(ID_PROPERTY);
      }

      public SmartPalletRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public SmartPalletRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public SmartPalletRequest filterByLocation(String location) {
          
          if (location == null) {
              return this;
          }
          
          return filterByLocation(QueryOperator.EQUAL, location);
      }
    

      public SmartPalletRequest filterByLocation(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLocationSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SmartPalletRequest selectLocation(){
          return select(LOCATION_PROPERTY);
      }

      public SmartPalletRequest unselectLocation(){
          return unselect(LOCATION_PROPERTY);
      }

      public SearchCriteria getLocationSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LOCATION_PROPERTY, pQueryOperator, parameters);
      }

      public SmartPalletRequest orderByLocation(boolean asc){
          addOrderBy(LOCATION_PROPERTY, asc);
          return this;
      }
   
      public SmartPalletRequest filterByContactNumber(String contactNumber) {
          
          if (contactNumber == null) {
              return this;
          }
          
          return filterByContactNumber(QueryOperator.EQUAL, contactNumber);
      }
    

      public SmartPalletRequest filterByContactNumber(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getContactNumberSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SmartPalletRequest selectContactNumber(){
          return select(CONTACT_NUMBER_PROPERTY);
      }

      public SmartPalletRequest unselectContactNumber(){
          return unselect(CONTACT_NUMBER_PROPERTY);
      }

      public SearchCriteria getContactNumberSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(CONTACT_NUMBER_PROPERTY, pQueryOperator, parameters);
      }

      public SmartPalletRequest orderByContactNumber(boolean asc){
          addOrderBy(CONTACT_NUMBER_PROPERTY, asc);
          return this;
      }
   
      public SmartPalletRequest filterByTotalArea(String totalArea) {
          
          if (totalArea == null) {
              return this;
          }
          
          return filterByTotalArea(QueryOperator.EQUAL, totalArea);
      }
    

      public SmartPalletRequest filterByTotalArea(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getTotalAreaSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SmartPalletRequest selectTotalArea(){
          return select(TOTAL_AREA_PROPERTY);
      }

      public SmartPalletRequest unselectTotalArea(){
          return unselect(TOTAL_AREA_PROPERTY);
      }

      public SearchCriteria getTotalAreaSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(TOTAL_AREA_PROPERTY, pQueryOperator, parameters);
      }

      public SmartPalletRequest orderByTotalArea(boolean asc){
          addOrderBy(TOTAL_AREA_PROPERTY, asc);
          return this;
      }
   
      public SmartPalletRequest filterByLatitude(BigDecimal latitude) {
          
          if (latitude == null) {
              return this;
          }
          
          return filterByLatitude(QueryOperator.EQUAL, latitude);
      }
    

      public SmartPalletRequest filterByLatitude(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLatitudeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SmartPalletRequest selectLatitude(){
          return select(LATITUDE_PROPERTY);
      }

      public SmartPalletRequest unselectLatitude(){
          return unselect(LATITUDE_PROPERTY);
      }

      public SearchCriteria getLatitudeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LATITUDE_PROPERTY, pQueryOperator, parameters);
      }

      public SmartPalletRequest orderByLatitude(boolean asc){
          addOrderBy(LATITUDE_PROPERTY, asc);
          return this;
      }
   
      public SmartPalletRequest filterByLongitude(BigDecimal longitude) {
          
          if (longitude == null) {
              return this;
          }
          
          return filterByLongitude(QueryOperator.EQUAL, longitude);
      }
    

      public SmartPalletRequest filterByLongitude(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLongitudeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SmartPalletRequest selectLongitude(){
          return select(LONGITUDE_PROPERTY);
      }

      public SmartPalletRequest unselectLongitude(){
          return unselect(LONGITUDE_PROPERTY);
      }

      public SearchCriteria getLongitudeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LONGITUDE_PROPERTY, pQueryOperator, parameters);
      }

      public SmartPalletRequest orderByLongitude(boolean asc){
          addOrderBy(LONGITUDE_PROPERTY, asc);
          return this;
      }
   
      public SmartPalletRequest filterByLastUpdateTime(DateTime lastUpdateTime) {
          
          if (lastUpdateTime == null) {
              return this;
          }
          
          return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
      }
    

      public SmartPalletRequest filterByLastUpdateTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SmartPalletRequest selectLastUpdateTime(){
          return select(LAST_UPDATE_TIME_PROPERTY);
      }

      public SmartPalletRequest unselectLastUpdateTime(){
          return unselect(LAST_UPDATE_TIME_PROPERTY);
      }

      public SearchCriteria getLastUpdateTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public SmartPalletRequest orderByLastUpdateTime(boolean asc){
          addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
          return this;
      }
   
      public SmartPalletRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public SmartPalletRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SmartPalletRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public SmartPalletRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public SmartPalletRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public SmartPalletRequest filterByWarehouse(WarehouseRequest warehouse){
        return filterByWarehouse(warehouse, warehouseList -> warehouseList.stream().map(Warehouse::getId).collect(Collectors.toSet()));
    }

    public SmartPalletRequest filterByWarehouse(WarehouseRequest warehouse, IDRefine<Warehouse> idRefine) {
        return addSearchCriteria(createWarehouseCriteria(warehouse, idRefine));
    }

    public SearchCriteria createWarehouseCriteria(WarehouseRequest warehouse, IDRefine<Warehouse> idRefine) {
        return new RefinedIdInCriteria(warehouse, WAREHOUSE_PROPERTY, idRefine);
    }
    

    
    public SmartPalletRequest selectWarehouse(){
        return selectWarehouse(WarehouseRequest.newInstance().selectSelf());
    }

    public SmartPalletRequest selectWarehouse(WarehouseRequest warehouse){
        selectParent(WAREHOUSE_PROPERTY, warehouse);
        return this;
    }
    

    public SmartPalletRequest unselectWarehouse(){
        unselectParent(WAREHOUSE_PROPERTY);
        return this;
    }

  


  

    public SmartPalletRequest hasGoods() {
      return hasGoods(GoodsRequest.newInstance());
    }

    public SmartPalletRequest hasGoods(GoodsRequest goods) {
        return hasGoods(goods, goodsList -> goodsList.stream().map(Goods::getSmartPallet).map(SmartPallet::getId).collect(Collectors.toSet()));
    }

    public SmartPalletRequest hasGoods(GoodsRequest goods, IDRefine<Goods> idRefine) {
        goods.select(Goods.SMART_PALLET_PROPERTY);
        return addSearchCriteria(createGoodsCriteria(goods, idRefine));
    }

    public SearchCriteria createGoodsCriteria(GoodsRequest goods, IDRefine<Goods> idRefine){
       return new RefinedIdInCriteria(goods, ID_PROPERTY, idRefine);
    }

    public SmartPalletRequest selectGoodsList(GoodsRequest goods) {
        selectChild(Goods.SMART_PALLET_PROPERTY, goods);
        return this;
    }

    public SmartPalletRequest selectGoodsList() {
        return selectGoodsList(GoodsRequest.newInstance().selectAll());
    }

    public SmartPalletRequest unselectGoodsList(){
        unselectChild(Goods.SMART_PALLET_PROPERTY, Goods.class);
        return this;
    }
  

   public SmartPalletRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

