package com.doublechaintech.retailscm.transportfleet;

import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.transporttask.TransportTask;
import com.doublechaintech.retailscm.transporttruck.TransportTruck;
import com.doublechaintech.retailscm.truckdriver.TruckDriver;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;
import com.doublechaintech.retailscm.transporttask.TransportTaskRequest;
import com.doublechaintech.retailscm.transporttruck.TransportTruckRequest;
import com.doublechaintech.retailscm.truckdriver.TruckDriverRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.transportfleet.TransportFleet.*;

public class TransportFleetRequest extends BaseRequest<TransportFleet> {
    public static TransportFleetRequest newInstance() {
        return new TransportFleetRequest().selectId();
    }

    public String getInternalType() {
        return "TransportFleet";
    }

    public TransportFleetRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public TransportFleetRequest select(String... names) {
        super.select(names);
        return this;
    }

    public TransportFleetRequest selectAll() {return this.selectId().selectName().selectContactNumber().selectOwner().selectContract().selectLastUpdateTime().selectVersion();
    }

    public TransportFleetRequest selectSelf() {return this.selectId().selectName().selectContactNumber().selectContract().selectLastUpdateTime().selectVersion();
    }

    public TransportFleetRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public TransportFleetRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static TransportFleetRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public TransportFleetRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public TransportFleetRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TransportFleetRequest selectId(){
          return select(ID_PROPERTY);
      }

      public TransportFleetRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public TransportFleetRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public TransportFleetRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public TransportFleetRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TransportFleetRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public TransportFleetRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public TransportFleetRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public TransportFleetRequest filterByContactNumber(String contactNumber) {
          
          if (contactNumber == null) {
              return this;
          }
          
          return filterByContactNumber(QueryOperator.EQUAL, contactNumber);
      }
    

      public TransportFleetRequest filterByContactNumber(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getContactNumberSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TransportFleetRequest selectContactNumber(){
          return select(CONTACT_NUMBER_PROPERTY);
      }

      public TransportFleetRequest unselectContactNumber(){
          return unselect(CONTACT_NUMBER_PROPERTY);
      }

      public SearchCriteria getContactNumberSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(CONTACT_NUMBER_PROPERTY, pQueryOperator, parameters);
      }

      public TransportFleetRequest orderByContactNumber(boolean asc){
          addOrderBy(CONTACT_NUMBER_PROPERTY, asc);
          return this;
      }
   
      public TransportFleetRequest filterByContract(String contract) {
          
          if (contract == null) {
              return this;
          }
          
          return filterByContract(QueryOperator.EQUAL, contract);
      }
    

      public TransportFleetRequest filterByContract(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getContractSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TransportFleetRequest selectContract(){
          return select(CONTRACT_PROPERTY);
      }

      public TransportFleetRequest unselectContract(){
          return unselect(CONTRACT_PROPERTY);
      }

      public SearchCriteria getContractSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(CONTRACT_PROPERTY, pQueryOperator, parameters);
      }

      public TransportFleetRequest orderByContract(boolean asc){
          addOrderBy(CONTRACT_PROPERTY, asc);
          return this;
      }
   
      public TransportFleetRequest filterByLastUpdateTime(DateTime lastUpdateTime) {
          
          if (lastUpdateTime == null) {
              return this;
          }
          
          return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
      }
    

      public TransportFleetRequest filterByLastUpdateTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TransportFleetRequest selectLastUpdateTime(){
          return select(LAST_UPDATE_TIME_PROPERTY);
      }

      public TransportFleetRequest unselectLastUpdateTime(){
          return unselect(LAST_UPDATE_TIME_PROPERTY);
      }

      public SearchCriteria getLastUpdateTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public TransportFleetRequest orderByLastUpdateTime(boolean asc){
          addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
          return this;
      }
   
      public TransportFleetRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public TransportFleetRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TransportFleetRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public TransportFleetRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public TransportFleetRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public TransportFleetRequest filterByOwner(RetailStoreCountryCenterRequest owner){
        return filterByOwner(owner, ownerList -> ownerList.stream().map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public TransportFleetRequest filterByOwner(RetailStoreCountryCenterRequest owner, IDRefine<RetailStoreCountryCenter> idRefine) {
        return addSearchCriteria(createOwnerCriteria(owner, idRefine));
    }

    public SearchCriteria createOwnerCriteria(RetailStoreCountryCenterRequest owner, IDRefine<RetailStoreCountryCenter> idRefine) {
        return new RefinedIdInCriteria(owner, OWNER_PROPERTY, idRefine);
    }
    

    
    public TransportFleetRequest selectOwner(){
        return selectOwner(RetailStoreCountryCenterRequest.newInstance().selectSelf());
    }

    public TransportFleetRequest selectOwner(RetailStoreCountryCenterRequest owner){
        selectParent(OWNER_PROPERTY, owner);
        return this;
    }
    

    public TransportFleetRequest unselectOwner(){
        unselectParent(OWNER_PROPERTY);
        return this;
    }

  


  

    public TransportFleetRequest hasTransportTruck() {
      return hasTransportTruck(TransportTruckRequest.newInstance());
    }

    public TransportFleetRequest hasTransportTruck(TransportTruckRequest transportTruck) {
        return hasTransportTruck(transportTruck, transportTruckList -> transportTruckList.stream().map(TransportTruck::getOwner).map(TransportFleet::getId).collect(Collectors.toSet()));
    }

    public TransportFleetRequest hasTransportTruck(TransportTruckRequest transportTruck, IDRefine<TransportTruck> idRefine) {
        transportTruck.select(TransportTruck.OWNER_PROPERTY);
        return addSearchCriteria(createTransportTruckCriteria(transportTruck, idRefine));
    }

    public SearchCriteria createTransportTruckCriteria(TransportTruckRequest transportTruck, IDRefine<TransportTruck> idRefine){
       return new RefinedIdInCriteria(transportTruck, ID_PROPERTY, idRefine);
    }

    public TransportFleetRequest selectTransportTruckList(TransportTruckRequest transportTruck) {
        selectChild(TransportTruck.OWNER_PROPERTY, transportTruck);
        return this;
    }

    public TransportFleetRequest selectTransportTruckList() {
        return selectTransportTruckList(TransportTruckRequest.newInstance().selectAll());
    }

    public TransportFleetRequest unselectTransportTruckList(){
        unselectChild(TransportTruck.OWNER_PROPERTY, TransportTruck.class);
        return this;
    }
  

    public TransportFleetRequest hasTruckDriver() {
      return hasTruckDriver(TruckDriverRequest.newInstance());
    }

    public TransportFleetRequest hasTruckDriver(TruckDriverRequest truckDriver) {
        return hasTruckDriver(truckDriver, truckDriverList -> truckDriverList.stream().map(TruckDriver::getBelongsTo).map(TransportFleet::getId).collect(Collectors.toSet()));
    }

    public TransportFleetRequest hasTruckDriver(TruckDriverRequest truckDriver, IDRefine<TruckDriver> idRefine) {
        truckDriver.select(TruckDriver.BELONGS_TO_PROPERTY);
        return addSearchCriteria(createTruckDriverCriteria(truckDriver, idRefine));
    }

    public SearchCriteria createTruckDriverCriteria(TruckDriverRequest truckDriver, IDRefine<TruckDriver> idRefine){
       return new RefinedIdInCriteria(truckDriver, ID_PROPERTY, idRefine);
    }

    public TransportFleetRequest selectTruckDriverList(TruckDriverRequest truckDriver) {
        selectChild(TruckDriver.BELONGS_TO_PROPERTY, truckDriver);
        return this;
    }

    public TransportFleetRequest selectTruckDriverList() {
        return selectTruckDriverList(TruckDriverRequest.newInstance().selectAll());
    }

    public TransportFleetRequest unselectTruckDriverList(){
        unselectChild(TruckDriver.BELONGS_TO_PROPERTY, TruckDriver.class);
        return this;
    }
  

    public TransportFleetRequest hasTransportTask() {
      return hasTransportTask(TransportTaskRequest.newInstance());
    }

    public TransportFleetRequest hasTransportTask(TransportTaskRequest transportTask) {
        return hasTransportTask(transportTask, transportTaskList -> transportTaskList.stream().map(TransportTask::getBelongsTo).map(TransportFleet::getId).collect(Collectors.toSet()));
    }

    public TransportFleetRequest hasTransportTask(TransportTaskRequest transportTask, IDRefine<TransportTask> idRefine) {
        transportTask.select(TransportTask.BELONGS_TO_PROPERTY);
        return addSearchCriteria(createTransportTaskCriteria(transportTask, idRefine));
    }

    public SearchCriteria createTransportTaskCriteria(TransportTaskRequest transportTask, IDRefine<TransportTask> idRefine){
       return new RefinedIdInCriteria(transportTask, ID_PROPERTY, idRefine);
    }

    public TransportFleetRequest selectTransportTaskList(TransportTaskRequest transportTask) {
        selectChild(TransportTask.BELONGS_TO_PROPERTY, transportTask);
        return this;
    }

    public TransportFleetRequest selectTransportTaskList() {
        return selectTransportTaskList(TransportTaskRequest.newInstance().selectAll());
    }

    public TransportFleetRequest unselectTransportTaskList(){
        unselectChild(TransportTask.BELONGS_TO_PROPERTY, TransportTask.class);
        return this;
    }
  

   public TransportFleetRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

