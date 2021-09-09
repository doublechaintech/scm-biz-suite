package com.doublechaintech.retailscm.transporttasktrack;

import com.doublechaintech.retailscm.search.*;
import java.math.BigDecimal;
import java.util.Date;
import com.doublechaintech.retailscm.transporttask.TransportTask;
import com.doublechaintech.retailscm.transporttask.TransportTaskRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.transporttasktrack.TransportTaskTrack.*;

public class TransportTaskTrackRequest extends BaseRequest<TransportTaskTrack> {
    public static TransportTaskTrackRequest newInstance() {
        return new TransportTaskTrackRequest().selectId();
    }

    public String getInternalType() {
        return "TransportTaskTrack";
    }

    public TransportTaskTrackRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public TransportTaskTrackRequest select(String... names) {
        super.select(names);
        return this;
    }

    public TransportTaskTrackRequest selectAll() {return this.selectId().selectTrackTime().selectLatitude().selectLongitude().selectMovement().selectVersion();
    }

    public TransportTaskTrackRequest selectSelf() {return this.selectId().selectTrackTime().selectLatitude().selectLongitude().selectVersion();
    }

    public TransportTaskTrackRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public TransportTaskTrackRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static TransportTaskTrackRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public TransportTaskTrackRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public TransportTaskTrackRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TransportTaskTrackRequest selectId(){
          return select(ID_PROPERTY);
      }

      public TransportTaskTrackRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public TransportTaskTrackRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public TransportTaskTrackRequest filterByTrackTime(Date trackTime) {
          
          if (trackTime == null) {
              return this;
          }
          
          return filterByTrackTime(QueryOperator.EQUAL, trackTime);
      }
    

      public TransportTaskTrackRequest filterByTrackTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getTrackTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TransportTaskTrackRequest selectTrackTime(){
          return select(TRACK_TIME_PROPERTY);
      }

      public TransportTaskTrackRequest unselectTrackTime(){
          return unselect(TRACK_TIME_PROPERTY);
      }

      public SearchCriteria getTrackTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(TRACK_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public TransportTaskTrackRequest orderByTrackTime(boolean asc){
          addOrderBy(TRACK_TIME_PROPERTY, asc);
          return this;
      }
   
      public TransportTaskTrackRequest filterByLatitude(BigDecimal latitude) {
          
          if (latitude == null) {
              return this;
          }
          
          return filterByLatitude(QueryOperator.EQUAL, latitude);
      }
    

      public TransportTaskTrackRequest filterByLatitude(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLatitudeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TransportTaskTrackRequest selectLatitude(){
          return select(LATITUDE_PROPERTY);
      }

      public TransportTaskTrackRequest unselectLatitude(){
          return unselect(LATITUDE_PROPERTY);
      }

      public SearchCriteria getLatitudeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LATITUDE_PROPERTY, pQueryOperator, parameters);
      }

      public TransportTaskTrackRequest orderByLatitude(boolean asc){
          addOrderBy(LATITUDE_PROPERTY, asc);
          return this;
      }
   
      public TransportTaskTrackRequest filterByLongitude(BigDecimal longitude) {
          
          if (longitude == null) {
              return this;
          }
          
          return filterByLongitude(QueryOperator.EQUAL, longitude);
      }
    

      public TransportTaskTrackRequest filterByLongitude(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLongitudeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TransportTaskTrackRequest selectLongitude(){
          return select(LONGITUDE_PROPERTY);
      }

      public TransportTaskTrackRequest unselectLongitude(){
          return unselect(LONGITUDE_PROPERTY);
      }

      public SearchCriteria getLongitudeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LONGITUDE_PROPERTY, pQueryOperator, parameters);
      }

      public TransportTaskTrackRequest orderByLongitude(boolean asc){
          addOrderBy(LONGITUDE_PROPERTY, asc);
          return this;
      }
   
      public TransportTaskTrackRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public TransportTaskTrackRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TransportTaskTrackRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public TransportTaskTrackRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public TransportTaskTrackRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public TransportTaskTrackRequest filterByMovement(TransportTaskRequest movement){
        return filterByMovement(movement, movementList -> movementList.stream().map(TransportTask::getId).collect(Collectors.toSet()));
    }

    public TransportTaskTrackRequest filterByMovement(TransportTaskRequest movement, IDRefine<TransportTask> idRefine) {
        return addSearchCriteria(createMovementCriteria(movement, idRefine));
    }

    public SearchCriteria createMovementCriteria(TransportTaskRequest movement, IDRefine<TransportTask> idRefine) {
        return new RefinedIdInCriteria(movement, MOVEMENT_PROPERTY, idRefine);
    }
    

    
    public TransportTaskTrackRequest selectMovement(){
        return selectMovement(TransportTaskRequest.newInstance().selectSelf());
    }

    public TransportTaskTrackRequest selectMovement(TransportTaskRequest movement){
        selectParent(MOVEMENT_PROPERTY, movement);
        return this;
    }
    

    public TransportTaskTrackRequest unselectMovement(){
        unselectParent(MOVEMENT_PROPERTY);
        return this;
    }

  


  

   public TransportTaskTrackRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

