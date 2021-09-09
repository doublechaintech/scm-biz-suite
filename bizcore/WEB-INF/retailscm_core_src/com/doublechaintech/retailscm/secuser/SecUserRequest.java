package com.doublechaintech.retailscm.secuser;

import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.keypairidentity.KeyPairIdentity;
import com.doublechaintech.retailscm.loginhistory.LoginHistory;
import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.userdomain.UserDomain;
import com.doublechaintech.retailscm.wechatminiappidentity.WechatMiniappIdentity;
import com.doublechaintech.retailscm.wechatworkappidentity.WechatWorkappIdentity;
import com.doublechaintech.retailscm.keypairidentity.KeyPairIdentityRequest;
import com.doublechaintech.retailscm.loginhistory.LoginHistoryRequest;
import com.doublechaintech.retailscm.userapp.UserAppRequest;
import com.doublechaintech.retailscm.userdomain.UserDomainRequest;
import com.doublechaintech.retailscm.wechatminiappidentity.WechatMiniappIdentityRequest;
import com.doublechaintech.retailscm.wechatworkappidentity.WechatWorkappIdentityRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.secuser.SecUser.*;

public class SecUserRequest extends BaseRequest<SecUser> {
    public static SecUserRequest newInstance() {
        return new SecUserRequest().selectId();
    }

    public String getInternalType() {
        return "SecUser";
    }

    public SecUserRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public SecUserRequest select(String... names) {
        super.select(names);
        return this;
    }

    public SecUserRequest selectAll() {return this.selectId().selectLogin().selectMobile().selectEmail().selectPwd().selectWeixinOpenid().selectWeixinAppid().selectAccessToken().selectVerificationCode().selectVerificationCodeExpire().selectLastLoginTime().selectDomain().selectVersion();
    }

    public SecUserRequest selectSelf() {return this.selectId().selectLogin().selectMobile().selectEmail().selectPwd().selectWeixinOpenid().selectWeixinAppid().selectAccessToken().selectVerificationCode().selectVerificationCodeExpire().selectLastLoginTime().selectVersion();
    }

    public SecUserRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public SecUserRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static SecUserRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   
     public static SecUserRequest withLogin(String login) {
          return newInstance().filterByLogin(login).selectAll();
     }
   
     public static SecUserRequest withMobile(String mobile) {
          return newInstance().filterByMobile(mobile).selectAll();
     }
   
     public static SecUserRequest withEmail(String email) {
          return newInstance().filterByEmail(email).selectAll();
     }
   

    
      public SecUserRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public SecUserRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SecUserRequest selectId(){
          return select(ID_PROPERTY);
      }

      public SecUserRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public SecUserRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public SecUserRequest filterByLogin(String login) {
          
          if (login == null) {
              return this;
          }
          
          return filterByLogin(QueryOperator.EQUAL, login);
      }
    

      public SecUserRequest filterByLogin(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLoginSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SecUserRequest selectLogin(){
          return select(LOGIN_PROPERTY);
      }

      public SecUserRequest unselectLogin(){
          return unselect(LOGIN_PROPERTY);
      }

      public SearchCriteria getLoginSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LOGIN_PROPERTY, pQueryOperator, parameters);
      }

      public SecUserRequest orderByLogin(boolean asc){
          addOrderBy(LOGIN_PROPERTY, asc);
          return this;
      }
   
      public SecUserRequest filterByMobile(String mobile) {
          
          if (mobile == null) {
              return this;
          }
          
          return filterByMobile(QueryOperator.EQUAL, mobile);
      }
    

      public SecUserRequest filterByMobile(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getMobileSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SecUserRequest selectMobile(){
          return select(MOBILE_PROPERTY);
      }

      public SecUserRequest unselectMobile(){
          return unselect(MOBILE_PROPERTY);
      }

      public SearchCriteria getMobileSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(MOBILE_PROPERTY, pQueryOperator, parameters);
      }

      public SecUserRequest orderByMobile(boolean asc){
          addOrderBy(MOBILE_PROPERTY, asc);
          return this;
      }
   
      public SecUserRequest filterByEmail(String email) {
          
          if (email == null) {
              return this;
          }
          
          return filterByEmail(QueryOperator.EQUAL, email);
      }
    

      public SecUserRequest filterByEmail(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getEmailSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SecUserRequest selectEmail(){
          return select(EMAIL_PROPERTY);
      }

      public SecUserRequest unselectEmail(){
          return unselect(EMAIL_PROPERTY);
      }

      public SearchCriteria getEmailSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(EMAIL_PROPERTY, pQueryOperator, parameters);
      }

      public SecUserRequest orderByEmail(boolean asc){
          addOrderBy(EMAIL_PROPERTY, asc);
          return this;
      }
   
      public SecUserRequest filterByPwd(String pwd) {
          
          if (pwd == null) {
              return this;
          }
          
          return filterByPwd(QueryOperator.EQUAL, pwd);
      }
    

      public SecUserRequest filterByPwd(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getPwdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SecUserRequest selectPwd(){
          return select(PWD_PROPERTY);
      }

      public SecUserRequest unselectPwd(){
          return unselect(PWD_PROPERTY);
      }

      public SearchCriteria getPwdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(PWD_PROPERTY, pQueryOperator, parameters);
      }

      public SecUserRequest orderByPwd(boolean asc){
          addOrderBy(PWD_PROPERTY, asc);
          return this;
      }
   
      public SecUserRequest filterByWeixinOpenid(String weixinOpenid) {
          
          if (weixinOpenid == null) {
              return this;
          }
          
          return filterByWeixinOpenid(QueryOperator.EQUAL, weixinOpenid);
      }
    

      public SecUserRequest filterByWeixinOpenid(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getWeixinOpenidSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SecUserRequest selectWeixinOpenid(){
          return select(WEIXIN_OPENID_PROPERTY);
      }

      public SecUserRequest unselectWeixinOpenid(){
          return unselect(WEIXIN_OPENID_PROPERTY);
      }

      public SearchCriteria getWeixinOpenidSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(WEIXIN_OPENID_PROPERTY, pQueryOperator, parameters);
      }

      public SecUserRequest orderByWeixinOpenid(boolean asc){
          addOrderBy(WEIXIN_OPENID_PROPERTY, asc);
          return this;
      }
   
      public SecUserRequest filterByWeixinAppid(String weixinAppid) {
          
          if (weixinAppid == null) {
              return this;
          }
          
          return filterByWeixinAppid(QueryOperator.EQUAL, weixinAppid);
      }
    

      public SecUserRequest filterByWeixinAppid(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getWeixinAppidSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SecUserRequest selectWeixinAppid(){
          return select(WEIXIN_APPID_PROPERTY);
      }

      public SecUserRequest unselectWeixinAppid(){
          return unselect(WEIXIN_APPID_PROPERTY);
      }

      public SearchCriteria getWeixinAppidSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(WEIXIN_APPID_PROPERTY, pQueryOperator, parameters);
      }

      public SecUserRequest orderByWeixinAppid(boolean asc){
          addOrderBy(WEIXIN_APPID_PROPERTY, asc);
          return this;
      }
   
      public SecUserRequest filterByAccessToken(String accessToken) {
          
          if (accessToken == null) {
              return this;
          }
          
          return filterByAccessToken(QueryOperator.EQUAL, accessToken);
      }
    

      public SecUserRequest filterByAccessToken(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getAccessTokenSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SecUserRequest selectAccessToken(){
          return select(ACCESS_TOKEN_PROPERTY);
      }

      public SecUserRequest unselectAccessToken(){
          return unselect(ACCESS_TOKEN_PROPERTY);
      }

      public SearchCriteria getAccessTokenSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ACCESS_TOKEN_PROPERTY, pQueryOperator, parameters);
      }

      public SecUserRequest orderByAccessToken(boolean asc){
          addOrderBy(ACCESS_TOKEN_PROPERTY, asc);
          return this;
      }
   
      public SecUserRequest filterByVerificationCode(int verificationCode) {
          
          return filterByVerificationCode(QueryOperator.EQUAL, verificationCode);
      }
    

      public SecUserRequest filterByVerificationCode(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVerificationCodeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SecUserRequest selectVerificationCode(){
          return select(VERIFICATION_CODE_PROPERTY);
      }

      public SecUserRequest unselectVerificationCode(){
          return unselect(VERIFICATION_CODE_PROPERTY);
      }

      public SearchCriteria getVerificationCodeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERIFICATION_CODE_PROPERTY, pQueryOperator, parameters);
      }

      public SecUserRequest orderByVerificationCode(boolean asc){
          addOrderBy(VERIFICATION_CODE_PROPERTY, asc);
          return this;
      }
   
      public SecUserRequest filterByVerificationCodeExpire(DateTime verificationCodeExpire) {
          
          if (verificationCodeExpire == null) {
              return this;
          }
          
          return filterByVerificationCodeExpire(QueryOperator.EQUAL, verificationCodeExpire);
      }
    

      public SecUserRequest filterByVerificationCodeExpire(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVerificationCodeExpireSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SecUserRequest selectVerificationCodeExpire(){
          return select(VERIFICATION_CODE_EXPIRE_PROPERTY);
      }

      public SecUserRequest unselectVerificationCodeExpire(){
          return unselect(VERIFICATION_CODE_EXPIRE_PROPERTY);
      }

      public SearchCriteria getVerificationCodeExpireSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERIFICATION_CODE_EXPIRE_PROPERTY, pQueryOperator, parameters);
      }

      public SecUserRequest orderByVerificationCodeExpire(boolean asc){
          addOrderBy(VERIFICATION_CODE_EXPIRE_PROPERTY, asc);
          return this;
      }
   
      public SecUserRequest filterByLastLoginTime(DateTime lastLoginTime) {
          
          if (lastLoginTime == null) {
              return this;
          }
          
          return filterByLastLoginTime(QueryOperator.EQUAL, lastLoginTime);
      }
    

      public SecUserRequest filterByLastLoginTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLastLoginTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SecUserRequest selectLastLoginTime(){
          return select(LAST_LOGIN_TIME_PROPERTY);
      }

      public SecUserRequest unselectLastLoginTime(){
          return unselect(LAST_LOGIN_TIME_PROPERTY);
      }

      public SearchCriteria getLastLoginTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LAST_LOGIN_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public SecUserRequest orderByLastLoginTime(boolean asc){
          addOrderBy(LAST_LOGIN_TIME_PROPERTY, asc);
          return this;
      }
   
      public SecUserRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public SecUserRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SecUserRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public SecUserRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public SecUserRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public SecUserRequest filterByDomain(UserDomainRequest domain){
        return filterByDomain(domain, domainList -> domainList.stream().map(UserDomain::getId).collect(Collectors.toSet()));
    }

    public SecUserRequest filterByDomain(UserDomainRequest domain, IDRefine<UserDomain> idRefine) {
        return addSearchCriteria(createDomainCriteria(domain, idRefine));
    }

    public SearchCriteria createDomainCriteria(UserDomainRequest domain, IDRefine<UserDomain> idRefine) {
        return new RefinedIdInCriteria(domain, DOMAIN_PROPERTY, idRefine);
    }
    

    
    public SecUserRequest selectDomain(){
        return selectDomain(UserDomainRequest.newInstance().selectSelf());
    }

    public SecUserRequest selectDomain(UserDomainRequest domain){
        selectParent(DOMAIN_PROPERTY, domain);
        return this;
    }
    

    public SecUserRequest unselectDomain(){
        unselectParent(DOMAIN_PROPERTY);
        return this;
    }

  


  

    public SecUserRequest hasUserApp() {
      return hasUserApp(UserAppRequest.newInstance());
    }

    public SecUserRequest hasUserApp(UserAppRequest userApp) {
        return hasUserApp(userApp, userAppList -> userAppList.stream().map(UserApp::getSecUser).map(SecUser::getId).collect(Collectors.toSet()));
    }

    public SecUserRequest hasUserApp(UserAppRequest userApp, IDRefine<UserApp> idRefine) {
        userApp.select(UserApp.SEC_USER_PROPERTY);
        return addSearchCriteria(createUserAppCriteria(userApp, idRefine));
    }

    public SearchCriteria createUserAppCriteria(UserAppRequest userApp, IDRefine<UserApp> idRefine){
       return new RefinedIdInCriteria(userApp, ID_PROPERTY, idRefine);
    }

    public SecUserRequest selectUserAppList(UserAppRequest userApp) {
        selectChild(UserApp.SEC_USER_PROPERTY, userApp);
        return this;
    }

    public SecUserRequest selectUserAppList() {
        return selectUserAppList(UserAppRequest.newInstance().selectAll());
    }

    public SecUserRequest unselectUserAppList(){
        unselectChild(UserApp.SEC_USER_PROPERTY, UserApp.class);
        return this;
    }
  

    public SecUserRequest hasLoginHistory() {
      return hasLoginHistory(LoginHistoryRequest.newInstance());
    }

    public SecUserRequest hasLoginHistory(LoginHistoryRequest loginHistory) {
        return hasLoginHistory(loginHistory, loginHistoryList -> loginHistoryList.stream().map(LoginHistory::getSecUser).map(SecUser::getId).collect(Collectors.toSet()));
    }

    public SecUserRequest hasLoginHistory(LoginHistoryRequest loginHistory, IDRefine<LoginHistory> idRefine) {
        loginHistory.select(LoginHistory.SEC_USER_PROPERTY);
        return addSearchCriteria(createLoginHistoryCriteria(loginHistory, idRefine));
    }

    public SearchCriteria createLoginHistoryCriteria(LoginHistoryRequest loginHistory, IDRefine<LoginHistory> idRefine){
       return new RefinedIdInCriteria(loginHistory, ID_PROPERTY, idRefine);
    }

    public SecUserRequest selectLoginHistoryList(LoginHistoryRequest loginHistory) {
        selectChild(LoginHistory.SEC_USER_PROPERTY, loginHistory);
        return this;
    }

    public SecUserRequest selectLoginHistoryList() {
        return selectLoginHistoryList(LoginHistoryRequest.newInstance().selectAll());
    }

    public SecUserRequest unselectLoginHistoryList(){
        unselectChild(LoginHistory.SEC_USER_PROPERTY, LoginHistory.class);
        return this;
    }
  

    public SecUserRequest hasWechatWorkappIdentity() {
      return hasWechatWorkappIdentity(WechatWorkappIdentityRequest.newInstance());
    }

    public SecUserRequest hasWechatWorkappIdentity(WechatWorkappIdentityRequest wechatWorkappIdentity) {
        return hasWechatWorkappIdentity(wechatWorkappIdentity, wechatWorkappIdentityList -> wechatWorkappIdentityList.stream().map(WechatWorkappIdentity::getSecUser).map(SecUser::getId).collect(Collectors.toSet()));
    }

    public SecUserRequest hasWechatWorkappIdentity(WechatWorkappIdentityRequest wechatWorkappIdentity, IDRefine<WechatWorkappIdentity> idRefine) {
        wechatWorkappIdentity.select(WechatWorkappIdentity.SEC_USER_PROPERTY);
        return addSearchCriteria(createWechatWorkappIdentityCriteria(wechatWorkappIdentity, idRefine));
    }

    public SearchCriteria createWechatWorkappIdentityCriteria(WechatWorkappIdentityRequest wechatWorkappIdentity, IDRefine<WechatWorkappIdentity> idRefine){
       return new RefinedIdInCriteria(wechatWorkappIdentity, ID_PROPERTY, idRefine);
    }

    public SecUserRequest selectWechatWorkappIdentityList(WechatWorkappIdentityRequest wechatWorkappIdentity) {
        selectChild(WechatWorkappIdentity.SEC_USER_PROPERTY, wechatWorkappIdentity);
        return this;
    }

    public SecUserRequest selectWechatWorkappIdentityList() {
        return selectWechatWorkappIdentityList(WechatWorkappIdentityRequest.newInstance().selectAll());
    }

    public SecUserRequest unselectWechatWorkappIdentityList(){
        unselectChild(WechatWorkappIdentity.SEC_USER_PROPERTY, WechatWorkappIdentity.class);
        return this;
    }
  

    public SecUserRequest hasWechatMiniappIdentity() {
      return hasWechatMiniappIdentity(WechatMiniappIdentityRequest.newInstance());
    }

    public SecUserRequest hasWechatMiniappIdentity(WechatMiniappIdentityRequest wechatMiniappIdentity) {
        return hasWechatMiniappIdentity(wechatMiniappIdentity, wechatMiniappIdentityList -> wechatMiniappIdentityList.stream().map(WechatMiniappIdentity::getSecUser).map(SecUser::getId).collect(Collectors.toSet()));
    }

    public SecUserRequest hasWechatMiniappIdentity(WechatMiniappIdentityRequest wechatMiniappIdentity, IDRefine<WechatMiniappIdentity> idRefine) {
        wechatMiniappIdentity.select(WechatMiniappIdentity.SEC_USER_PROPERTY);
        return addSearchCriteria(createWechatMiniappIdentityCriteria(wechatMiniappIdentity, idRefine));
    }

    public SearchCriteria createWechatMiniappIdentityCriteria(WechatMiniappIdentityRequest wechatMiniappIdentity, IDRefine<WechatMiniappIdentity> idRefine){
       return new RefinedIdInCriteria(wechatMiniappIdentity, ID_PROPERTY, idRefine);
    }

    public SecUserRequest selectWechatMiniappIdentityList(WechatMiniappIdentityRequest wechatMiniappIdentity) {
        selectChild(WechatMiniappIdentity.SEC_USER_PROPERTY, wechatMiniappIdentity);
        return this;
    }

    public SecUserRequest selectWechatMiniappIdentityList() {
        return selectWechatMiniappIdentityList(WechatMiniappIdentityRequest.newInstance().selectAll());
    }

    public SecUserRequest unselectWechatMiniappIdentityList(){
        unselectChild(WechatMiniappIdentity.SEC_USER_PROPERTY, WechatMiniappIdentity.class);
        return this;
    }
  

    public SecUserRequest hasKeyPairIdentity() {
      return hasKeyPairIdentity(KeyPairIdentityRequest.newInstance());
    }

    public SecUserRequest hasKeyPairIdentity(KeyPairIdentityRequest keyPairIdentity) {
        return hasKeyPairIdentity(keyPairIdentity, keyPairIdentityList -> keyPairIdentityList.stream().map(KeyPairIdentity::getSecUser).map(SecUser::getId).collect(Collectors.toSet()));
    }

    public SecUserRequest hasKeyPairIdentity(KeyPairIdentityRequest keyPairIdentity, IDRefine<KeyPairIdentity> idRefine) {
        keyPairIdentity.select(KeyPairIdentity.SEC_USER_PROPERTY);
        return addSearchCriteria(createKeyPairIdentityCriteria(keyPairIdentity, idRefine));
    }

    public SearchCriteria createKeyPairIdentityCriteria(KeyPairIdentityRequest keyPairIdentity, IDRefine<KeyPairIdentity> idRefine){
       return new RefinedIdInCriteria(keyPairIdentity, ID_PROPERTY, idRefine);
    }

    public SecUserRequest selectKeyPairIdentityList(KeyPairIdentityRequest keyPairIdentity) {
        selectChild(KeyPairIdentity.SEC_USER_PROPERTY, keyPairIdentity);
        return this;
    }

    public SecUserRequest selectKeyPairIdentityList() {
        return selectKeyPairIdentityList(KeyPairIdentityRequest.newInstance().selectAll());
    }

    public SecUserRequest unselectKeyPairIdentityList(){
        unselectChild(KeyPairIdentity.SEC_USER_PROPERTY, KeyPairIdentity.class);
        return this;
    }
  

   public SecUserRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

