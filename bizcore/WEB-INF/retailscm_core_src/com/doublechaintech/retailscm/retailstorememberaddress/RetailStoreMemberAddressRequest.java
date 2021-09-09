package com.doublechaintech.retailscm.retailstorememberaddress;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.retailstorememberaddress.RetailStoreMemberAddress.*;

public class RetailStoreMemberAddressRequest extends BaseRequest<RetailStoreMemberAddress> {
    public static RetailStoreMemberAddressRequest newInstance() {
        return new RetailStoreMemberAddressRequest().selectId();
    }

    public String getInternalType() {
        return "RetailStoreMemberAddress";
    }

    public RetailStoreMemberAddressRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public RetailStoreMemberAddressRequest select(String... names) {
        super.select(names);
        return this;
    }

    public RetailStoreMemberAddressRequest selectAll() {return this.selectId().selectName().selectOwner().selectMobilePhone().selectAddress().selectVersion();
    }

    public RetailStoreMemberAddressRequest selectSelf() {return this.selectId().selectName().selectMobilePhone().selectAddress().selectVersion();
    }

    public RetailStoreMemberAddressRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public RetailStoreMemberAddressRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static RetailStoreMemberAddressRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public RetailStoreMemberAddressRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public RetailStoreMemberAddressRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreMemberAddressRequest selectId(){
          return select(ID_PROPERTY);
      }

      public RetailStoreMemberAddressRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreMemberAddressRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreMemberAddressRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public RetailStoreMemberAddressRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreMemberAddressRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public RetailStoreMemberAddressRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreMemberAddressRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreMemberAddressRequest filterByMobilePhone(String mobilePhone) {
          
          if (mobilePhone == null) {
              return this;
          }
          
          return filterByMobilePhone(QueryOperator.EQUAL, mobilePhone);
      }
    

      public RetailStoreMemberAddressRequest filterByMobilePhone(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getMobilePhoneSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreMemberAddressRequest selectMobilePhone(){
          return select(MOBILE_PHONE_PROPERTY);
      }

      public RetailStoreMemberAddressRequest unselectMobilePhone(){
          return unselect(MOBILE_PHONE_PROPERTY);
      }

      public SearchCriteria getMobilePhoneSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(MOBILE_PHONE_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreMemberAddressRequest orderByMobilePhone(boolean asc){
          addOrderBy(MOBILE_PHONE_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreMemberAddressRequest filterByAddress(String address) {
          
          if (address == null) {
              return this;
          }
          
          return filterByAddress(QueryOperator.EQUAL, address);
      }
    

      public RetailStoreMemberAddressRequest filterByAddress(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getAddressSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreMemberAddressRequest selectAddress(){
          return select(ADDRESS_PROPERTY);
      }

      public RetailStoreMemberAddressRequest unselectAddress(){
          return unselect(ADDRESS_PROPERTY);
      }

      public SearchCriteria getAddressSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ADDRESS_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreMemberAddressRequest orderByAddress(boolean asc){
          addOrderBy(ADDRESS_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreMemberAddressRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public RetailStoreMemberAddressRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreMemberAddressRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public RetailStoreMemberAddressRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreMemberAddressRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public RetailStoreMemberAddressRequest filterByOwner(RetailStoreMemberRequest owner){
        return filterByOwner(owner, ownerList -> ownerList.stream().map(RetailStoreMember::getId).collect(Collectors.toSet()));
    }

    public RetailStoreMemberAddressRequest filterByOwner(RetailStoreMemberRequest owner, IDRefine<RetailStoreMember> idRefine) {
        return addSearchCriteria(createOwnerCriteria(owner, idRefine));
    }

    public SearchCriteria createOwnerCriteria(RetailStoreMemberRequest owner, IDRefine<RetailStoreMember> idRefine) {
        return new RefinedIdInCriteria(owner, OWNER_PROPERTY, idRefine);
    }
    

    
    public RetailStoreMemberAddressRequest selectOwner(){
        return selectOwner(RetailStoreMemberRequest.newInstance().selectSelf());
    }

    public RetailStoreMemberAddressRequest selectOwner(RetailStoreMemberRequest owner){
        selectParent(OWNER_PROPERTY, owner);
        return this;
    }
    

    public RetailStoreMemberAddressRequest unselectOwner(){
        unselectParent(OWNER_PROPERTY);
        return this;
    }

  


  

   public RetailStoreMemberAddressRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

