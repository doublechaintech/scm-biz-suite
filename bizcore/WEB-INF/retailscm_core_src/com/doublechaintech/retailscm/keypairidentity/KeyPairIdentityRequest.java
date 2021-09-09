package com.doublechaintech.retailscm.keypairidentity;

import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.publickeytype.PublicKeyType;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.publickeytype.PublicKeyTypeRequest;
import com.doublechaintech.retailscm.secuser.SecUserRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.keypairidentity.KeyPairIdentity.*;

public class KeyPairIdentityRequest extends BaseRequest<KeyPairIdentity> {
    public static KeyPairIdentityRequest newInstance() {
        return new KeyPairIdentityRequest().selectId();
    }

    public String getInternalType() {
        return "KeyPairIdentity";
    }

    public KeyPairIdentityRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public KeyPairIdentityRequest select(String... names) {
        super.select(names);
        return this;
    }

    public KeyPairIdentityRequest selectAll() {return this.selectId().selectPublicKey().selectKeyType().selectSecUser().selectCreateTime().selectVersion();
    }

    public KeyPairIdentityRequest selectSelf() {return this.selectId().selectPublicKey().selectCreateTime().selectVersion();
    }

    public KeyPairIdentityRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public KeyPairIdentityRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static KeyPairIdentityRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public KeyPairIdentityRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public KeyPairIdentityRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public KeyPairIdentityRequest selectId(){
          return select(ID_PROPERTY);
      }

      public KeyPairIdentityRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public KeyPairIdentityRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public KeyPairIdentityRequest filterByPublicKey(String publicKey) {
          
          if (publicKey == null) {
              return this;
          }
          
          return filterByPublicKey(QueryOperator.EQUAL, publicKey);
      }
    

      public KeyPairIdentityRequest filterByPublicKey(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getPublicKeySearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public KeyPairIdentityRequest selectPublicKey(){
          return select(PUBLIC_KEY_PROPERTY);
      }

      public KeyPairIdentityRequest unselectPublicKey(){
          return unselect(PUBLIC_KEY_PROPERTY);
      }

      public SearchCriteria getPublicKeySearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(PUBLIC_KEY_PROPERTY, pQueryOperator, parameters);
      }

      public KeyPairIdentityRequest orderByPublicKey(boolean asc){
          addOrderBy(PUBLIC_KEY_PROPERTY, asc);
          return this;
      }
   
      public KeyPairIdentityRequest filterByCreateTime(DateTime createTime) {
          
          if (createTime == null) {
              return this;
          }
          
          return filterByCreateTime(QueryOperator.EQUAL, createTime);
      }
    

      public KeyPairIdentityRequest filterByCreateTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getCreateTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public KeyPairIdentityRequest selectCreateTime(){
          return select(CREATE_TIME_PROPERTY);
      }

      public KeyPairIdentityRequest unselectCreateTime(){
          return unselect(CREATE_TIME_PROPERTY);
      }

      public SearchCriteria getCreateTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(CREATE_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public KeyPairIdentityRequest orderByCreateTime(boolean asc){
          addOrderBy(CREATE_TIME_PROPERTY, asc);
          return this;
      }
   
      public KeyPairIdentityRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public KeyPairIdentityRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public KeyPairIdentityRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public KeyPairIdentityRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public KeyPairIdentityRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public KeyPairIdentityRequest filterByKeyType(PublicKeyTypeRequest keyType){
        return filterByKeyType(keyType, keyTypeList -> keyTypeList.stream().map(PublicKeyType::getId).collect(Collectors.toSet()));
    }

    public KeyPairIdentityRequest filterByKeyType(PublicKeyTypeRequest keyType, IDRefine<PublicKeyType> idRefine) {
        return addSearchCriteria(createKeyTypeCriteria(keyType, idRefine));
    }

    public SearchCriteria createKeyTypeCriteria(PublicKeyTypeRequest keyType, IDRefine<PublicKeyType> idRefine) {
        return new RefinedIdInCriteria(keyType, KEY_TYPE_PROPERTY, idRefine);
    }
    

    
    public KeyPairIdentityRequest selectKeyType(){
        return selectKeyType(PublicKeyTypeRequest.newInstance().selectSelf());
    }

    public KeyPairIdentityRequest selectKeyType(PublicKeyTypeRequest keyType){
        selectParent(KEY_TYPE_PROPERTY, keyType);
        return this;
    }
    

    public KeyPairIdentityRequest unselectKeyType(){
        unselectParent(KEY_TYPE_PROPERTY);
        return this;
    }

  

    
    public KeyPairIdentityRequest filterBySecUser(SecUserRequest secUser){
        return filterBySecUser(secUser, secUserList -> secUserList.stream().map(SecUser::getId).collect(Collectors.toSet()));
    }

    public KeyPairIdentityRequest filterBySecUser(SecUserRequest secUser, IDRefine<SecUser> idRefine) {
        return addSearchCriteria(createSecUserCriteria(secUser, idRefine));
    }

    public SearchCriteria createSecUserCriteria(SecUserRequest secUser, IDRefine<SecUser> idRefine) {
        return new RefinedIdInCriteria(secUser, SEC_USER_PROPERTY, idRefine);
    }
    

    
    public KeyPairIdentityRequest selectSecUser(){
        return selectSecUser(SecUserRequest.newInstance().selectSelf());
    }

    public KeyPairIdentityRequest selectSecUser(SecUserRequest secUser){
        selectParent(SEC_USER_PROPERTY, secUser);
        return this;
    }
    

    public KeyPairIdentityRequest unselectSecUser(){
        unselectParent(SEC_USER_PROPERTY);
        return this;
    }

  


  

   public KeyPairIdentityRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

