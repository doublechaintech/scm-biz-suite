package com.doublechaintech.retailscm.transporttruck;

import com.doublechaintech.retailscm.search.*;
import java.util.Date;
import com.doublechaintech.retailscm.transportfleet.TransportFleet;
import com.doublechaintech.retailscm.transporttask.TransportTask;
import com.doublechaintech.retailscm.transportfleet.TransportFleetRequest;
import com.doublechaintech.retailscm.transporttask.TransportTaskRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.transporttruck.TransportTruck.*;

public class TransportTruckRequest extends BaseRequest<TransportTruck> {
    public static TransportTruckRequest newInstance() {
        return new TransportTruckRequest().selectId();
    }

    public String getInternalType() {
        return "TransportTruck";
    }

    public TransportTruckRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public TransportTruckRequest select(String... names) {
        super.select(names);
        return this;
    }

    public TransportTruckRequest selectAll() {return this.selectId().selectName().selectPlateNumber().selectContactNumber().selectVehicleLicenseNumber().selectEngineNumber().selectMakeDate().selectMileage().selectBodyColor().selectOwner().selectVersion();
    }

    public TransportTruckRequest selectSelf() {return this.selectId().selectName().selectPlateNumber().selectContactNumber().selectVehicleLicenseNumber().selectEngineNumber().selectMakeDate().selectMileage().selectBodyColor().selectVersion();
    }

    public TransportTruckRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public TransportTruckRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static TransportTruckRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public TransportTruckRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public TransportTruckRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TransportTruckRequest selectId(){
          return select(ID_PROPERTY);
      }

      public TransportTruckRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public TransportTruckRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public TransportTruckRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public TransportTruckRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TransportTruckRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public TransportTruckRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public TransportTruckRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public TransportTruckRequest filterByPlateNumber(String plateNumber) {
          
          if (plateNumber == null) {
              return this;
          }
          
          return filterByPlateNumber(QueryOperator.EQUAL, plateNumber);
      }
    

      public TransportTruckRequest filterByPlateNumber(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getPlateNumberSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TransportTruckRequest selectPlateNumber(){
          return select(PLATE_NUMBER_PROPERTY);
      }

      public TransportTruckRequest unselectPlateNumber(){
          return unselect(PLATE_NUMBER_PROPERTY);
      }

      public SearchCriteria getPlateNumberSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(PLATE_NUMBER_PROPERTY, pQueryOperator, parameters);
      }

      public TransportTruckRequest orderByPlateNumber(boolean asc){
          addOrderBy(PLATE_NUMBER_PROPERTY, asc);
          return this;
      }
   
      public TransportTruckRequest filterByContactNumber(String contactNumber) {
          
          if (contactNumber == null) {
              return this;
          }
          
          return filterByContactNumber(QueryOperator.EQUAL, contactNumber);
      }
    

      public TransportTruckRequest filterByContactNumber(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getContactNumberSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TransportTruckRequest selectContactNumber(){
          return select(CONTACT_NUMBER_PROPERTY);
      }

      public TransportTruckRequest unselectContactNumber(){
          return unselect(CONTACT_NUMBER_PROPERTY);
      }

      public SearchCriteria getContactNumberSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(CONTACT_NUMBER_PROPERTY, pQueryOperator, parameters);
      }

      public TransportTruckRequest orderByContactNumber(boolean asc){
          addOrderBy(CONTACT_NUMBER_PROPERTY, asc);
          return this;
      }
   
      public TransportTruckRequest filterByVehicleLicenseNumber(String vehicleLicenseNumber) {
          
          if (vehicleLicenseNumber == null) {
              return this;
          }
          
          return filterByVehicleLicenseNumber(QueryOperator.EQUAL, vehicleLicenseNumber);
      }
    

      public TransportTruckRequest filterByVehicleLicenseNumber(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVehicleLicenseNumberSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TransportTruckRequest selectVehicleLicenseNumber(){
          return select(VEHICLE_LICENSE_NUMBER_PROPERTY);
      }

      public TransportTruckRequest unselectVehicleLicenseNumber(){
          return unselect(VEHICLE_LICENSE_NUMBER_PROPERTY);
      }

      public SearchCriteria getVehicleLicenseNumberSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VEHICLE_LICENSE_NUMBER_PROPERTY, pQueryOperator, parameters);
      }

      public TransportTruckRequest orderByVehicleLicenseNumber(boolean asc){
          addOrderBy(VEHICLE_LICENSE_NUMBER_PROPERTY, asc);
          return this;
      }
   
      public TransportTruckRequest filterByEngineNumber(String engineNumber) {
          
          if (engineNumber == null) {
              return this;
          }
          
          return filterByEngineNumber(QueryOperator.EQUAL, engineNumber);
      }
    

      public TransportTruckRequest filterByEngineNumber(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getEngineNumberSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TransportTruckRequest selectEngineNumber(){
          return select(ENGINE_NUMBER_PROPERTY);
      }

      public TransportTruckRequest unselectEngineNumber(){
          return unselect(ENGINE_NUMBER_PROPERTY);
      }

      public SearchCriteria getEngineNumberSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ENGINE_NUMBER_PROPERTY, pQueryOperator, parameters);
      }

      public TransportTruckRequest orderByEngineNumber(boolean asc){
          addOrderBy(ENGINE_NUMBER_PROPERTY, asc);
          return this;
      }
   
      public TransportTruckRequest filterByMakeDate(Date makeDate) {
          
          if (makeDate == null) {
              return this;
          }
          
          return filterByMakeDate(QueryOperator.EQUAL, makeDate);
      }
    

      public TransportTruckRequest filterByMakeDate(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getMakeDateSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TransportTruckRequest selectMakeDate(){
          return select(MAKE_DATE_PROPERTY);
      }

      public TransportTruckRequest unselectMakeDate(){
          return unselect(MAKE_DATE_PROPERTY);
      }

      public SearchCriteria getMakeDateSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(MAKE_DATE_PROPERTY, pQueryOperator, parameters);
      }

      public TransportTruckRequest orderByMakeDate(boolean asc){
          addOrderBy(MAKE_DATE_PROPERTY, asc);
          return this;
      }
   
      public TransportTruckRequest filterByMileage(String mileage) {
          
          if (mileage == null) {
              return this;
          }
          
          return filterByMileage(QueryOperator.EQUAL, mileage);
      }
    

      public TransportTruckRequest filterByMileage(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getMileageSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TransportTruckRequest selectMileage(){
          return select(MILEAGE_PROPERTY);
      }

      public TransportTruckRequest unselectMileage(){
          return unselect(MILEAGE_PROPERTY);
      }

      public SearchCriteria getMileageSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(MILEAGE_PROPERTY, pQueryOperator, parameters);
      }

      public TransportTruckRequest orderByMileage(boolean asc){
          addOrderBy(MILEAGE_PROPERTY, asc);
          return this;
      }
   
      public TransportTruckRequest filterByBodyColor(String bodyColor) {
          
          if (bodyColor == null) {
              return this;
          }
          
          return filterByBodyColor(QueryOperator.EQUAL, bodyColor);
      }
    

      public TransportTruckRequest filterByBodyColor(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getBodyColorSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TransportTruckRequest selectBodyColor(){
          return select(BODY_COLOR_PROPERTY);
      }

      public TransportTruckRequest unselectBodyColor(){
          return unselect(BODY_COLOR_PROPERTY);
      }

      public SearchCriteria getBodyColorSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(BODY_COLOR_PROPERTY, pQueryOperator, parameters);
      }

      public TransportTruckRequest orderByBodyColor(boolean asc){
          addOrderBy(BODY_COLOR_PROPERTY, asc);
          return this;
      }
   
      public TransportTruckRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public TransportTruckRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TransportTruckRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public TransportTruckRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public TransportTruckRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public TransportTruckRequest filterByOwner(TransportFleetRequest owner){
        return filterByOwner(owner, ownerList -> ownerList.stream().map(TransportFleet::getId).collect(Collectors.toSet()));
    }

    public TransportTruckRequest filterByOwner(TransportFleetRequest owner, IDRefine<TransportFleet> idRefine) {
        return addSearchCriteria(createOwnerCriteria(owner, idRefine));
    }

    public SearchCriteria createOwnerCriteria(TransportFleetRequest owner, IDRefine<TransportFleet> idRefine) {
        return new RefinedIdInCriteria(owner, OWNER_PROPERTY, idRefine);
    }
    

    
    public TransportTruckRequest selectOwner(){
        return selectOwner(TransportFleetRequest.newInstance().selectSelf());
    }

    public TransportTruckRequest selectOwner(TransportFleetRequest owner){
        selectParent(OWNER_PROPERTY, owner);
        return this;
    }
    

    public TransportTruckRequest unselectOwner(){
        unselectParent(OWNER_PROPERTY);
        return this;
    }

  


  

    public TransportTruckRequest hasTransportTask() {
      return hasTransportTask(TransportTaskRequest.newInstance());
    }

    public TransportTruckRequest hasTransportTask(TransportTaskRequest transportTask) {
        return hasTransportTask(transportTask, transportTaskList -> transportTaskList.stream().map(TransportTask::getTruck).map(TransportTruck::getId).collect(Collectors.toSet()));
    }

    public TransportTruckRequest hasTransportTask(TransportTaskRequest transportTask, IDRefine<TransportTask> idRefine) {
        transportTask.select(TransportTask.TRUCK_PROPERTY);
        return addSearchCriteria(createTransportTaskCriteria(transportTask, idRefine));
    }

    public SearchCriteria createTransportTaskCriteria(TransportTaskRequest transportTask, IDRefine<TransportTask> idRefine){
       return new RefinedIdInCriteria(transportTask, ID_PROPERTY, idRefine);
    }

    public TransportTruckRequest selectTransportTaskList(TransportTaskRequest transportTask) {
        selectChild(TransportTask.TRUCK_PROPERTY, transportTask);
        return this;
    }

    public TransportTruckRequest selectTransportTaskList() {
        return selectTransportTaskList(TransportTaskRequest.newInstance().selectAll());
    }

    public TransportTruckRequest unselectTransportTaskList(){
        unselectChild(TransportTask.TRUCK_PROPERTY, TransportTask.class);
        return this;
    }
  

   public TransportTruckRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

