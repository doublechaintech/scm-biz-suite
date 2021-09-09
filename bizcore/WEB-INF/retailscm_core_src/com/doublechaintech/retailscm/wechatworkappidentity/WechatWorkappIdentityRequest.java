package com.doublechaintech.retailscm.wechatworkappidentity;

import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.secuser.SecUserRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.wechatworkappidentity.WechatWorkappIdentity.*;

public class WechatWorkappIdentityRequest extends BaseRequest<WechatWorkappIdentity> {
    public static WechatWorkappIdentityRequest newInstance() {
        return new WechatWorkappIdentityRequest().selectId();
    }

    public String getInternalType() {
        return "WechatWorkappIdentity";
    }

    public WechatWorkappIdentityRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public WechatWorkappIdentityRequest select(String... names) {
        super.select(names);
        return this;
    }

    public WechatWorkappIdentityRequest selectAll() {return this.selectId().selectCorpId().selectUserId().selectSecUser().selectCreateTime().selectLastLoginTime().selectVersion();
    }

    public WechatWorkappIdentityRequest selectSelf() {return this.selectId().selectCorpId().selectUserId().selectCreateTime().selectLastLoginTime().selectVersion();
    }

    public WechatWorkappIdentityRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public WechatWorkappIdentityRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static WechatWorkappIdentityRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public WechatWorkappIdentityRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public WechatWorkappIdentityRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public WechatWorkappIdentityRequest selectId(){
          return select(ID_PROPERTY);
      }

      public WechatWorkappIdentityRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public WechatWorkappIdentityRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public WechatWorkappIdentityRequest filterByCorpId(String corpId) {
          
          if (corpId == null) {
              return this;
          }
          
          return filterByCorpId(QueryOperator.EQUAL, corpId);
      }
    

      public WechatWorkappIdentityRequest filterByCorpId(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getCorpIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public WechatWorkappIdentityRequest selectCorpId(){
          return select(CORP_ID_PROPERTY);
      }

      public WechatWorkappIdentityRequest unselectCorpId(){
          return unselect(CORP_ID_PROPERTY);
      }

      public SearchCriteria getCorpIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(CORP_ID_PROPERTY, pQueryOperator, parameters);
      }

      public WechatWorkappIdentityRequest orderByCorpId(boolean asc){
          addOrderBy(CORP_ID_PROPERTY, asc);
          return this;
      }
   
      public WechatWorkappIdentityRequest filterByUserId(String userId) {
          
          if (userId == null) {
              return this;
          }
          
          return filterByUserId(QueryOperator.EQUAL, userId);
      }
    

      public WechatWorkappIdentityRequest filterByUserId(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getUserIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public WechatWorkappIdentityRequest selectUserId(){
          return select(USER_ID_PROPERTY);
      }

      public WechatWorkappIdentityRequest unselectUserId(){
          return unselect(USER_ID_PROPERTY);
      }

      public SearchCriteria getUserIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(USER_ID_PROPERTY, pQueryOperator, parameters);
      }

      public WechatWorkappIdentityRequest orderByUserId(boolean asc){
          addOrderBy(USER_ID_PROPERTY, asc);
          return this;
      }
   
      public WechatWorkappIdentityRequest filterByCreateTime(DateTime createTime) {
          
          if (createTime == null) {
              return this;
          }
          
          return filterByCreateTime(QueryOperator.EQUAL, createTime);
      }
    

      public WechatWorkappIdentityRequest filterByCreateTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getCreateTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public WechatWorkappIdentityRequest selectCreateTime(){
          return select(CREATE_TIME_PROPERTY);
      }

      public WechatWorkappIdentityRequest unselectCreateTime(){
          return unselect(CREATE_TIME_PROPERTY);
      }

      public SearchCriteria getCreateTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(CREATE_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public WechatWorkappIdentityRequest orderByCreateTime(boolean asc){
          addOrderBy(CREATE_TIME_PROPERTY, asc);
          return this;
      }
   
      public WechatWorkappIdentityRequest filterByLastLoginTime(DateTime lastLoginTime) {
          
          if (lastLoginTime == null) {
              return this;
          }
          
          return filterByLastLoginTime(QueryOperator.EQUAL, lastLoginTime);
      }
    

      public WechatWorkappIdentityRequest filterByLastLoginTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLastLoginTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public WechatWorkappIdentityRequest selectLastLoginTime(){
          return select(LAST_LOGIN_TIME_PROPERTY);
      }

      public WechatWorkappIdentityRequest unselectLastLoginTime(){
          return unselect(LAST_LOGIN_TIME_PROPERTY);
      }

      public SearchCriteria getLastLoginTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LAST_LOGIN_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public WechatWorkappIdentityRequest orderByLastLoginTime(boolean asc){
          addOrderBy(LAST_LOGIN_TIME_PROPERTY, asc);
          return this;
      }
   
      public WechatWorkappIdentityRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public WechatWorkappIdentityRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public WechatWorkappIdentityRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public WechatWorkappIdentityRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public WechatWorkappIdentityRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public WechatWorkappIdentityRequest filterBySecUser(SecUserRequest secUser){
        return filterBySecUser(secUser, secUserList -> secUserList.stream().map(SecUser::getId).collect(Collectors.toSet()));
    }

    public WechatWorkappIdentityRequest filterBySecUser(SecUserRequest secUser, IDRefine<SecUser> idRefine) {
        return addSearchCriteria(createSecUserCriteria(secUser, idRefine));
    }

    public SearchCriteria createSecUserCriteria(SecUserRequest secUser, IDRefine<SecUser> idRefine) {
        return new RefinedIdInCriteria(secUser, SEC_USER_PROPERTY, idRefine);
    }
    

    
    public WechatWorkappIdentityRequest selectSecUser(){
        return selectSecUser(SecUserRequest.newInstance().selectSelf());
    }

    public WechatWorkappIdentityRequest selectSecUser(SecUserRequest secUser){
        selectParent(SEC_USER_PROPERTY, secUser);
        return this;
    }
    

    public WechatWorkappIdentityRequest unselectSecUser(){
        unselectParent(SEC_USER_PROPERTY);
        return this;
    }

  


  

   public WechatWorkappIdentityRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

