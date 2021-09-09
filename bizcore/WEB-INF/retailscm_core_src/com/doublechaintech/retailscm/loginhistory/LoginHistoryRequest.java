package com.doublechaintech.retailscm.loginhistory;

import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.secuser.SecUserRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.loginhistory.LoginHistory.*;

public class LoginHistoryRequest extends BaseRequest<LoginHistory> {
    public static LoginHistoryRequest newInstance() {
        return new LoginHistoryRequest().selectId();
    }

    public String getInternalType() {
        return "LoginHistory";
    }

    public LoginHistoryRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public LoginHistoryRequest select(String... names) {
        super.select(names);
        return this;
    }

    public LoginHistoryRequest selectAll() {return this.selectId().selectLoginTime().selectFromIp().selectDescription().selectSecUser().selectVersion();
    }

    public LoginHistoryRequest selectSelf() {return this.selectId().selectLoginTime().selectFromIp().selectDescription().selectVersion();
    }

    public LoginHistoryRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public LoginHistoryRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static LoginHistoryRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public LoginHistoryRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public LoginHistoryRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public LoginHistoryRequest selectId(){
          return select(ID_PROPERTY);
      }

      public LoginHistoryRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public LoginHistoryRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public LoginHistoryRequest filterByLoginTime(DateTime loginTime) {
          
          if (loginTime == null) {
              return this;
          }
          
          return filterByLoginTime(QueryOperator.EQUAL, loginTime);
      }
    

      public LoginHistoryRequest filterByLoginTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLoginTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public LoginHistoryRequest selectLoginTime(){
          return select(LOGIN_TIME_PROPERTY);
      }

      public LoginHistoryRequest unselectLoginTime(){
          return unselect(LOGIN_TIME_PROPERTY);
      }

      public SearchCriteria getLoginTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LOGIN_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public LoginHistoryRequest orderByLoginTime(boolean asc){
          addOrderBy(LOGIN_TIME_PROPERTY, asc);
          return this;
      }
   
      public LoginHistoryRequest filterByFromIp(String fromIp) {
          
          if (fromIp == null) {
              return this;
          }
          
          return filterByFromIp(QueryOperator.EQUAL, fromIp);
      }
    

      public LoginHistoryRequest filterByFromIp(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getFromIpSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public LoginHistoryRequest selectFromIp(){
          return select(FROM_IP_PROPERTY);
      }

      public LoginHistoryRequest unselectFromIp(){
          return unselect(FROM_IP_PROPERTY);
      }

      public SearchCriteria getFromIpSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(FROM_IP_PROPERTY, pQueryOperator, parameters);
      }

      public LoginHistoryRequest orderByFromIp(boolean asc){
          addOrderBy(FROM_IP_PROPERTY, asc);
          return this;
      }
   
      public LoginHistoryRequest filterByDescription(String description) {
          
          if (description == null) {
              return this;
          }
          
          return filterByDescription(QueryOperator.EQUAL, description);
      }
    

      public LoginHistoryRequest filterByDescription(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public LoginHistoryRequest selectDescription(){
          return select(DESCRIPTION_PROPERTY);
      }

      public LoginHistoryRequest unselectDescription(){
          return unselect(DESCRIPTION_PROPERTY);
      }

      public SearchCriteria getDescriptionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
      }

      public LoginHistoryRequest orderByDescription(boolean asc){
          addOrderBy(DESCRIPTION_PROPERTY, asc);
          return this;
      }
   
      public LoginHistoryRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public LoginHistoryRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public LoginHistoryRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public LoginHistoryRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public LoginHistoryRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public LoginHistoryRequest filterBySecUser(SecUserRequest secUser){
        return filterBySecUser(secUser, secUserList -> secUserList.stream().map(SecUser::getId).collect(Collectors.toSet()));
    }

    public LoginHistoryRequest filterBySecUser(SecUserRequest secUser, IDRefine<SecUser> idRefine) {
        return addSearchCriteria(createSecUserCriteria(secUser, idRefine));
    }

    public SearchCriteria createSecUserCriteria(SecUserRequest secUser, IDRefine<SecUser> idRefine) {
        return new RefinedIdInCriteria(secUser, SEC_USER_PROPERTY, idRefine);
    }
    

    
    public LoginHistoryRequest selectSecUser(){
        return selectSecUser(SecUserRequest.newInstance().selectSelf());
    }

    public LoginHistoryRequest selectSecUser(SecUserRequest secUser){
        selectParent(SEC_USER_PROPERTY, secUser);
        return this;
    }
    

    public LoginHistoryRequest unselectSecUser(){
        unselectParent(SEC_USER_PROPERTY);
        return this;
    }

  


  

   public LoginHistoryRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

