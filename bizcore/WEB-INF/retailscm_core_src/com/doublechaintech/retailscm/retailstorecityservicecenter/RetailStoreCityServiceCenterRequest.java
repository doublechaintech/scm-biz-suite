package com.doublechaintech.retailscm.retailstorecityservicecenter;

import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import java.util.Date;
import com.doublechaintech.retailscm.cityevent.CityEvent;
import com.doublechaintech.retailscm.citypartner.CityPartner;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;
import com.doublechaintech.retailscm.cityevent.CityEventRequest;
import com.doublechaintech.retailscm.citypartner.CityPartnerRequest;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomerRequest;
import com.doublechaintech.retailscm.retailstore.RetailStoreRequest;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenterRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter.*;

public class RetailStoreCityServiceCenterRequest extends BaseRequest<RetailStoreCityServiceCenter> {
    public static RetailStoreCityServiceCenterRequest newInstance() {
        return new RetailStoreCityServiceCenterRequest().selectId();
    }

    public String getInternalType() {
        return "RetailStoreCityServiceCenter";
    }

    public RetailStoreCityServiceCenterRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public RetailStoreCityServiceCenterRequest select(String... names) {
        super.select(names);
        return this;
    }

    public RetailStoreCityServiceCenterRequest selectAll() {return this.selectId().selectName().selectFounded().selectBelongsTo().selectLastUpdateTime().selectVersion();
    }

    public RetailStoreCityServiceCenterRequest selectSelf() {return this.selectId().selectName().selectFounded().selectLastUpdateTime().selectVersion();
    }

    public RetailStoreCityServiceCenterRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public RetailStoreCityServiceCenterRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static RetailStoreCityServiceCenterRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public RetailStoreCityServiceCenterRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public RetailStoreCityServiceCenterRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreCityServiceCenterRequest selectId(){
          return select(ID_PROPERTY);
      }

      public RetailStoreCityServiceCenterRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreCityServiceCenterRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreCityServiceCenterRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public RetailStoreCityServiceCenterRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreCityServiceCenterRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public RetailStoreCityServiceCenterRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreCityServiceCenterRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreCityServiceCenterRequest filterByFounded(Date founded) {
          
          if (founded == null) {
              return this;
          }
          
          return filterByFounded(QueryOperator.EQUAL, founded);
      }
    

      public RetailStoreCityServiceCenterRequest filterByFounded(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getFoundedSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreCityServiceCenterRequest selectFounded(){
          return select(FOUNDED_PROPERTY);
      }

      public RetailStoreCityServiceCenterRequest unselectFounded(){
          return unselect(FOUNDED_PROPERTY);
      }

      public SearchCriteria getFoundedSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(FOUNDED_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreCityServiceCenterRequest orderByFounded(boolean asc){
          addOrderBy(FOUNDED_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreCityServiceCenterRequest filterByLastUpdateTime(DateTime lastUpdateTime) {
          
          if (lastUpdateTime == null) {
              return this;
          }
          
          return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
      }
    

      public RetailStoreCityServiceCenterRequest filterByLastUpdateTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreCityServiceCenterRequest selectLastUpdateTime(){
          return select(LAST_UPDATE_TIME_PROPERTY);
      }

      public RetailStoreCityServiceCenterRequest unselectLastUpdateTime(){
          return unselect(LAST_UPDATE_TIME_PROPERTY);
      }

      public SearchCriteria getLastUpdateTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreCityServiceCenterRequest orderByLastUpdateTime(boolean asc){
          addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreCityServiceCenterRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public RetailStoreCityServiceCenterRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreCityServiceCenterRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public RetailStoreCityServiceCenterRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreCityServiceCenterRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public RetailStoreCityServiceCenterRequest filterByBelongsTo(RetailStoreProvinceCenterRequest belongsTo){
        return filterByBelongsTo(belongsTo, belongsToList -> belongsToList.stream().map(RetailStoreProvinceCenter::getId).collect(Collectors.toSet()));
    }

    public RetailStoreCityServiceCenterRequest filterByBelongsTo(RetailStoreProvinceCenterRequest belongsTo, IDRefine<RetailStoreProvinceCenter> idRefine) {
        return addSearchCriteria(createBelongsToCriteria(belongsTo, idRefine));
    }

    public SearchCriteria createBelongsToCriteria(RetailStoreProvinceCenterRequest belongsTo, IDRefine<RetailStoreProvinceCenter> idRefine) {
        return new RefinedIdInCriteria(belongsTo, BELONGS_TO_PROPERTY, idRefine);
    }
    

    
    public RetailStoreCityServiceCenterRequest selectBelongsTo(){
        return selectBelongsTo(RetailStoreProvinceCenterRequest.newInstance().selectSelf());
    }

    public RetailStoreCityServiceCenterRequest selectBelongsTo(RetailStoreProvinceCenterRequest belongsTo){
        selectParent(BELONGS_TO_PROPERTY, belongsTo);
        return this;
    }
    

    public RetailStoreCityServiceCenterRequest unselectBelongsTo(){
        unselectParent(BELONGS_TO_PROPERTY);
        return this;
    }

  


  

    public RetailStoreCityServiceCenterRequest hasCityPartner() {
      return hasCityPartner(CityPartnerRequest.newInstance());
    }

    public RetailStoreCityServiceCenterRequest hasCityPartner(CityPartnerRequest cityPartner) {
        return hasCityPartner(cityPartner, cityPartnerList -> cityPartnerList.stream().map(CityPartner::getCityServiceCenter).map(RetailStoreCityServiceCenter::getId).collect(Collectors.toSet()));
    }

    public RetailStoreCityServiceCenterRequest hasCityPartner(CityPartnerRequest cityPartner, IDRefine<CityPartner> idRefine) {
        cityPartner.select(CityPartner.CITY_SERVICE_CENTER_PROPERTY);
        return addSearchCriteria(createCityPartnerCriteria(cityPartner, idRefine));
    }

    public SearchCriteria createCityPartnerCriteria(CityPartnerRequest cityPartner, IDRefine<CityPartner> idRefine){
       return new RefinedIdInCriteria(cityPartner, ID_PROPERTY, idRefine);
    }

    public RetailStoreCityServiceCenterRequest selectCityPartnerList(CityPartnerRequest cityPartner) {
        selectChild(CityPartner.CITY_SERVICE_CENTER_PROPERTY, cityPartner);
        return this;
    }

    public RetailStoreCityServiceCenterRequest selectCityPartnerList() {
        return selectCityPartnerList(CityPartnerRequest.newInstance().selectAll());
    }

    public RetailStoreCityServiceCenterRequest unselectCityPartnerList(){
        unselectChild(CityPartner.CITY_SERVICE_CENTER_PROPERTY, CityPartner.class);
        return this;
    }
  

    public RetailStoreCityServiceCenterRequest hasPotentialCustomer() {
      return hasPotentialCustomer(PotentialCustomerRequest.newInstance());
    }

    public RetailStoreCityServiceCenterRequest hasPotentialCustomer(PotentialCustomerRequest potentialCustomer) {
        return hasPotentialCustomer(potentialCustomer, potentialCustomerList -> potentialCustomerList.stream().map(PotentialCustomer::getCityServiceCenter).map(RetailStoreCityServiceCenter::getId).collect(Collectors.toSet()));
    }

    public RetailStoreCityServiceCenterRequest hasPotentialCustomer(PotentialCustomerRequest potentialCustomer, IDRefine<PotentialCustomer> idRefine) {
        potentialCustomer.select(PotentialCustomer.CITY_SERVICE_CENTER_PROPERTY);
        return addSearchCriteria(createPotentialCustomerCriteria(potentialCustomer, idRefine));
    }

    public SearchCriteria createPotentialCustomerCriteria(PotentialCustomerRequest potentialCustomer, IDRefine<PotentialCustomer> idRefine){
       return new RefinedIdInCriteria(potentialCustomer, ID_PROPERTY, idRefine);
    }

    public RetailStoreCityServiceCenterRequest selectPotentialCustomerList(PotentialCustomerRequest potentialCustomer) {
        selectChild(PotentialCustomer.CITY_SERVICE_CENTER_PROPERTY, potentialCustomer);
        return this;
    }

    public RetailStoreCityServiceCenterRequest selectPotentialCustomerList() {
        return selectPotentialCustomerList(PotentialCustomerRequest.newInstance().selectAll());
    }

    public RetailStoreCityServiceCenterRequest unselectPotentialCustomerList(){
        unselectChild(PotentialCustomer.CITY_SERVICE_CENTER_PROPERTY, PotentialCustomer.class);
        return this;
    }
  

    public RetailStoreCityServiceCenterRequest hasCityEvent() {
      return hasCityEvent(CityEventRequest.newInstance());
    }

    public RetailStoreCityServiceCenterRequest hasCityEvent(CityEventRequest cityEvent) {
        return hasCityEvent(cityEvent, cityEventList -> cityEventList.stream().map(CityEvent::getCityServiceCenter).map(RetailStoreCityServiceCenter::getId).collect(Collectors.toSet()));
    }

    public RetailStoreCityServiceCenterRequest hasCityEvent(CityEventRequest cityEvent, IDRefine<CityEvent> idRefine) {
        cityEvent.select(CityEvent.CITY_SERVICE_CENTER_PROPERTY);
        return addSearchCriteria(createCityEventCriteria(cityEvent, idRefine));
    }

    public SearchCriteria createCityEventCriteria(CityEventRequest cityEvent, IDRefine<CityEvent> idRefine){
       return new RefinedIdInCriteria(cityEvent, ID_PROPERTY, idRefine);
    }

    public RetailStoreCityServiceCenterRequest selectCityEventList(CityEventRequest cityEvent) {
        selectChild(CityEvent.CITY_SERVICE_CENTER_PROPERTY, cityEvent);
        return this;
    }

    public RetailStoreCityServiceCenterRequest selectCityEventList() {
        return selectCityEventList(CityEventRequest.newInstance().selectAll());
    }

    public RetailStoreCityServiceCenterRequest unselectCityEventList(){
        unselectChild(CityEvent.CITY_SERVICE_CENTER_PROPERTY, CityEvent.class);
        return this;
    }
  

    public RetailStoreCityServiceCenterRequest hasRetailStore() {
      return hasRetailStore(RetailStoreRequest.newInstance());
    }

    public RetailStoreCityServiceCenterRequest hasRetailStore(RetailStoreRequest retailStore) {
        return hasRetailStore(retailStore, retailStoreList -> retailStoreList.stream().map(RetailStore::getCityServiceCenter).map(RetailStoreCityServiceCenter::getId).collect(Collectors.toSet()));
    }

    public RetailStoreCityServiceCenterRequest hasRetailStore(RetailStoreRequest retailStore, IDRefine<RetailStore> idRefine) {
        retailStore.select(RetailStore.CITY_SERVICE_CENTER_PROPERTY);
        return addSearchCriteria(createRetailStoreCriteria(retailStore, idRefine));
    }

    public SearchCriteria createRetailStoreCriteria(RetailStoreRequest retailStore, IDRefine<RetailStore> idRefine){
       return new RefinedIdInCriteria(retailStore, ID_PROPERTY, idRefine);
    }

    public RetailStoreCityServiceCenterRequest selectRetailStoreList(RetailStoreRequest retailStore) {
        selectChild(RetailStore.CITY_SERVICE_CENTER_PROPERTY, retailStore);
        return this;
    }

    public RetailStoreCityServiceCenterRequest selectRetailStoreList() {
        return selectRetailStoreList(RetailStoreRequest.newInstance().selectAll());
    }

    public RetailStoreCityServiceCenterRequest unselectRetailStoreList(){
        unselectChild(RetailStore.CITY_SERVICE_CENTER_PROPERTY, RetailStore.class);
        return this;
    }
  

   public RetailStoreCityServiceCenterRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

