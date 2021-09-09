package com.doublechaintech.retailscm.memberrewardpoint;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.memberrewardpoint.MemberRewardPoint.*;

public class MemberRewardPointRequest extends BaseRequest<MemberRewardPoint> {
    public static MemberRewardPointRequest newInstance() {
        return new MemberRewardPointRequest().selectId();
    }

    public String getInternalType() {
        return "MemberRewardPoint";
    }

    public MemberRewardPointRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public MemberRewardPointRequest select(String... names) {
        super.select(names);
        return this;
    }

    public MemberRewardPointRequest selectAll() {return this.selectId().selectName().selectPoint().selectOwner().selectVersion();
    }

    public MemberRewardPointRequest selectSelf() {return this.selectId().selectName().selectPoint().selectVersion();
    }

    public MemberRewardPointRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public MemberRewardPointRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static MemberRewardPointRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public MemberRewardPointRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public MemberRewardPointRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public MemberRewardPointRequest selectId(){
          return select(ID_PROPERTY);
      }

      public MemberRewardPointRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public MemberRewardPointRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public MemberRewardPointRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public MemberRewardPointRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public MemberRewardPointRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public MemberRewardPointRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public MemberRewardPointRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public MemberRewardPointRequest filterByPoint(int point) {
          
          return filterByPoint(QueryOperator.EQUAL, point);
      }
    

      public MemberRewardPointRequest filterByPoint(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getPointSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public MemberRewardPointRequest selectPoint(){
          return select(POINT_PROPERTY);
      }

      public MemberRewardPointRequest unselectPoint(){
          return unselect(POINT_PROPERTY);
      }

      public SearchCriteria getPointSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(POINT_PROPERTY, pQueryOperator, parameters);
      }

      public MemberRewardPointRequest orderByPoint(boolean asc){
          addOrderBy(POINT_PROPERTY, asc);
          return this;
      }
   
      public MemberRewardPointRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public MemberRewardPointRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public MemberRewardPointRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public MemberRewardPointRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public MemberRewardPointRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public MemberRewardPointRequest filterByOwner(RetailStoreMemberRequest owner){
        return filterByOwner(owner, ownerList -> ownerList.stream().map(RetailStoreMember::getId).collect(Collectors.toSet()));
    }

    public MemberRewardPointRequest filterByOwner(RetailStoreMemberRequest owner, IDRefine<RetailStoreMember> idRefine) {
        return addSearchCriteria(createOwnerCriteria(owner, idRefine));
    }

    public SearchCriteria createOwnerCriteria(RetailStoreMemberRequest owner, IDRefine<RetailStoreMember> idRefine) {
        return new RefinedIdInCriteria(owner, OWNER_PROPERTY, idRefine);
    }
    

    
    public MemberRewardPointRequest selectOwner(){
        return selectOwner(RetailStoreMemberRequest.newInstance().selectSelf());
    }

    public MemberRewardPointRequest selectOwner(RetailStoreMemberRequest owner){
        selectParent(OWNER_PROPERTY, owner);
        return this;
    }
    

    public MemberRewardPointRequest unselectOwner(){
        unselectParent(OWNER_PROPERTY);
        return this;
    }

  


  

   public MemberRewardPointRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

