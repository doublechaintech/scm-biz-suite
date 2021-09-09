package com.doublechaintech.retailscm.citypartner;

import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;
import com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContact;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomerRequest;
import com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContactRequest;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.citypartner.CityPartner.*;

public class CityPartnerRequest extends BaseRequest<CityPartner> {
    public static CityPartnerRequest newInstance() {
        return new CityPartnerRequest().selectId();
    }

    public String getInternalType() {
        return "CityPartner";
    }

    public CityPartnerRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public CityPartnerRequest select(String... names) {
        super.select(names);
        return this;
    }

    public CityPartnerRequest selectAll() {return this.selectId().selectName().selectMobile().selectCityServiceCenter().selectDescription().selectLastUpdateTime().selectVersion();
    }

    public CityPartnerRequest selectSelf() {return this.selectId().selectName().selectMobile().selectDescription().selectLastUpdateTime().selectVersion();
    }

    public CityPartnerRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public CityPartnerRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static CityPartnerRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public CityPartnerRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public CityPartnerRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public CityPartnerRequest selectId(){
          return select(ID_PROPERTY);
      }

      public CityPartnerRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public CityPartnerRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public CityPartnerRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public CityPartnerRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public CityPartnerRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public CityPartnerRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public CityPartnerRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public CityPartnerRequest filterByMobile(String mobile) {
          
          if (mobile == null) {
              return this;
          }
          
          return filterByMobile(QueryOperator.EQUAL, mobile);
      }
    

      public CityPartnerRequest filterByMobile(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getMobileSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public CityPartnerRequest selectMobile(){
          return select(MOBILE_PROPERTY);
      }

      public CityPartnerRequest unselectMobile(){
          return unselect(MOBILE_PROPERTY);
      }

      public SearchCriteria getMobileSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(MOBILE_PROPERTY, pQueryOperator, parameters);
      }

      public CityPartnerRequest orderByMobile(boolean asc){
          addOrderBy(MOBILE_PROPERTY, asc);
          return this;
      }
   
      public CityPartnerRequest filterByDescription(String description) {
          
          if (description == null) {
              return this;
          }
          
          return filterByDescription(QueryOperator.EQUAL, description);
      }
    

      public CityPartnerRequest filterByDescription(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public CityPartnerRequest selectDescription(){
          return select(DESCRIPTION_PROPERTY);
      }

      public CityPartnerRequest unselectDescription(){
          return unselect(DESCRIPTION_PROPERTY);
      }

      public SearchCriteria getDescriptionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
      }

      public CityPartnerRequest orderByDescription(boolean asc){
          addOrderBy(DESCRIPTION_PROPERTY, asc);
          return this;
      }
   
      public CityPartnerRequest filterByLastUpdateTime(DateTime lastUpdateTime) {
          
          if (lastUpdateTime == null) {
              return this;
          }
          
          return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
      }
    

      public CityPartnerRequest filterByLastUpdateTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public CityPartnerRequest selectLastUpdateTime(){
          return select(LAST_UPDATE_TIME_PROPERTY);
      }

      public CityPartnerRequest unselectLastUpdateTime(){
          return unselect(LAST_UPDATE_TIME_PROPERTY);
      }

      public SearchCriteria getLastUpdateTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public CityPartnerRequest orderByLastUpdateTime(boolean asc){
          addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
          return this;
      }
   
      public CityPartnerRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public CityPartnerRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public CityPartnerRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public CityPartnerRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public CityPartnerRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public CityPartnerRequest filterByCityServiceCenter(RetailStoreCityServiceCenterRequest cityServiceCenter){
        return filterByCityServiceCenter(cityServiceCenter, cityServiceCenterList -> cityServiceCenterList.stream().map(RetailStoreCityServiceCenter::getId).collect(Collectors.toSet()));
    }

    public CityPartnerRequest filterByCityServiceCenter(RetailStoreCityServiceCenterRequest cityServiceCenter, IDRefine<RetailStoreCityServiceCenter> idRefine) {
        return addSearchCriteria(createCityServiceCenterCriteria(cityServiceCenter, idRefine));
    }

    public SearchCriteria createCityServiceCenterCriteria(RetailStoreCityServiceCenterRequest cityServiceCenter, IDRefine<RetailStoreCityServiceCenter> idRefine) {
        return new RefinedIdInCriteria(cityServiceCenter, CITY_SERVICE_CENTER_PROPERTY, idRefine);
    }
    

    
    public CityPartnerRequest selectCityServiceCenter(){
        return selectCityServiceCenter(RetailStoreCityServiceCenterRequest.newInstance().selectSelf());
    }

    public CityPartnerRequest selectCityServiceCenter(RetailStoreCityServiceCenterRequest cityServiceCenter){
        selectParent(CITY_SERVICE_CENTER_PROPERTY, cityServiceCenter);
        return this;
    }
    

    public CityPartnerRequest unselectCityServiceCenter(){
        unselectParent(CITY_SERVICE_CENTER_PROPERTY);
        return this;
    }

  


  

    public CityPartnerRequest hasPotentialCustomer() {
      return hasPotentialCustomer(PotentialCustomerRequest.newInstance());
    }

    public CityPartnerRequest hasPotentialCustomer(PotentialCustomerRequest potentialCustomer) {
        return hasPotentialCustomer(potentialCustomer, potentialCustomerList -> potentialCustomerList.stream().map(PotentialCustomer::getCityPartner).map(CityPartner::getId).collect(Collectors.toSet()));
    }

    public CityPartnerRequest hasPotentialCustomer(PotentialCustomerRequest potentialCustomer, IDRefine<PotentialCustomer> idRefine) {
        potentialCustomer.select(PotentialCustomer.CITY_PARTNER_PROPERTY);
        return addSearchCriteria(createPotentialCustomerCriteria(potentialCustomer, idRefine));
    }

    public SearchCriteria createPotentialCustomerCriteria(PotentialCustomerRequest potentialCustomer, IDRefine<PotentialCustomer> idRefine){
       return new RefinedIdInCriteria(potentialCustomer, ID_PROPERTY, idRefine);
    }

    public CityPartnerRequest selectPotentialCustomerList(PotentialCustomerRequest potentialCustomer) {
        selectChild(PotentialCustomer.CITY_PARTNER_PROPERTY, potentialCustomer);
        return this;
    }

    public CityPartnerRequest selectPotentialCustomerList() {
        return selectPotentialCustomerList(PotentialCustomerRequest.newInstance().selectAll());
    }

    public CityPartnerRequest unselectPotentialCustomerList(){
        unselectChild(PotentialCustomer.CITY_PARTNER_PROPERTY, PotentialCustomer.class);
        return this;
    }
  

    public CityPartnerRequest hasPotentialCustomerContact() {
      return hasPotentialCustomerContact(PotentialCustomerContactRequest.newInstance());
    }

    public CityPartnerRequest hasPotentialCustomerContact(PotentialCustomerContactRequest potentialCustomerContact) {
        return hasPotentialCustomerContact(potentialCustomerContact, potentialCustomerContactList -> potentialCustomerContactList.stream().map(PotentialCustomerContact::getCityPartner).map(CityPartner::getId).collect(Collectors.toSet()));
    }

    public CityPartnerRequest hasPotentialCustomerContact(PotentialCustomerContactRequest potentialCustomerContact, IDRefine<PotentialCustomerContact> idRefine) {
        potentialCustomerContact.select(PotentialCustomerContact.CITY_PARTNER_PROPERTY);
        return addSearchCriteria(createPotentialCustomerContactCriteria(potentialCustomerContact, idRefine));
    }

    public SearchCriteria createPotentialCustomerContactCriteria(PotentialCustomerContactRequest potentialCustomerContact, IDRefine<PotentialCustomerContact> idRefine){
       return new RefinedIdInCriteria(potentialCustomerContact, ID_PROPERTY, idRefine);
    }

    public CityPartnerRequest selectPotentialCustomerContactList(PotentialCustomerContactRequest potentialCustomerContact) {
        selectChild(PotentialCustomerContact.CITY_PARTNER_PROPERTY, potentialCustomerContact);
        return this;
    }

    public CityPartnerRequest selectPotentialCustomerContactList() {
        return selectPotentialCustomerContactList(PotentialCustomerContactRequest.newInstance().selectAll());
    }

    public CityPartnerRequest unselectPotentialCustomerContactList(){
        unselectChild(PotentialCustomerContact.CITY_PARTNER_PROPERTY, PotentialCustomerContact.class);
        return this;
    }
  

   public CityPartnerRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

