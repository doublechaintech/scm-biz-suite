package com.doublechaintech.retailscm.userdomain;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.publickeytype.PublicKeyType;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.userallowlist.UserAllowList;
import com.doublechaintech.retailscm.publickeytype.PublicKeyTypeRequest;
import com.doublechaintech.retailscm.secuser.SecUserRequest;
import com.doublechaintech.retailscm.userallowlist.UserAllowListRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.userdomain.UserDomain.*;

public class UserDomainRequest extends BaseRequest<UserDomain> {
    public static UserDomainRequest newInstance() {
        return new UserDomainRequest().selectId();
    }

    public String getInternalType() {
        return "UserDomain";
    }

    public UserDomainRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public UserDomainRequest select(String... names) {
        super.select(names);
        return this;
    }

    public UserDomainRequest selectAll() {return this.selectId().selectName().selectVersion();
    }

    public UserDomainRequest selectSelf() {return this.selectId().selectName().selectVersion();
    }

    public UserDomainRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public UserDomainRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static UserDomainRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public UserDomainRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public UserDomainRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public UserDomainRequest selectId(){
          return select(ID_PROPERTY);
      }

      public UserDomainRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public UserDomainRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public UserDomainRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public UserDomainRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public UserDomainRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public UserDomainRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public UserDomainRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public UserDomainRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public UserDomainRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public UserDomainRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public UserDomainRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public UserDomainRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  


  

    public UserDomainRequest hasUserAllowList() {
      return hasUserAllowList(UserAllowListRequest.newInstance());
    }

    public UserDomainRequest hasUserAllowList(UserAllowListRequest userAllowList) {
        return hasUserAllowList(userAllowList, userAllowListList -> userAllowListList.stream().map(UserAllowList::getDomain).map(UserDomain::getId).collect(Collectors.toSet()));
    }

    public UserDomainRequest hasUserAllowList(UserAllowListRequest userAllowList, IDRefine<UserAllowList> idRefine) {
        userAllowList.select(UserAllowList.DOMAIN_PROPERTY);
        return addSearchCriteria(createUserAllowListCriteria(userAllowList, idRefine));
    }

    public SearchCriteria createUserAllowListCriteria(UserAllowListRequest userAllowList, IDRefine<UserAllowList> idRefine){
       return new RefinedIdInCriteria(userAllowList, ID_PROPERTY, idRefine);
    }

    public UserDomainRequest selectUserAllowListList(UserAllowListRequest userAllowList) {
        selectChild(UserAllowList.DOMAIN_PROPERTY, userAllowList);
        return this;
    }

    public UserDomainRequest selectUserAllowListList() {
        return selectUserAllowListList(UserAllowListRequest.newInstance().selectAll());
    }

    public UserDomainRequest unselectUserAllowListList(){
        unselectChild(UserAllowList.DOMAIN_PROPERTY, UserAllowList.class);
        return this;
    }
  

    public UserDomainRequest hasSecUser() {
      return hasSecUser(SecUserRequest.newInstance());
    }

    public UserDomainRequest hasSecUser(SecUserRequest secUser) {
        return hasSecUser(secUser, secUserList -> secUserList.stream().map(SecUser::getDomain).map(UserDomain::getId).collect(Collectors.toSet()));
    }

    public UserDomainRequest hasSecUser(SecUserRequest secUser, IDRefine<SecUser> idRefine) {
        secUser.select(SecUser.DOMAIN_PROPERTY);
        return addSearchCriteria(createSecUserCriteria(secUser, idRefine));
    }

    public SearchCriteria createSecUserCriteria(SecUserRequest secUser, IDRefine<SecUser> idRefine){
       return new RefinedIdInCriteria(secUser, ID_PROPERTY, idRefine);
    }

    public UserDomainRequest selectSecUserList(SecUserRequest secUser) {
        selectChild(SecUser.DOMAIN_PROPERTY, secUser);
        return this;
    }

    public UserDomainRequest selectSecUserList() {
        return selectSecUserList(SecUserRequest.newInstance().selectAll());
    }

    public UserDomainRequest unselectSecUserList(){
        unselectChild(SecUser.DOMAIN_PROPERTY, SecUser.class);
        return this;
    }
  

    public UserDomainRequest hasPublicKeyType() {
      return hasPublicKeyType(PublicKeyTypeRequest.newInstance());
    }

    public UserDomainRequest hasPublicKeyType(PublicKeyTypeRequest publicKeyType) {
        return hasPublicKeyType(publicKeyType, publicKeyTypeList -> publicKeyTypeList.stream().map(PublicKeyType::getDomain).map(UserDomain::getId).collect(Collectors.toSet()));
    }

    public UserDomainRequest hasPublicKeyType(PublicKeyTypeRequest publicKeyType, IDRefine<PublicKeyType> idRefine) {
        publicKeyType.select(PublicKeyType.DOMAIN_PROPERTY);
        return addSearchCriteria(createPublicKeyTypeCriteria(publicKeyType, idRefine));
    }

    public SearchCriteria createPublicKeyTypeCriteria(PublicKeyTypeRequest publicKeyType, IDRefine<PublicKeyType> idRefine){
       return new RefinedIdInCriteria(publicKeyType, ID_PROPERTY, idRefine);
    }

    public UserDomainRequest selectPublicKeyTypeList(PublicKeyTypeRequest publicKeyType) {
        selectChild(PublicKeyType.DOMAIN_PROPERTY, publicKeyType);
        return this;
    }

    public UserDomainRequest selectPublicKeyTypeList() {
        return selectPublicKeyTypeList(PublicKeyTypeRequest.newInstance().selectAll());
    }

    public UserDomainRequest unselectPublicKeyTypeList(){
        unselectChild(PublicKeyType.DOMAIN_PROPERTY, PublicKeyType.class);
        return this;
    }
  

   public UserDomainRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

