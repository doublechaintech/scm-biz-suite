package com.doublechaintech.retailscm.userallowlist;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.userdomain.UserDomain;
import com.doublechaintech.retailscm.userdomain.UserDomainRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.userallowlist.UserAllowList.*;

public class UserAllowListRequest extends BaseRequest<UserAllowList> {
    public static UserAllowListRequest newInstance() {
        return new UserAllowListRequest().selectId();
    }

    public String getInternalType() {
        return "UserAllowList";
    }

    public UserAllowListRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public UserAllowListRequest select(String... names) {
        super.select(names);
        return this;
    }

    public UserAllowListRequest selectAll() {return this.selectId().selectUserIdentity().selectUserSpecialFunctions().selectDomain().selectVersion();
    }

    public UserAllowListRequest selectSelf() {return this.selectId().selectUserIdentity().selectUserSpecialFunctions().selectVersion();
    }

    public UserAllowListRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public UserAllowListRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static UserAllowListRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public UserAllowListRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public UserAllowListRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public UserAllowListRequest selectId(){
          return select(ID_PROPERTY);
      }

      public UserAllowListRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public UserAllowListRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public UserAllowListRequest filterByUserIdentity(String userIdentity) {
          
          if (userIdentity == null) {
              return this;
          }
          
          return filterByUserIdentity(QueryOperator.EQUAL, userIdentity);
      }
    

      public UserAllowListRequest filterByUserIdentity(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getUserIdentitySearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public UserAllowListRequest selectUserIdentity(){
          return select(USER_IDENTITY_PROPERTY);
      }

      public UserAllowListRequest unselectUserIdentity(){
          return unselect(USER_IDENTITY_PROPERTY);
      }

      public SearchCriteria getUserIdentitySearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(USER_IDENTITY_PROPERTY, pQueryOperator, parameters);
      }

      public UserAllowListRequest orderByUserIdentity(boolean asc){
          addOrderBy(USER_IDENTITY_PROPERTY, asc);
          return this;
      }
   
      public UserAllowListRequest filterByUserSpecialFunctions(String userSpecialFunctions) {
          
          if (userSpecialFunctions == null) {
              return this;
          }
          
          return filterByUserSpecialFunctions(QueryOperator.EQUAL, userSpecialFunctions);
      }
    

      public UserAllowListRequest filterByUserSpecialFunctions(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getUserSpecialFunctionsSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public UserAllowListRequest selectUserSpecialFunctions(){
          return select(USER_SPECIAL_FUNCTIONS_PROPERTY);
      }

      public UserAllowListRequest unselectUserSpecialFunctions(){
          return unselect(USER_SPECIAL_FUNCTIONS_PROPERTY);
      }

      public SearchCriteria getUserSpecialFunctionsSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(USER_SPECIAL_FUNCTIONS_PROPERTY, pQueryOperator, parameters);
      }

      public UserAllowListRequest orderByUserSpecialFunctions(boolean asc){
          addOrderBy(USER_SPECIAL_FUNCTIONS_PROPERTY, asc);
          return this;
      }
   
      public UserAllowListRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public UserAllowListRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public UserAllowListRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public UserAllowListRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public UserAllowListRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public UserAllowListRequest filterByDomain(UserDomainRequest domain){
        return filterByDomain(domain, domainList -> domainList.stream().map(UserDomain::getId).collect(Collectors.toSet()));
    }

    public UserAllowListRequest filterByDomain(UserDomainRequest domain, IDRefine<UserDomain> idRefine) {
        return addSearchCriteria(createDomainCriteria(domain, idRefine));
    }

    public SearchCriteria createDomainCriteria(UserDomainRequest domain, IDRefine<UserDomain> idRefine) {
        return new RefinedIdInCriteria(domain, DOMAIN_PROPERTY, idRefine);
    }
    

    
    public UserAllowListRequest selectDomain(){
        return selectDomain(UserDomainRequest.newInstance().selectSelf());
    }

    public UserAllowListRequest selectDomain(UserDomainRequest domain){
        selectParent(DOMAIN_PROPERTY, domain);
        return this;
    }
    

    public UserAllowListRequest unselectDomain(){
        unselectParent(DOMAIN_PROPERTY);
        return this;
    }

  


  

   public UserAllowListRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

