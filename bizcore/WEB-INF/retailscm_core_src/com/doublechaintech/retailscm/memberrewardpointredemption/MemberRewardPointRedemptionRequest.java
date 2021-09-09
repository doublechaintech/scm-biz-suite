package com.doublechaintech.retailscm.memberrewardpointredemption;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.memberrewardpointredemption.MemberRewardPointRedemption.*;

public class MemberRewardPointRedemptionRequest extends BaseRequest<MemberRewardPointRedemption> {
    public static MemberRewardPointRedemptionRequest newInstance() {
        return new MemberRewardPointRedemptionRequest().selectId();
    }

    public String getInternalType() {
        return "MemberRewardPointRedemption";
    }

    public MemberRewardPointRedemptionRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public MemberRewardPointRedemptionRequest select(String... names) {
        super.select(names);
        return this;
    }

    public MemberRewardPointRedemptionRequest selectAll() {return this.selectId().selectName().selectPoint().selectOwner().selectVersion();
    }

    public MemberRewardPointRedemptionRequest selectSelf() {return this.selectId().selectName().selectPoint().selectVersion();
    }

    public MemberRewardPointRedemptionRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public MemberRewardPointRedemptionRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static MemberRewardPointRedemptionRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public MemberRewardPointRedemptionRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public MemberRewardPointRedemptionRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public MemberRewardPointRedemptionRequest selectId(){
          return select(ID_PROPERTY);
      }

      public MemberRewardPointRedemptionRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public MemberRewardPointRedemptionRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public MemberRewardPointRedemptionRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public MemberRewardPointRedemptionRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public MemberRewardPointRedemptionRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public MemberRewardPointRedemptionRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public MemberRewardPointRedemptionRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public MemberRewardPointRedemptionRequest filterByPoint(int point) {
          
          return filterByPoint(QueryOperator.EQUAL, point);
      }
    

      public MemberRewardPointRedemptionRequest filterByPoint(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getPointSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public MemberRewardPointRedemptionRequest selectPoint(){
          return select(POINT_PROPERTY);
      }

      public MemberRewardPointRedemptionRequest unselectPoint(){
          return unselect(POINT_PROPERTY);
      }

      public SearchCriteria getPointSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(POINT_PROPERTY, pQueryOperator, parameters);
      }

      public MemberRewardPointRedemptionRequest orderByPoint(boolean asc){
          addOrderBy(POINT_PROPERTY, asc);
          return this;
      }
   
      public MemberRewardPointRedemptionRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public MemberRewardPointRedemptionRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public MemberRewardPointRedemptionRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public MemberRewardPointRedemptionRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public MemberRewardPointRedemptionRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public MemberRewardPointRedemptionRequest filterByOwner(RetailStoreMemberRequest owner){
        return filterByOwner(owner, ownerList -> ownerList.stream().map(RetailStoreMember::getId).collect(Collectors.toSet()));
    }

    public MemberRewardPointRedemptionRequest filterByOwner(RetailStoreMemberRequest owner, IDRefine<RetailStoreMember> idRefine) {
        return addSearchCriteria(createOwnerCriteria(owner, idRefine));
    }

    public SearchCriteria createOwnerCriteria(RetailStoreMemberRequest owner, IDRefine<RetailStoreMember> idRefine) {
        return new RefinedIdInCriteria(owner, OWNER_PROPERTY, idRefine);
    }
    

    
    public MemberRewardPointRedemptionRequest selectOwner(){
        return selectOwner(RetailStoreMemberRequest.newInstance().selectSelf());
    }

    public MemberRewardPointRedemptionRequest selectOwner(RetailStoreMemberRequest owner){
        selectParent(OWNER_PROPERTY, owner);
        return this;
    }
    

    public MemberRewardPointRedemptionRequest unselectOwner(){
        unselectParent(OWNER_PROPERTY);
        return this;
    }

  


  

   public MemberRewardPointRedemptionRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

