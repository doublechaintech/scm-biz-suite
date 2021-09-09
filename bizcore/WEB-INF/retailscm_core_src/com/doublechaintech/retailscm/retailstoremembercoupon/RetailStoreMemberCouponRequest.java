package com.doublechaintech.retailscm.retailstoremembercoupon;

import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.retailstoremembercoupon.RetailStoreMemberCoupon.*;

public class RetailStoreMemberCouponRequest extends BaseRequest<RetailStoreMemberCoupon> {
    public static RetailStoreMemberCouponRequest newInstance() {
        return new RetailStoreMemberCouponRequest().selectId();
    }

    public String getInternalType() {
        return "RetailStoreMemberCoupon";
    }

    public RetailStoreMemberCouponRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public RetailStoreMemberCouponRequest select(String... names) {
        super.select(names);
        return this;
    }

    public RetailStoreMemberCouponRequest selectAll() {return this.selectId().selectName().selectOwner().selectNumber().selectLastUpdateTime().selectVersion();
    }

    public RetailStoreMemberCouponRequest selectSelf() {return this.selectId().selectName().selectNumber().selectLastUpdateTime().selectVersion();
    }

    public RetailStoreMemberCouponRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public RetailStoreMemberCouponRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static RetailStoreMemberCouponRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public RetailStoreMemberCouponRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public RetailStoreMemberCouponRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreMemberCouponRequest selectId(){
          return select(ID_PROPERTY);
      }

      public RetailStoreMemberCouponRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreMemberCouponRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreMemberCouponRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public RetailStoreMemberCouponRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreMemberCouponRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public RetailStoreMemberCouponRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreMemberCouponRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreMemberCouponRequest filterByNumber(String number) {
          
          if (number == null) {
              return this;
          }
          
          return filterByNumber(QueryOperator.EQUAL, number);
      }
    

      public RetailStoreMemberCouponRequest filterByNumber(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNumberSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreMemberCouponRequest selectNumber(){
          return select(NUMBER_PROPERTY);
      }

      public RetailStoreMemberCouponRequest unselectNumber(){
          return unselect(NUMBER_PROPERTY);
      }

      public SearchCriteria getNumberSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NUMBER_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreMemberCouponRequest orderByNumber(boolean asc){
          addOrderBy(NUMBER_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreMemberCouponRequest filterByLastUpdateTime(DateTime lastUpdateTime) {
          
          if (lastUpdateTime == null) {
              return this;
          }
          
          return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
      }
    

      public RetailStoreMemberCouponRequest filterByLastUpdateTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreMemberCouponRequest selectLastUpdateTime(){
          return select(LAST_UPDATE_TIME_PROPERTY);
      }

      public RetailStoreMemberCouponRequest unselectLastUpdateTime(){
          return unselect(LAST_UPDATE_TIME_PROPERTY);
      }

      public SearchCriteria getLastUpdateTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreMemberCouponRequest orderByLastUpdateTime(boolean asc){
          addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreMemberCouponRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public RetailStoreMemberCouponRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreMemberCouponRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public RetailStoreMemberCouponRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreMemberCouponRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public RetailStoreMemberCouponRequest filterByOwner(RetailStoreMemberRequest owner){
        return filterByOwner(owner, ownerList -> ownerList.stream().map(RetailStoreMember::getId).collect(Collectors.toSet()));
    }

    public RetailStoreMemberCouponRequest filterByOwner(RetailStoreMemberRequest owner, IDRefine<RetailStoreMember> idRefine) {
        return addSearchCriteria(createOwnerCriteria(owner, idRefine));
    }

    public SearchCriteria createOwnerCriteria(RetailStoreMemberRequest owner, IDRefine<RetailStoreMember> idRefine) {
        return new RefinedIdInCriteria(owner, OWNER_PROPERTY, idRefine);
    }
    

    
    public RetailStoreMemberCouponRequest selectOwner(){
        return selectOwner(RetailStoreMemberRequest.newInstance().selectSelf());
    }

    public RetailStoreMemberCouponRequest selectOwner(RetailStoreMemberRequest owner){
        selectParent(OWNER_PROPERTY, owner);
        return this;
    }
    

    public RetailStoreMemberCouponRequest unselectOwner(){
        unselectParent(OWNER_PROPERTY);
        return this;
    }

  


  

   public RetailStoreMemberCouponRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

