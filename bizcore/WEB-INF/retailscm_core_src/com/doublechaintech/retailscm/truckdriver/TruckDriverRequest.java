package com.doublechaintech.retailscm.truckdriver;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.transportfleet.TransportFleet;
import com.doublechaintech.retailscm.transporttask.TransportTask;
import com.doublechaintech.retailscm.transportfleet.TransportFleetRequest;
import com.doublechaintech.retailscm.transporttask.TransportTaskRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.truckdriver.TruckDriver.*;

public class TruckDriverRequest extends BaseRequest<TruckDriver> {
    public static TruckDriverRequest newInstance() {
        return new TruckDriverRequest().selectId();
    }

    public String getInternalType() {
        return "TruckDriver";
    }

    public TruckDriverRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public TruckDriverRequest select(String... names) {
        super.select(names);
        return this;
    }

    public TruckDriverRequest selectAll() {return this.selectId().selectName().selectDriverLicenseNumber().selectContactNumber().selectBelongsTo().selectVersion();
    }

    public TruckDriverRequest selectSelf() {return this.selectId().selectName().selectDriverLicenseNumber().selectContactNumber().selectVersion();
    }

    public TruckDriverRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public TruckDriverRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static TruckDriverRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public TruckDriverRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public TruckDriverRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TruckDriverRequest selectId(){
          return select(ID_PROPERTY);
      }

      public TruckDriverRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public TruckDriverRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public TruckDriverRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public TruckDriverRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TruckDriverRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public TruckDriverRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public TruckDriverRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public TruckDriverRequest filterByDriverLicenseNumber(String driverLicenseNumber) {
          
          if (driverLicenseNumber == null) {
              return this;
          }
          
          return filterByDriverLicenseNumber(QueryOperator.EQUAL, driverLicenseNumber);
      }
    

      public TruckDriverRequest filterByDriverLicenseNumber(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getDriverLicenseNumberSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TruckDriverRequest selectDriverLicenseNumber(){
          return select(DRIVER_LICENSE_NUMBER_PROPERTY);
      }

      public TruckDriverRequest unselectDriverLicenseNumber(){
          return unselect(DRIVER_LICENSE_NUMBER_PROPERTY);
      }

      public SearchCriteria getDriverLicenseNumberSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(DRIVER_LICENSE_NUMBER_PROPERTY, pQueryOperator, parameters);
      }

      public TruckDriverRequest orderByDriverLicenseNumber(boolean asc){
          addOrderBy(DRIVER_LICENSE_NUMBER_PROPERTY, asc);
          return this;
      }
   
      public TruckDriverRequest filterByContactNumber(String contactNumber) {
          
          if (contactNumber == null) {
              return this;
          }
          
          return filterByContactNumber(QueryOperator.EQUAL, contactNumber);
      }
    

      public TruckDriverRequest filterByContactNumber(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getContactNumberSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TruckDriverRequest selectContactNumber(){
          return select(CONTACT_NUMBER_PROPERTY);
      }

      public TruckDriverRequest unselectContactNumber(){
          return unselect(CONTACT_NUMBER_PROPERTY);
      }

      public SearchCriteria getContactNumberSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(CONTACT_NUMBER_PROPERTY, pQueryOperator, parameters);
      }

      public TruckDriverRequest orderByContactNumber(boolean asc){
          addOrderBy(CONTACT_NUMBER_PROPERTY, asc);
          return this;
      }
   
      public TruckDriverRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public TruckDriverRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TruckDriverRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public TruckDriverRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public TruckDriverRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public TruckDriverRequest filterByBelongsTo(TransportFleetRequest belongsTo){
        return filterByBelongsTo(belongsTo, belongsToList -> belongsToList.stream().map(TransportFleet::getId).collect(Collectors.toSet()));
    }

    public TruckDriverRequest filterByBelongsTo(TransportFleetRequest belongsTo, IDRefine<TransportFleet> idRefine) {
        return addSearchCriteria(createBelongsToCriteria(belongsTo, idRefine));
    }

    public SearchCriteria createBelongsToCriteria(TransportFleetRequest belongsTo, IDRefine<TransportFleet> idRefine) {
        return new RefinedIdInCriteria(belongsTo, BELONGS_TO_PROPERTY, idRefine);
    }
    

    
    public TruckDriverRequest selectBelongsTo(){
        return selectBelongsTo(TransportFleetRequest.newInstance().selectSelf());
    }

    public TruckDriverRequest selectBelongsTo(TransportFleetRequest belongsTo){
        selectParent(BELONGS_TO_PROPERTY, belongsTo);
        return this;
    }
    

    public TruckDriverRequest unselectBelongsTo(){
        unselectParent(BELONGS_TO_PROPERTY);
        return this;
    }

  


  

    public TruckDriverRequest hasTransportTask() {
      return hasTransportTask(TransportTaskRequest.newInstance());
    }

    public TruckDriverRequest hasTransportTask(TransportTaskRequest transportTask) {
        return hasTransportTask(transportTask, transportTaskList -> transportTaskList.stream().map(TransportTask::getDriver).map(TruckDriver::getId).collect(Collectors.toSet()));
    }

    public TruckDriverRequest hasTransportTask(TransportTaskRequest transportTask, IDRefine<TransportTask> idRefine) {
        transportTask.select(TransportTask.DRIVER_PROPERTY);
        return addSearchCriteria(createTransportTaskCriteria(transportTask, idRefine));
    }

    public SearchCriteria createTransportTaskCriteria(TransportTaskRequest transportTask, IDRefine<TransportTask> idRefine){
       return new RefinedIdInCriteria(transportTask, ID_PROPERTY, idRefine);
    }

    public TruckDriverRequest selectTransportTaskList(TransportTaskRequest transportTask) {
        selectChild(TransportTask.DRIVER_PROPERTY, transportTask);
        return this;
    }

    public TruckDriverRequest selectTransportTaskList() {
        return selectTransportTaskList(TransportTaskRequest.newInstance().selectAll());
    }

    public TruckDriverRequest unselectTransportTaskList(){
        unselectChild(TransportTask.DRIVER_PROPERTY, TransportTask.class);
        return this;
    }
  

   public TruckDriverRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

