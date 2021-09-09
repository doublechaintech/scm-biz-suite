package com.doublechaintech.retailscm.wechatminiappidentity;

import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.secuser.SecUserRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.wechatminiappidentity.WechatMiniappIdentity.*;

public class WechatMiniappIdentityRequest extends BaseRequest<WechatMiniappIdentity> {
    public static WechatMiniappIdentityRequest newInstance() {
        return new WechatMiniappIdentityRequest().selectId();
    }

    public String getInternalType() {
        return "WechatMiniappIdentity";
    }

    public WechatMiniappIdentityRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public WechatMiniappIdentityRequest select(String... names) {
        super.select(names);
        return this;
    }

    public WechatMiniappIdentityRequest selectAll() {return this.selectId().selectOpenId().selectAppId().selectUnionId().selectSecUser().selectCreateTime().selectLastLoginTime().selectVersion();
    }

    public WechatMiniappIdentityRequest selectSelf() {return this.selectId().selectOpenId().selectAppId().selectUnionId().selectCreateTime().selectLastLoginTime().selectVersion();
    }

    public WechatMiniappIdentityRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public WechatMiniappIdentityRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static WechatMiniappIdentityRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public WechatMiniappIdentityRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public WechatMiniappIdentityRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public WechatMiniappIdentityRequest selectId(){
          return select(ID_PROPERTY);
      }

      public WechatMiniappIdentityRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public WechatMiniappIdentityRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public WechatMiniappIdentityRequest filterByOpenId(String openId) {
          
          if (openId == null) {
              return this;
          }
          
          return filterByOpenId(QueryOperator.EQUAL, openId);
      }
    

      public WechatMiniappIdentityRequest filterByOpenId(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getOpenIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public WechatMiniappIdentityRequest selectOpenId(){
          return select(OPEN_ID_PROPERTY);
      }

      public WechatMiniappIdentityRequest unselectOpenId(){
          return unselect(OPEN_ID_PROPERTY);
      }

      public SearchCriteria getOpenIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(OPEN_ID_PROPERTY, pQueryOperator, parameters);
      }

      public WechatMiniappIdentityRequest orderByOpenId(boolean asc){
          addOrderBy(OPEN_ID_PROPERTY, asc);
          return this;
      }
   
      public WechatMiniappIdentityRequest filterByAppId(String appId) {
          
          if (appId == null) {
              return this;
          }
          
          return filterByAppId(QueryOperator.EQUAL, appId);
      }
    

      public WechatMiniappIdentityRequest filterByAppId(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getAppIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public WechatMiniappIdentityRequest selectAppId(){
          return select(APP_ID_PROPERTY);
      }

      public WechatMiniappIdentityRequest unselectAppId(){
          return unselect(APP_ID_PROPERTY);
      }

      public SearchCriteria getAppIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(APP_ID_PROPERTY, pQueryOperator, parameters);
      }

      public WechatMiniappIdentityRequest orderByAppId(boolean asc){
          addOrderBy(APP_ID_PROPERTY, asc);
          return this;
      }
   
      public WechatMiniappIdentityRequest filterByUnionId(String unionId) {
          
          if (unionId == null) {
              return this;
          }
          
          return filterByUnionId(QueryOperator.EQUAL, unionId);
      }
    

      public WechatMiniappIdentityRequest filterByUnionId(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getUnionIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public WechatMiniappIdentityRequest selectUnionId(){
          return select(UNION_ID_PROPERTY);
      }

      public WechatMiniappIdentityRequest unselectUnionId(){
          return unselect(UNION_ID_PROPERTY);
      }

      public SearchCriteria getUnionIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(UNION_ID_PROPERTY, pQueryOperator, parameters);
      }

      public WechatMiniappIdentityRequest orderByUnionId(boolean asc){
          addOrderBy(UNION_ID_PROPERTY, asc);
          return this;
      }
   
      public WechatMiniappIdentityRequest filterByCreateTime(DateTime createTime) {
          
          if (createTime == null) {
              return this;
          }
          
          return filterByCreateTime(QueryOperator.EQUAL, createTime);
      }
    

      public WechatMiniappIdentityRequest filterByCreateTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getCreateTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public WechatMiniappIdentityRequest selectCreateTime(){
          return select(CREATE_TIME_PROPERTY);
      }

      public WechatMiniappIdentityRequest unselectCreateTime(){
          return unselect(CREATE_TIME_PROPERTY);
      }

      public SearchCriteria getCreateTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(CREATE_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public WechatMiniappIdentityRequest orderByCreateTime(boolean asc){
          addOrderBy(CREATE_TIME_PROPERTY, asc);
          return this;
      }
   
      public WechatMiniappIdentityRequest filterByLastLoginTime(DateTime lastLoginTime) {
          
          if (lastLoginTime == null) {
              return this;
          }
          
          return filterByLastLoginTime(QueryOperator.EQUAL, lastLoginTime);
      }
    

      public WechatMiniappIdentityRequest filterByLastLoginTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLastLoginTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public WechatMiniappIdentityRequest selectLastLoginTime(){
          return select(LAST_LOGIN_TIME_PROPERTY);
      }

      public WechatMiniappIdentityRequest unselectLastLoginTime(){
          return unselect(LAST_LOGIN_TIME_PROPERTY);
      }

      public SearchCriteria getLastLoginTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LAST_LOGIN_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public WechatMiniappIdentityRequest orderByLastLoginTime(boolean asc){
          addOrderBy(LAST_LOGIN_TIME_PROPERTY, asc);
          return this;
      }
   
      public WechatMiniappIdentityRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public WechatMiniappIdentityRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public WechatMiniappIdentityRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public WechatMiniappIdentityRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public WechatMiniappIdentityRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public WechatMiniappIdentityRequest filterBySecUser(SecUserRequest secUser){
        return filterBySecUser(secUser, secUserList -> secUserList.stream().map(SecUser::getId).collect(Collectors.toSet()));
    }

    public WechatMiniappIdentityRequest filterBySecUser(SecUserRequest secUser, IDRefine<SecUser> idRefine) {
        return addSearchCriteria(createSecUserCriteria(secUser, idRefine));
    }

    public SearchCriteria createSecUserCriteria(SecUserRequest secUser, IDRefine<SecUser> idRefine) {
        return new RefinedIdInCriteria(secUser, SEC_USER_PROPERTY, idRefine);
    }
    

    
    public WechatMiniappIdentityRequest selectSecUser(){
        return selectSecUser(SecUserRequest.newInstance().selectSelf());
    }

    public WechatMiniappIdentityRequest selectSecUser(SecUserRequest secUser){
        selectParent(SEC_USER_PROPERTY, secUser);
        return this;
    }
    

    public WechatMiniappIdentityRequest unselectSecUser(){
        unselectParent(SEC_USER_PROPERTY);
        return this;
    }

  


  

   public WechatMiniappIdentityRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

