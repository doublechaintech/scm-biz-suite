package com.doublechaintech.retailscm.potentialcustomercontact;

import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import java.util.Date;
import com.doublechaintech.retailscm.citypartner.CityPartner;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;
import com.doublechaintech.retailscm.potentialcustomercontactperson.PotentialCustomerContactPerson;
import com.doublechaintech.retailscm.citypartner.CityPartnerRequest;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomerRequest;
import com.doublechaintech.retailscm.potentialcustomercontactperson.PotentialCustomerContactPersonRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContact.*;

public class PotentialCustomerContactRequest extends BaseRequest<PotentialCustomerContact> {
    public static PotentialCustomerContactRequest newInstance() {
        return new PotentialCustomerContactRequest().selectId();
    }

    public String getInternalType() {
        return "PotentialCustomerContact";
    }

    public PotentialCustomerContactRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public PotentialCustomerContactRequest select(String... names) {
        super.select(names);
        return this;
    }

    public PotentialCustomerContactRequest selectAll() {return this.selectId().selectName().selectContactDate().selectContactMethod().selectPotentialCustomer().selectCityPartner().selectContactTo().selectDescription().selectLastUpdateTime().selectVersion();
    }

    public PotentialCustomerContactRequest selectSelf() {return this.selectId().selectName().selectContactDate().selectContactMethod().selectDescription().selectLastUpdateTime().selectVersion();
    }

    public PotentialCustomerContactRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public PotentialCustomerContactRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static PotentialCustomerContactRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public PotentialCustomerContactRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public PotentialCustomerContactRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public PotentialCustomerContactRequest selectId(){
          return select(ID_PROPERTY);
      }

      public PotentialCustomerContactRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public PotentialCustomerContactRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public PotentialCustomerContactRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public PotentialCustomerContactRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public PotentialCustomerContactRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public PotentialCustomerContactRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public PotentialCustomerContactRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public PotentialCustomerContactRequest filterByContactDate(Date contactDate) {
          
          if (contactDate == null) {
              return this;
          }
          
          return filterByContactDate(QueryOperator.EQUAL, contactDate);
      }
    

      public PotentialCustomerContactRequest filterByContactDate(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getContactDateSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public PotentialCustomerContactRequest selectContactDate(){
          return select(CONTACT_DATE_PROPERTY);
      }

      public PotentialCustomerContactRequest unselectContactDate(){
          return unselect(CONTACT_DATE_PROPERTY);
      }

      public SearchCriteria getContactDateSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(CONTACT_DATE_PROPERTY, pQueryOperator, parameters);
      }

      public PotentialCustomerContactRequest orderByContactDate(boolean asc){
          addOrderBy(CONTACT_DATE_PROPERTY, asc);
          return this;
      }
   
      public PotentialCustomerContactRequest filterByContactMethod(String contactMethod) {
          
          if (contactMethod == null) {
              return this;
          }
          
          return filterByContactMethod(QueryOperator.EQUAL, contactMethod);
      }
    

      public PotentialCustomerContactRequest filterByContactMethod(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getContactMethodSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public PotentialCustomerContactRequest selectContactMethod(){
          return select(CONTACT_METHOD_PROPERTY);
      }

      public PotentialCustomerContactRequest unselectContactMethod(){
          return unselect(CONTACT_METHOD_PROPERTY);
      }

      public SearchCriteria getContactMethodSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(CONTACT_METHOD_PROPERTY, pQueryOperator, parameters);
      }

      public PotentialCustomerContactRequest orderByContactMethod(boolean asc){
          addOrderBy(CONTACT_METHOD_PROPERTY, asc);
          return this;
      }
   
      public PotentialCustomerContactRequest filterByDescription(String description) {
          
          if (description == null) {
              return this;
          }
          
          return filterByDescription(QueryOperator.EQUAL, description);
      }
    

      public PotentialCustomerContactRequest filterByDescription(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public PotentialCustomerContactRequest selectDescription(){
          return select(DESCRIPTION_PROPERTY);
      }

      public PotentialCustomerContactRequest unselectDescription(){
          return unselect(DESCRIPTION_PROPERTY);
      }

      public SearchCriteria getDescriptionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
      }

      public PotentialCustomerContactRequest orderByDescription(boolean asc){
          addOrderBy(DESCRIPTION_PROPERTY, asc);
          return this;
      }
   
      public PotentialCustomerContactRequest filterByLastUpdateTime(DateTime lastUpdateTime) {
          
          if (lastUpdateTime == null) {
              return this;
          }
          
          return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
      }
    

      public PotentialCustomerContactRequest filterByLastUpdateTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public PotentialCustomerContactRequest selectLastUpdateTime(){
          return select(LAST_UPDATE_TIME_PROPERTY);
      }

      public PotentialCustomerContactRequest unselectLastUpdateTime(){
          return unselect(LAST_UPDATE_TIME_PROPERTY);
      }

      public SearchCriteria getLastUpdateTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public PotentialCustomerContactRequest orderByLastUpdateTime(boolean asc){
          addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
          return this;
      }
   
      public PotentialCustomerContactRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public PotentialCustomerContactRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public PotentialCustomerContactRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public PotentialCustomerContactRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public PotentialCustomerContactRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public PotentialCustomerContactRequest filterByPotentialCustomer(PotentialCustomerRequest potentialCustomer){
        return filterByPotentialCustomer(potentialCustomer, potentialCustomerList -> potentialCustomerList.stream().map(PotentialCustomer::getId).collect(Collectors.toSet()));
    }

    public PotentialCustomerContactRequest filterByPotentialCustomer(PotentialCustomerRequest potentialCustomer, IDRefine<PotentialCustomer> idRefine) {
        return addSearchCriteria(createPotentialCustomerCriteria(potentialCustomer, idRefine));
    }

    public SearchCriteria createPotentialCustomerCriteria(PotentialCustomerRequest potentialCustomer, IDRefine<PotentialCustomer> idRefine) {
        return new RefinedIdInCriteria(potentialCustomer, POTENTIAL_CUSTOMER_PROPERTY, idRefine);
    }
    

    
    public PotentialCustomerContactRequest selectPotentialCustomer(){
        return selectPotentialCustomer(PotentialCustomerRequest.newInstance().selectSelf());
    }

    public PotentialCustomerContactRequest selectPotentialCustomer(PotentialCustomerRequest potentialCustomer){
        selectParent(POTENTIAL_CUSTOMER_PROPERTY, potentialCustomer);
        return this;
    }
    

    public PotentialCustomerContactRequest unselectPotentialCustomer(){
        unselectParent(POTENTIAL_CUSTOMER_PROPERTY);
        return this;
    }

  

    
    public PotentialCustomerContactRequest filterByCityPartner(CityPartnerRequest cityPartner){
        return filterByCityPartner(cityPartner, cityPartnerList -> cityPartnerList.stream().map(CityPartner::getId).collect(Collectors.toSet()));
    }

    public PotentialCustomerContactRequest filterByCityPartner(CityPartnerRequest cityPartner, IDRefine<CityPartner> idRefine) {
        return addSearchCriteria(createCityPartnerCriteria(cityPartner, idRefine));
    }

    public SearchCriteria createCityPartnerCriteria(CityPartnerRequest cityPartner, IDRefine<CityPartner> idRefine) {
        return new RefinedIdInCriteria(cityPartner, CITY_PARTNER_PROPERTY, idRefine);
    }
    

    
    public PotentialCustomerContactRequest selectCityPartner(){
        return selectCityPartner(CityPartnerRequest.newInstance().selectSelf());
    }

    public PotentialCustomerContactRequest selectCityPartner(CityPartnerRequest cityPartner){
        selectParent(CITY_PARTNER_PROPERTY, cityPartner);
        return this;
    }
    

    public PotentialCustomerContactRequest unselectCityPartner(){
        unselectParent(CITY_PARTNER_PROPERTY);
        return this;
    }

  

    
    public PotentialCustomerContactRequest filterByContactTo(PotentialCustomerContactPersonRequest contactTo){
        return filterByContactTo(contactTo, contactToList -> contactToList.stream().map(PotentialCustomerContactPerson::getId).collect(Collectors.toSet()));
    }

    public PotentialCustomerContactRequest filterByContactTo(PotentialCustomerContactPersonRequest contactTo, IDRefine<PotentialCustomerContactPerson> idRefine) {
        return addSearchCriteria(createContactToCriteria(contactTo, idRefine));
    }

    public SearchCriteria createContactToCriteria(PotentialCustomerContactPersonRequest contactTo, IDRefine<PotentialCustomerContactPerson> idRefine) {
        return new RefinedIdInCriteria(contactTo, CONTACT_TO_PROPERTY, idRefine);
    }
    

    
    public PotentialCustomerContactRequest selectContactTo(){
        return selectContactTo(PotentialCustomerContactPersonRequest.newInstance().selectSelf());
    }

    public PotentialCustomerContactRequest selectContactTo(PotentialCustomerContactPersonRequest contactTo){
        selectParent(CONTACT_TO_PROPERTY, contactTo);
        return this;
    }
    

    public PotentialCustomerContactRequest unselectContactTo(){
        unselectParent(CONTACT_TO_PROPERTY);
        return this;
    }

  


  

   public PotentialCustomerContactRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

