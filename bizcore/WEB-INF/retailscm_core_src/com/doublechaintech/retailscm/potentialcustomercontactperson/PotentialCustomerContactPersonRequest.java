package com.doublechaintech.retailscm.potentialcustomercontactperson;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;
import com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContact;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomerRequest;
import com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContactRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.potentialcustomercontactperson.PotentialCustomerContactPerson.*;

public class PotentialCustomerContactPersonRequest extends BaseRequest<PotentialCustomerContactPerson> {
    public static PotentialCustomerContactPersonRequest newInstance() {
        return new PotentialCustomerContactPersonRequest().selectId();
    }

    public String getInternalType() {
        return "PotentialCustomerContactPerson";
    }

    public PotentialCustomerContactPersonRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public PotentialCustomerContactPersonRequest select(String... names) {
        super.select(names);
        return this;
    }

    public PotentialCustomerContactPersonRequest selectAll() {return this.selectId().selectName().selectMobile().selectPotentialCustomer().selectDescription().selectVersion();
    }

    public PotentialCustomerContactPersonRequest selectSelf() {return this.selectId().selectName().selectMobile().selectDescription().selectVersion();
    }

    public PotentialCustomerContactPersonRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public PotentialCustomerContactPersonRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static PotentialCustomerContactPersonRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public PotentialCustomerContactPersonRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public PotentialCustomerContactPersonRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public PotentialCustomerContactPersonRequest selectId(){
          return select(ID_PROPERTY);
      }

      public PotentialCustomerContactPersonRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public PotentialCustomerContactPersonRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public PotentialCustomerContactPersonRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public PotentialCustomerContactPersonRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public PotentialCustomerContactPersonRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public PotentialCustomerContactPersonRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public PotentialCustomerContactPersonRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public PotentialCustomerContactPersonRequest filterByMobile(String mobile) {
          
          if (mobile == null) {
              return this;
          }
          
          return filterByMobile(QueryOperator.EQUAL, mobile);
      }
    

      public PotentialCustomerContactPersonRequest filterByMobile(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getMobileSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public PotentialCustomerContactPersonRequest selectMobile(){
          return select(MOBILE_PROPERTY);
      }

      public PotentialCustomerContactPersonRequest unselectMobile(){
          return unselect(MOBILE_PROPERTY);
      }

      public SearchCriteria getMobileSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(MOBILE_PROPERTY, pQueryOperator, parameters);
      }

      public PotentialCustomerContactPersonRequest orderByMobile(boolean asc){
          addOrderBy(MOBILE_PROPERTY, asc);
          return this;
      }
   
      public PotentialCustomerContactPersonRequest filterByDescription(String description) {
          
          if (description == null) {
              return this;
          }
          
          return filterByDescription(QueryOperator.EQUAL, description);
      }
    

      public PotentialCustomerContactPersonRequest filterByDescription(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public PotentialCustomerContactPersonRequest selectDescription(){
          return select(DESCRIPTION_PROPERTY);
      }

      public PotentialCustomerContactPersonRequest unselectDescription(){
          return unselect(DESCRIPTION_PROPERTY);
      }

      public SearchCriteria getDescriptionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
      }

      public PotentialCustomerContactPersonRequest orderByDescription(boolean asc){
          addOrderBy(DESCRIPTION_PROPERTY, asc);
          return this;
      }
   
      public PotentialCustomerContactPersonRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public PotentialCustomerContactPersonRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public PotentialCustomerContactPersonRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public PotentialCustomerContactPersonRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public PotentialCustomerContactPersonRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public PotentialCustomerContactPersonRequest filterByPotentialCustomer(PotentialCustomerRequest potentialCustomer){
        return filterByPotentialCustomer(potentialCustomer, potentialCustomerList -> potentialCustomerList.stream().map(PotentialCustomer::getId).collect(Collectors.toSet()));
    }

    public PotentialCustomerContactPersonRequest filterByPotentialCustomer(PotentialCustomerRequest potentialCustomer, IDRefine<PotentialCustomer> idRefine) {
        return addSearchCriteria(createPotentialCustomerCriteria(potentialCustomer, idRefine));
    }

    public SearchCriteria createPotentialCustomerCriteria(PotentialCustomerRequest potentialCustomer, IDRefine<PotentialCustomer> idRefine) {
        return new RefinedIdInCriteria(potentialCustomer, POTENTIAL_CUSTOMER_PROPERTY, idRefine);
    }
    

    
    public PotentialCustomerContactPersonRequest selectPotentialCustomer(){
        return selectPotentialCustomer(PotentialCustomerRequest.newInstance().selectSelf());
    }

    public PotentialCustomerContactPersonRequest selectPotentialCustomer(PotentialCustomerRequest potentialCustomer){
        selectParent(POTENTIAL_CUSTOMER_PROPERTY, potentialCustomer);
        return this;
    }
    

    public PotentialCustomerContactPersonRequest unselectPotentialCustomer(){
        unselectParent(POTENTIAL_CUSTOMER_PROPERTY);
        return this;
    }

  


  

    public PotentialCustomerContactPersonRequest hasPotentialCustomerContact() {
      return hasPotentialCustomerContact(PotentialCustomerContactRequest.newInstance());
    }

    public PotentialCustomerContactPersonRequest hasPotentialCustomerContact(PotentialCustomerContactRequest potentialCustomerContact) {
        return hasPotentialCustomerContact(potentialCustomerContact, potentialCustomerContactList -> potentialCustomerContactList.stream().map(PotentialCustomerContact::getContactTo).map(PotentialCustomerContactPerson::getId).collect(Collectors.toSet()));
    }

    public PotentialCustomerContactPersonRequest hasPotentialCustomerContact(PotentialCustomerContactRequest potentialCustomerContact, IDRefine<PotentialCustomerContact> idRefine) {
        potentialCustomerContact.select(PotentialCustomerContact.CONTACT_TO_PROPERTY);
        return addSearchCriteria(createPotentialCustomerContactCriteria(potentialCustomerContact, idRefine));
    }

    public SearchCriteria createPotentialCustomerContactCriteria(PotentialCustomerContactRequest potentialCustomerContact, IDRefine<PotentialCustomerContact> idRefine){
       return new RefinedIdInCriteria(potentialCustomerContact, ID_PROPERTY, idRefine);
    }

    public PotentialCustomerContactPersonRequest selectPotentialCustomerContactList(PotentialCustomerContactRequest potentialCustomerContact) {
        selectChild(PotentialCustomerContact.CONTACT_TO_PROPERTY, potentialCustomerContact);
        return this;
    }

    public PotentialCustomerContactPersonRequest selectPotentialCustomerContactList() {
        return selectPotentialCustomerContactList(PotentialCustomerContactRequest.newInstance().selectAll());
    }

    public PotentialCustomerContactPersonRequest unselectPotentialCustomerContactList(){
        unselectChild(PotentialCustomerContact.CONTACT_TO_PROPERTY, PotentialCustomerContact.class);
        return this;
    }
  

   public PotentialCustomerContactPersonRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

