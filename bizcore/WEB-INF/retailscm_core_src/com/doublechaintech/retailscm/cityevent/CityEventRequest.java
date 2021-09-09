package com.doublechaintech.retailscm.cityevent;

import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.eventattendance.EventAttendance;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;
import com.doublechaintech.retailscm.eventattendance.EventAttendanceRequest;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.cityevent.CityEvent.*;

public class CityEventRequest extends BaseRequest<CityEvent> {
    public static CityEventRequest newInstance() {
        return new CityEventRequest().selectId();
    }

    public String getInternalType() {
        return "CityEvent";
    }

    public CityEventRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public CityEventRequest select(String... names) {
        super.select(names);
        return this;
    }

    public CityEventRequest selectAll() {return this.selectId().selectName().selectMobile().selectCityServiceCenter().selectDescription().selectLastUpdateTime().selectVersion();
    }

    public CityEventRequest selectSelf() {return this.selectId().selectName().selectMobile().selectDescription().selectLastUpdateTime().selectVersion();
    }

    public CityEventRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public CityEventRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static CityEventRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public CityEventRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public CityEventRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public CityEventRequest selectId(){
          return select(ID_PROPERTY);
      }

      public CityEventRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public CityEventRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public CityEventRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public CityEventRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public CityEventRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public CityEventRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public CityEventRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public CityEventRequest filterByMobile(String mobile) {
          
          if (mobile == null) {
              return this;
          }
          
          return filterByMobile(QueryOperator.EQUAL, mobile);
      }
    

      public CityEventRequest filterByMobile(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getMobileSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public CityEventRequest selectMobile(){
          return select(MOBILE_PROPERTY);
      }

      public CityEventRequest unselectMobile(){
          return unselect(MOBILE_PROPERTY);
      }

      public SearchCriteria getMobileSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(MOBILE_PROPERTY, pQueryOperator, parameters);
      }

      public CityEventRequest orderByMobile(boolean asc){
          addOrderBy(MOBILE_PROPERTY, asc);
          return this;
      }
   
      public CityEventRequest filterByDescription(String description) {
          
          if (description == null) {
              return this;
          }
          
          return filterByDescription(QueryOperator.EQUAL, description);
      }
    

      public CityEventRequest filterByDescription(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public CityEventRequest selectDescription(){
          return select(DESCRIPTION_PROPERTY);
      }

      public CityEventRequest unselectDescription(){
          return unselect(DESCRIPTION_PROPERTY);
      }

      public SearchCriteria getDescriptionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
      }

      public CityEventRequest orderByDescription(boolean asc){
          addOrderBy(DESCRIPTION_PROPERTY, asc);
          return this;
      }
   
      public CityEventRequest filterByLastUpdateTime(DateTime lastUpdateTime) {
          
          if (lastUpdateTime == null) {
              return this;
          }
          
          return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
      }
    

      public CityEventRequest filterByLastUpdateTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public CityEventRequest selectLastUpdateTime(){
          return select(LAST_UPDATE_TIME_PROPERTY);
      }

      public CityEventRequest unselectLastUpdateTime(){
          return unselect(LAST_UPDATE_TIME_PROPERTY);
      }

      public SearchCriteria getLastUpdateTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public CityEventRequest orderByLastUpdateTime(boolean asc){
          addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
          return this;
      }
   
      public CityEventRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public CityEventRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public CityEventRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public CityEventRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public CityEventRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public CityEventRequest filterByCityServiceCenter(RetailStoreCityServiceCenterRequest cityServiceCenter){
        return filterByCityServiceCenter(cityServiceCenter, cityServiceCenterList -> cityServiceCenterList.stream().map(RetailStoreCityServiceCenter::getId).collect(Collectors.toSet()));
    }

    public CityEventRequest filterByCityServiceCenter(RetailStoreCityServiceCenterRequest cityServiceCenter, IDRefine<RetailStoreCityServiceCenter> idRefine) {
        return addSearchCriteria(createCityServiceCenterCriteria(cityServiceCenter, idRefine));
    }

    public SearchCriteria createCityServiceCenterCriteria(RetailStoreCityServiceCenterRequest cityServiceCenter, IDRefine<RetailStoreCityServiceCenter> idRefine) {
        return new RefinedIdInCriteria(cityServiceCenter, CITY_SERVICE_CENTER_PROPERTY, idRefine);
    }
    

    
    public CityEventRequest selectCityServiceCenter(){
        return selectCityServiceCenter(RetailStoreCityServiceCenterRequest.newInstance().selectSelf());
    }

    public CityEventRequest selectCityServiceCenter(RetailStoreCityServiceCenterRequest cityServiceCenter){
        selectParent(CITY_SERVICE_CENTER_PROPERTY, cityServiceCenter);
        return this;
    }
    

    public CityEventRequest unselectCityServiceCenter(){
        unselectParent(CITY_SERVICE_CENTER_PROPERTY);
        return this;
    }

  


  

    public CityEventRequest hasEventAttendance() {
      return hasEventAttendance(EventAttendanceRequest.newInstance());
    }

    public CityEventRequest hasEventAttendance(EventAttendanceRequest eventAttendance) {
        return hasEventAttendance(eventAttendance, eventAttendanceList -> eventAttendanceList.stream().map(EventAttendance::getCityEvent).map(CityEvent::getId).collect(Collectors.toSet()));
    }

    public CityEventRequest hasEventAttendance(EventAttendanceRequest eventAttendance, IDRefine<EventAttendance> idRefine) {
        eventAttendance.select(EventAttendance.CITY_EVENT_PROPERTY);
        return addSearchCriteria(createEventAttendanceCriteria(eventAttendance, idRefine));
    }

    public SearchCriteria createEventAttendanceCriteria(EventAttendanceRequest eventAttendance, IDRefine<EventAttendance> idRefine){
       return new RefinedIdInCriteria(eventAttendance, ID_PROPERTY, idRefine);
    }

    public CityEventRequest selectEventAttendanceList(EventAttendanceRequest eventAttendance) {
        selectChild(EventAttendance.CITY_EVENT_PROPERTY, eventAttendance);
        return this;
    }

    public CityEventRequest selectEventAttendanceList() {
        return selectEventAttendanceList(EventAttendanceRequest.newInstance().selectAll());
    }

    public CityEventRequest unselectEventAttendanceList(){
        unselectChild(EventAttendance.CITY_EVENT_PROPERTY, EventAttendance.class);
        return this;
    }
  

   public CityEventRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

