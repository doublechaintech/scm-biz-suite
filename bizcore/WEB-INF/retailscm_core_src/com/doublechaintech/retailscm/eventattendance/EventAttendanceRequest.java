package com.doublechaintech.retailscm.eventattendance;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.cityevent.CityEvent;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;
import com.doublechaintech.retailscm.cityevent.CityEventRequest;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomerRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.eventattendance.EventAttendance.*;

public class EventAttendanceRequest extends BaseRequest<EventAttendance> {
    public static EventAttendanceRequest newInstance() {
        return new EventAttendanceRequest().selectId();
    }

    public String getInternalType() {
        return "EventAttendance";
    }

    public EventAttendanceRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public EventAttendanceRequest select(String... names) {
        super.select(names);
        return this;
    }

    public EventAttendanceRequest selectAll() {return this.selectId().selectName().selectPotentialCustomer().selectCityEvent().selectDescription().selectVersion();
    }

    public EventAttendanceRequest selectSelf() {return this.selectId().selectName().selectDescription().selectVersion();
    }

    public EventAttendanceRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public EventAttendanceRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static EventAttendanceRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public EventAttendanceRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public EventAttendanceRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EventAttendanceRequest selectId(){
          return select(ID_PROPERTY);
      }

      public EventAttendanceRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public EventAttendanceRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public EventAttendanceRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public EventAttendanceRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EventAttendanceRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public EventAttendanceRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public EventAttendanceRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public EventAttendanceRequest filterByDescription(String description) {
          
          if (description == null) {
              return this;
          }
          
          return filterByDescription(QueryOperator.EQUAL, description);
      }
    

      public EventAttendanceRequest filterByDescription(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EventAttendanceRequest selectDescription(){
          return select(DESCRIPTION_PROPERTY);
      }

      public EventAttendanceRequest unselectDescription(){
          return unselect(DESCRIPTION_PROPERTY);
      }

      public SearchCriteria getDescriptionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
      }

      public EventAttendanceRequest orderByDescription(boolean asc){
          addOrderBy(DESCRIPTION_PROPERTY, asc);
          return this;
      }
   
      public EventAttendanceRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public EventAttendanceRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EventAttendanceRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public EventAttendanceRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public EventAttendanceRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public EventAttendanceRequest filterByPotentialCustomer(PotentialCustomerRequest potentialCustomer){
        return filterByPotentialCustomer(potentialCustomer, potentialCustomerList -> potentialCustomerList.stream().map(PotentialCustomer::getId).collect(Collectors.toSet()));
    }

    public EventAttendanceRequest filterByPotentialCustomer(PotentialCustomerRequest potentialCustomer, IDRefine<PotentialCustomer> idRefine) {
        return addSearchCriteria(createPotentialCustomerCriteria(potentialCustomer, idRefine));
    }

    public SearchCriteria createPotentialCustomerCriteria(PotentialCustomerRequest potentialCustomer, IDRefine<PotentialCustomer> idRefine) {
        return new RefinedIdInCriteria(potentialCustomer, POTENTIAL_CUSTOMER_PROPERTY, idRefine);
    }
    

    
    public EventAttendanceRequest selectPotentialCustomer(){
        return selectPotentialCustomer(PotentialCustomerRequest.newInstance().selectSelf());
    }

    public EventAttendanceRequest selectPotentialCustomer(PotentialCustomerRequest potentialCustomer){
        selectParent(POTENTIAL_CUSTOMER_PROPERTY, potentialCustomer);
        return this;
    }
    

    public EventAttendanceRequest unselectPotentialCustomer(){
        unselectParent(POTENTIAL_CUSTOMER_PROPERTY);
        return this;
    }

  

    
    public EventAttendanceRequest filterByCityEvent(CityEventRequest cityEvent){
        return filterByCityEvent(cityEvent, cityEventList -> cityEventList.stream().map(CityEvent::getId).collect(Collectors.toSet()));
    }

    public EventAttendanceRequest filterByCityEvent(CityEventRequest cityEvent, IDRefine<CityEvent> idRefine) {
        return addSearchCriteria(createCityEventCriteria(cityEvent, idRefine));
    }

    public SearchCriteria createCityEventCriteria(CityEventRequest cityEvent, IDRefine<CityEvent> idRefine) {
        return new RefinedIdInCriteria(cityEvent, CITY_EVENT_PROPERTY, idRefine);
    }
    

    
    public EventAttendanceRequest selectCityEvent(){
        return selectCityEvent(CityEventRequest.newInstance().selectSelf());
    }

    public EventAttendanceRequest selectCityEvent(CityEventRequest cityEvent){
        selectParent(CITY_EVENT_PROPERTY, cityEvent);
        return this;
    }
    

    public EventAttendanceRequest unselectCityEvent(){
        unselectParent(CITY_EVENT_PROPERTY);
        return this;
    }

  


  

   public EventAttendanceRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

