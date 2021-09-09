package com.doublechaintech.retailscm.potentialcustomer;

import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.citypartner.CityPartner;
import com.doublechaintech.retailscm.eventattendance.EventAttendance;
import com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContact;
import com.doublechaintech.retailscm.potentialcustomercontactperson.PotentialCustomerContactPerson;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;
import com.doublechaintech.retailscm.citypartner.CityPartnerRequest;
import com.doublechaintech.retailscm.eventattendance.EventAttendanceRequest;
import com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContactRequest;
import com.doublechaintech.retailscm.potentialcustomercontactperson.PotentialCustomerContactPersonRequest;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer.*;

public class PotentialCustomerRequest extends BaseRequest<PotentialCustomer> {
    public static PotentialCustomerRequest newInstance() {
        return new PotentialCustomerRequest().selectId();
    }

    public String getInternalType() {
        return "PotentialCustomer";
    }

    public PotentialCustomerRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public PotentialCustomerRequest select(String... names) {
        super.select(names);
        return this;
    }

    public PotentialCustomerRequest selectAll() {return this.selectId().selectName().selectMobile().selectCityServiceCenter().selectCityPartner().selectDescription().selectLastUpdateTime().selectVersion();
    }

    public PotentialCustomerRequest selectSelf() {return this.selectId().selectName().selectMobile().selectDescription().selectLastUpdateTime().selectVersion();
    }

    public PotentialCustomerRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public PotentialCustomerRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static PotentialCustomerRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public PotentialCustomerRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public PotentialCustomerRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public PotentialCustomerRequest selectId(){
          return select(ID_PROPERTY);
      }

      public PotentialCustomerRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public PotentialCustomerRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public PotentialCustomerRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public PotentialCustomerRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public PotentialCustomerRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public PotentialCustomerRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public PotentialCustomerRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public PotentialCustomerRequest filterByMobile(String mobile) {
          
          if (mobile == null) {
              return this;
          }
          
          return filterByMobile(QueryOperator.EQUAL, mobile);
      }
    

      public PotentialCustomerRequest filterByMobile(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getMobileSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public PotentialCustomerRequest selectMobile(){
          return select(MOBILE_PROPERTY);
      }

      public PotentialCustomerRequest unselectMobile(){
          return unselect(MOBILE_PROPERTY);
      }

      public SearchCriteria getMobileSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(MOBILE_PROPERTY, pQueryOperator, parameters);
      }

      public PotentialCustomerRequest orderByMobile(boolean asc){
          addOrderBy(MOBILE_PROPERTY, asc);
          return this;
      }
   
      public PotentialCustomerRequest filterByDescription(String description) {
          
          if (description == null) {
              return this;
          }
          
          return filterByDescription(QueryOperator.EQUAL, description);
      }
    

      public PotentialCustomerRequest filterByDescription(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public PotentialCustomerRequest selectDescription(){
          return select(DESCRIPTION_PROPERTY);
      }

      public PotentialCustomerRequest unselectDescription(){
          return unselect(DESCRIPTION_PROPERTY);
      }

      public SearchCriteria getDescriptionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
      }

      public PotentialCustomerRequest orderByDescription(boolean asc){
          addOrderBy(DESCRIPTION_PROPERTY, asc);
          return this;
      }
   
      public PotentialCustomerRequest filterByLastUpdateTime(DateTime lastUpdateTime) {
          
          if (lastUpdateTime == null) {
              return this;
          }
          
          return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
      }
    

      public PotentialCustomerRequest filterByLastUpdateTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public PotentialCustomerRequest selectLastUpdateTime(){
          return select(LAST_UPDATE_TIME_PROPERTY);
      }

      public PotentialCustomerRequest unselectLastUpdateTime(){
          return unselect(LAST_UPDATE_TIME_PROPERTY);
      }

      public SearchCriteria getLastUpdateTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public PotentialCustomerRequest orderByLastUpdateTime(boolean asc){
          addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
          return this;
      }
   
      public PotentialCustomerRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public PotentialCustomerRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public PotentialCustomerRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public PotentialCustomerRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public PotentialCustomerRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public PotentialCustomerRequest filterByCityServiceCenter(RetailStoreCityServiceCenterRequest cityServiceCenter){
        return filterByCityServiceCenter(cityServiceCenter, cityServiceCenterList -> cityServiceCenterList.stream().map(RetailStoreCityServiceCenter::getId).collect(Collectors.toSet()));
    }

    public PotentialCustomerRequest filterByCityServiceCenter(RetailStoreCityServiceCenterRequest cityServiceCenter, IDRefine<RetailStoreCityServiceCenter> idRefine) {
        return addSearchCriteria(createCityServiceCenterCriteria(cityServiceCenter, idRefine));
    }

    public SearchCriteria createCityServiceCenterCriteria(RetailStoreCityServiceCenterRequest cityServiceCenter, IDRefine<RetailStoreCityServiceCenter> idRefine) {
        return new RefinedIdInCriteria(cityServiceCenter, CITY_SERVICE_CENTER_PROPERTY, idRefine);
    }
    

    
    public PotentialCustomerRequest selectCityServiceCenter(){
        return selectCityServiceCenter(RetailStoreCityServiceCenterRequest.newInstance().selectSelf());
    }

    public PotentialCustomerRequest selectCityServiceCenter(RetailStoreCityServiceCenterRequest cityServiceCenter){
        selectParent(CITY_SERVICE_CENTER_PROPERTY, cityServiceCenter);
        return this;
    }
    

    public PotentialCustomerRequest unselectCityServiceCenter(){
        unselectParent(CITY_SERVICE_CENTER_PROPERTY);
        return this;
    }

  

    
    public PotentialCustomerRequest filterByCityPartner(CityPartnerRequest cityPartner){
        return filterByCityPartner(cityPartner, cityPartnerList -> cityPartnerList.stream().map(CityPartner::getId).collect(Collectors.toSet()));
    }

    public PotentialCustomerRequest filterByCityPartner(CityPartnerRequest cityPartner, IDRefine<CityPartner> idRefine) {
        return addSearchCriteria(createCityPartnerCriteria(cityPartner, idRefine));
    }

    public SearchCriteria createCityPartnerCriteria(CityPartnerRequest cityPartner, IDRefine<CityPartner> idRefine) {
        return new RefinedIdInCriteria(cityPartner, CITY_PARTNER_PROPERTY, idRefine);
    }
    

    
    public PotentialCustomerRequest selectCityPartner(){
        return selectCityPartner(CityPartnerRequest.newInstance().selectSelf());
    }

    public PotentialCustomerRequest selectCityPartner(CityPartnerRequest cityPartner){
        selectParent(CITY_PARTNER_PROPERTY, cityPartner);
        return this;
    }
    

    public PotentialCustomerRequest unselectCityPartner(){
        unselectParent(CITY_PARTNER_PROPERTY);
        return this;
    }

  


  

    public PotentialCustomerRequest hasPotentialCustomerContactPerson() {
      return hasPotentialCustomerContactPerson(PotentialCustomerContactPersonRequest.newInstance());
    }

    public PotentialCustomerRequest hasPotentialCustomerContactPerson(PotentialCustomerContactPersonRequest potentialCustomerContactPerson) {
        return hasPotentialCustomerContactPerson(potentialCustomerContactPerson, potentialCustomerContactPersonList -> potentialCustomerContactPersonList.stream().map(PotentialCustomerContactPerson::getPotentialCustomer).map(PotentialCustomer::getId).collect(Collectors.toSet()));
    }

    public PotentialCustomerRequest hasPotentialCustomerContactPerson(PotentialCustomerContactPersonRequest potentialCustomerContactPerson, IDRefine<PotentialCustomerContactPerson> idRefine) {
        potentialCustomerContactPerson.select(PotentialCustomerContactPerson.POTENTIAL_CUSTOMER_PROPERTY);
        return addSearchCriteria(createPotentialCustomerContactPersonCriteria(potentialCustomerContactPerson, idRefine));
    }

    public SearchCriteria createPotentialCustomerContactPersonCriteria(PotentialCustomerContactPersonRequest potentialCustomerContactPerson, IDRefine<PotentialCustomerContactPerson> idRefine){
       return new RefinedIdInCriteria(potentialCustomerContactPerson, ID_PROPERTY, idRefine);
    }

    public PotentialCustomerRequest selectPotentialCustomerContactPersonList(PotentialCustomerContactPersonRequest potentialCustomerContactPerson) {
        selectChild(PotentialCustomerContactPerson.POTENTIAL_CUSTOMER_PROPERTY, potentialCustomerContactPerson);
        return this;
    }

    public PotentialCustomerRequest selectPotentialCustomerContactPersonList() {
        return selectPotentialCustomerContactPersonList(PotentialCustomerContactPersonRequest.newInstance().selectAll());
    }

    public PotentialCustomerRequest unselectPotentialCustomerContactPersonList(){
        unselectChild(PotentialCustomerContactPerson.POTENTIAL_CUSTOMER_PROPERTY, PotentialCustomerContactPerson.class);
        return this;
    }
  

    public PotentialCustomerRequest hasPotentialCustomerContact() {
      return hasPotentialCustomerContact(PotentialCustomerContactRequest.newInstance());
    }

    public PotentialCustomerRequest hasPotentialCustomerContact(PotentialCustomerContactRequest potentialCustomerContact) {
        return hasPotentialCustomerContact(potentialCustomerContact, potentialCustomerContactList -> potentialCustomerContactList.stream().map(PotentialCustomerContact::getPotentialCustomer).map(PotentialCustomer::getId).collect(Collectors.toSet()));
    }

    public PotentialCustomerRequest hasPotentialCustomerContact(PotentialCustomerContactRequest potentialCustomerContact, IDRefine<PotentialCustomerContact> idRefine) {
        potentialCustomerContact.select(PotentialCustomerContact.POTENTIAL_CUSTOMER_PROPERTY);
        return addSearchCriteria(createPotentialCustomerContactCriteria(potentialCustomerContact, idRefine));
    }

    public SearchCriteria createPotentialCustomerContactCriteria(PotentialCustomerContactRequest potentialCustomerContact, IDRefine<PotentialCustomerContact> idRefine){
       return new RefinedIdInCriteria(potentialCustomerContact, ID_PROPERTY, idRefine);
    }

    public PotentialCustomerRequest selectPotentialCustomerContactList(PotentialCustomerContactRequest potentialCustomerContact) {
        selectChild(PotentialCustomerContact.POTENTIAL_CUSTOMER_PROPERTY, potentialCustomerContact);
        return this;
    }

    public PotentialCustomerRequest selectPotentialCustomerContactList() {
        return selectPotentialCustomerContactList(PotentialCustomerContactRequest.newInstance().selectAll());
    }

    public PotentialCustomerRequest unselectPotentialCustomerContactList(){
        unselectChild(PotentialCustomerContact.POTENTIAL_CUSTOMER_PROPERTY, PotentialCustomerContact.class);
        return this;
    }
  

    public PotentialCustomerRequest hasEventAttendance() {
      return hasEventAttendance(EventAttendanceRequest.newInstance());
    }

    public PotentialCustomerRequest hasEventAttendance(EventAttendanceRequest eventAttendance) {
        return hasEventAttendance(eventAttendance, eventAttendanceList -> eventAttendanceList.stream().map(EventAttendance::getPotentialCustomer).map(PotentialCustomer::getId).collect(Collectors.toSet()));
    }

    public PotentialCustomerRequest hasEventAttendance(EventAttendanceRequest eventAttendance, IDRefine<EventAttendance> idRefine) {
        eventAttendance.select(EventAttendance.POTENTIAL_CUSTOMER_PROPERTY);
        return addSearchCriteria(createEventAttendanceCriteria(eventAttendance, idRefine));
    }

    public SearchCriteria createEventAttendanceCriteria(EventAttendanceRequest eventAttendance, IDRefine<EventAttendance> idRefine){
       return new RefinedIdInCriteria(eventAttendance, ID_PROPERTY, idRefine);
    }

    public PotentialCustomerRequest selectEventAttendanceList(EventAttendanceRequest eventAttendance) {
        selectChild(EventAttendance.POTENTIAL_CUSTOMER_PROPERTY, eventAttendance);
        return this;
    }

    public PotentialCustomerRequest selectEventAttendanceList() {
        return selectEventAttendanceList(EventAttendanceRequest.newInstance().selectAll());
    }

    public PotentialCustomerRequest unselectEventAttendanceList(){
        unselectChild(EventAttendance.POTENTIAL_CUSTOMER_PROPERTY, EventAttendance.class);
        return this;
    }
  

   public PotentialCustomerRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

