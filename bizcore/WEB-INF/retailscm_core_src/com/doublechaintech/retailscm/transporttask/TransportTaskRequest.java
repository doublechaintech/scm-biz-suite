package com.doublechaintech.retailscm.transporttask;

import com.doublechaintech.retailscm.search.*;
import java.math.BigDecimal;
import java.util.Date;
import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.transportfleet.TransportFleet;
import com.doublechaintech.retailscm.transporttasktrack.TransportTaskTrack;
import com.doublechaintech.retailscm.transporttruck.TransportTruck;
import com.doublechaintech.retailscm.truckdriver.TruckDriver;
import com.doublechaintech.retailscm.goods.GoodsRequest;
import com.doublechaintech.retailscm.retailstore.RetailStoreRequest;
import com.doublechaintech.retailscm.transportfleet.TransportFleetRequest;
import com.doublechaintech.retailscm.transporttasktrack.TransportTaskTrackRequest;
import com.doublechaintech.retailscm.transporttruck.TransportTruckRequest;
import com.doublechaintech.retailscm.truckdriver.TruckDriverRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.transporttask.TransportTask.*;

public class TransportTaskRequest extends BaseRequest<TransportTask> {
    public static TransportTaskRequest newInstance() {
        return new TransportTaskRequest().selectId();
    }

    public String getInternalType() {
        return "TransportTask";
    }

    public TransportTaskRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public TransportTaskRequest select(String... names) {
        super.select(names);
        return this;
    }

    public TransportTaskRequest selectAll() {return this.selectId().selectName().selectStart().selectBeginTime().selectEnd().selectDriver().selectTruck().selectBelongsTo().selectLatitude().selectLongitude().selectVersion();
    }

    public TransportTaskRequest selectSelf() {return this.selectId().selectName().selectStart().selectBeginTime().selectLatitude().selectLongitude().selectVersion();
    }

    public TransportTaskRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public TransportTaskRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static TransportTaskRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public TransportTaskRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public TransportTaskRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TransportTaskRequest selectId(){
          return select(ID_PROPERTY);
      }

      public TransportTaskRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public TransportTaskRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public TransportTaskRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public TransportTaskRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TransportTaskRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public TransportTaskRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public TransportTaskRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public TransportTaskRequest filterByStart(String start) {
          
          if (start == null) {
              return this;
          }
          
          return filterByStart(QueryOperator.EQUAL, start);
      }
    

      public TransportTaskRequest filterByStart(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getStartSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TransportTaskRequest selectStart(){
          return select(START_PROPERTY);
      }

      public TransportTaskRequest unselectStart(){
          return unselect(START_PROPERTY);
      }

      public SearchCriteria getStartSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(START_PROPERTY, pQueryOperator, parameters);
      }

      public TransportTaskRequest orderByStart(boolean asc){
          addOrderBy(START_PROPERTY, asc);
          return this;
      }
   
      public TransportTaskRequest filterByBeginTime(Date beginTime) {
          
          if (beginTime == null) {
              return this;
          }
          
          return filterByBeginTime(QueryOperator.EQUAL, beginTime);
      }
    

      public TransportTaskRequest filterByBeginTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getBeginTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TransportTaskRequest selectBeginTime(){
          return select(BEGIN_TIME_PROPERTY);
      }

      public TransportTaskRequest unselectBeginTime(){
          return unselect(BEGIN_TIME_PROPERTY);
      }

      public SearchCriteria getBeginTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(BEGIN_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public TransportTaskRequest orderByBeginTime(boolean asc){
          addOrderBy(BEGIN_TIME_PROPERTY, asc);
          return this;
      }
   
      public TransportTaskRequest filterByLatitude(BigDecimal latitude) {
          
          if (latitude == null) {
              return this;
          }
          
          return filterByLatitude(QueryOperator.EQUAL, latitude);
      }
    

      public TransportTaskRequest filterByLatitude(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLatitudeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TransportTaskRequest selectLatitude(){
          return select(LATITUDE_PROPERTY);
      }

      public TransportTaskRequest unselectLatitude(){
          return unselect(LATITUDE_PROPERTY);
      }

      public SearchCriteria getLatitudeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LATITUDE_PROPERTY, pQueryOperator, parameters);
      }

      public TransportTaskRequest orderByLatitude(boolean asc){
          addOrderBy(LATITUDE_PROPERTY, asc);
          return this;
      }
   
      public TransportTaskRequest filterByLongitude(BigDecimal longitude) {
          
          if (longitude == null) {
              return this;
          }
          
          return filterByLongitude(QueryOperator.EQUAL, longitude);
      }
    

      public TransportTaskRequest filterByLongitude(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLongitudeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TransportTaskRequest selectLongitude(){
          return select(LONGITUDE_PROPERTY);
      }

      public TransportTaskRequest unselectLongitude(){
          return unselect(LONGITUDE_PROPERTY);
      }

      public SearchCriteria getLongitudeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LONGITUDE_PROPERTY, pQueryOperator, parameters);
      }

      public TransportTaskRequest orderByLongitude(boolean asc){
          addOrderBy(LONGITUDE_PROPERTY, asc);
          return this;
      }
   
      public TransportTaskRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public TransportTaskRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TransportTaskRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public TransportTaskRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public TransportTaskRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public TransportTaskRequest filterByEnd(RetailStoreRequest end){
        return filterByEnd(end, endList -> endList.stream().map(RetailStore::getId).collect(Collectors.toSet()));
    }

    public TransportTaskRequest filterByEnd(RetailStoreRequest end, IDRefine<RetailStore> idRefine) {
        return addSearchCriteria(createEndCriteria(end, idRefine));
    }

    public SearchCriteria createEndCriteria(RetailStoreRequest end, IDRefine<RetailStore> idRefine) {
        return new RefinedIdInCriteria(end, END_PROPERTY, idRefine);
    }
    

    
    public TransportTaskRequest selectEnd(){
        return selectEnd(RetailStoreRequest.newInstance().selectSelf());
    }

    public TransportTaskRequest selectEnd(RetailStoreRequest end){
        selectParent(END_PROPERTY, end);
        return this;
    }
    

    public TransportTaskRequest unselectEnd(){
        unselectParent(END_PROPERTY);
        return this;
    }

  

    
    public TransportTaskRequest filterByDriver(TruckDriverRequest driver){
        return filterByDriver(driver, driverList -> driverList.stream().map(TruckDriver::getId).collect(Collectors.toSet()));
    }

    public TransportTaskRequest filterByDriver(TruckDriverRequest driver, IDRefine<TruckDriver> idRefine) {
        return addSearchCriteria(createDriverCriteria(driver, idRefine));
    }

    public SearchCriteria createDriverCriteria(TruckDriverRequest driver, IDRefine<TruckDriver> idRefine) {
        return new RefinedIdInCriteria(driver, DRIVER_PROPERTY, idRefine);
    }
    

    
    public TransportTaskRequest selectDriver(){
        return selectDriver(TruckDriverRequest.newInstance().selectSelf());
    }

    public TransportTaskRequest selectDriver(TruckDriverRequest driver){
        selectParent(DRIVER_PROPERTY, driver);
        return this;
    }
    

    public TransportTaskRequest unselectDriver(){
        unselectParent(DRIVER_PROPERTY);
        return this;
    }

  

    
    public TransportTaskRequest filterByTruck(TransportTruckRequest truck){
        return filterByTruck(truck, truckList -> truckList.stream().map(TransportTruck::getId).collect(Collectors.toSet()));
    }

    public TransportTaskRequest filterByTruck(TransportTruckRequest truck, IDRefine<TransportTruck> idRefine) {
        return addSearchCriteria(createTruckCriteria(truck, idRefine));
    }

    public SearchCriteria createTruckCriteria(TransportTruckRequest truck, IDRefine<TransportTruck> idRefine) {
        return new RefinedIdInCriteria(truck, TRUCK_PROPERTY, idRefine);
    }
    

    
    public TransportTaskRequest selectTruck(){
        return selectTruck(TransportTruckRequest.newInstance().selectSelf());
    }

    public TransportTaskRequest selectTruck(TransportTruckRequest truck){
        selectParent(TRUCK_PROPERTY, truck);
        return this;
    }
    

    public TransportTaskRequest unselectTruck(){
        unselectParent(TRUCK_PROPERTY);
        return this;
    }

  

    
    public TransportTaskRequest filterByBelongsTo(TransportFleetRequest belongsTo){
        return filterByBelongsTo(belongsTo, belongsToList -> belongsToList.stream().map(TransportFleet::getId).collect(Collectors.toSet()));
    }

    public TransportTaskRequest filterByBelongsTo(TransportFleetRequest belongsTo, IDRefine<TransportFleet> idRefine) {
        return addSearchCriteria(createBelongsToCriteria(belongsTo, idRefine));
    }

    public SearchCriteria createBelongsToCriteria(TransportFleetRequest belongsTo, IDRefine<TransportFleet> idRefine) {
        return new RefinedIdInCriteria(belongsTo, BELONGS_TO_PROPERTY, idRefine);
    }
    

    
    public TransportTaskRequest selectBelongsTo(){
        return selectBelongsTo(TransportFleetRequest.newInstance().selectSelf());
    }

    public TransportTaskRequest selectBelongsTo(TransportFleetRequest belongsTo){
        selectParent(BELONGS_TO_PROPERTY, belongsTo);
        return this;
    }
    

    public TransportTaskRequest unselectBelongsTo(){
        unselectParent(BELONGS_TO_PROPERTY);
        return this;
    }

  


  

    public TransportTaskRequest hasGoods() {
      return hasGoods(GoodsRequest.newInstance());
    }

    public TransportTaskRequest hasGoods(GoodsRequest goods) {
        return hasGoods(goods, goodsList -> goodsList.stream().map(Goods::getTransportTask).map(TransportTask::getId).collect(Collectors.toSet()));
    }

    public TransportTaskRequest hasGoods(GoodsRequest goods, IDRefine<Goods> idRefine) {
        goods.select(Goods.TRANSPORT_TASK_PROPERTY);
        return addSearchCriteria(createGoodsCriteria(goods, idRefine));
    }

    public SearchCriteria createGoodsCriteria(GoodsRequest goods, IDRefine<Goods> idRefine){
       return new RefinedIdInCriteria(goods, ID_PROPERTY, idRefine);
    }

    public TransportTaskRequest selectGoodsList(GoodsRequest goods) {
        selectChild(Goods.TRANSPORT_TASK_PROPERTY, goods);
        return this;
    }

    public TransportTaskRequest selectGoodsList() {
        return selectGoodsList(GoodsRequest.newInstance().selectAll());
    }

    public TransportTaskRequest unselectGoodsList(){
        unselectChild(Goods.TRANSPORT_TASK_PROPERTY, Goods.class);
        return this;
    }
  

    public TransportTaskRequest hasTransportTaskTrack() {
      return hasTransportTaskTrack(TransportTaskTrackRequest.newInstance());
    }

    public TransportTaskRequest hasTransportTaskTrack(TransportTaskTrackRequest transportTaskTrack) {
        return hasTransportTaskTrack(transportTaskTrack, transportTaskTrackList -> transportTaskTrackList.stream().map(TransportTaskTrack::getMovement).map(TransportTask::getId).collect(Collectors.toSet()));
    }

    public TransportTaskRequest hasTransportTaskTrack(TransportTaskTrackRequest transportTaskTrack, IDRefine<TransportTaskTrack> idRefine) {
        transportTaskTrack.select(TransportTaskTrack.MOVEMENT_PROPERTY);
        return addSearchCriteria(createTransportTaskTrackCriteria(transportTaskTrack, idRefine));
    }

    public SearchCriteria createTransportTaskTrackCriteria(TransportTaskTrackRequest transportTaskTrack, IDRefine<TransportTaskTrack> idRefine){
       return new RefinedIdInCriteria(transportTaskTrack, ID_PROPERTY, idRefine);
    }

    public TransportTaskRequest selectTransportTaskTrackList(TransportTaskTrackRequest transportTaskTrack) {
        selectChild(TransportTaskTrack.MOVEMENT_PROPERTY, transportTaskTrack);
        return this;
    }

    public TransportTaskRequest selectTransportTaskTrackList() {
        return selectTransportTaskTrackList(TransportTaskTrackRequest.newInstance().selectAll());
    }

    public TransportTaskRequest unselectTransportTaskTrackList(){
        unselectChild(TransportTaskTrack.MOVEMENT_PROPERTY, TransportTaskTrack.class);
        return this;
    }
  

   public TransportTaskRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

