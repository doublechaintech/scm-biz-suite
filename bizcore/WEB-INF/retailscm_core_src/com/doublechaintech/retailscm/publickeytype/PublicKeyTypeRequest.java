package com.doublechaintech.retailscm.publickeytype;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.keypairidentity.KeyPairIdentity;
import com.doublechaintech.retailscm.userdomain.UserDomain;
import com.doublechaintech.retailscm.keypairidentity.KeyPairIdentityRequest;
import com.doublechaintech.retailscm.userdomain.UserDomainRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.publickeytype.PublicKeyType.*;

public class PublicKeyTypeRequest extends BaseRequest<PublicKeyType> {
    public static PublicKeyTypeRequest newInstance() {
        return new PublicKeyTypeRequest().selectId();
    }

    public String getInternalType() {
        return "PublicKeyType";
    }

    public PublicKeyTypeRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public PublicKeyTypeRequest select(String... names) {
        super.select(names);
        return this;
    }

    public PublicKeyTypeRequest selectAll() {return this.selectId().selectKeyAlg().selectSignAlg().selectDomain().selectVersion();
    }

    public PublicKeyTypeRequest selectSelf() {return this.selectId().selectKeyAlg().selectSignAlg().selectVersion();
    }

    public PublicKeyTypeRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public PublicKeyTypeRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static PublicKeyTypeRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public PublicKeyTypeRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public PublicKeyTypeRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public PublicKeyTypeRequest selectId(){
          return select(ID_PROPERTY);
      }

      public PublicKeyTypeRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public PublicKeyTypeRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public PublicKeyTypeRequest filterByKeyAlg(String keyAlg) {
          
          if (keyAlg == null) {
              return this;
          }
          
          return filterByKeyAlg(QueryOperator.EQUAL, keyAlg);
      }
    

      public PublicKeyTypeRequest filterByKeyAlg(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getKeyAlgSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public PublicKeyTypeRequest selectKeyAlg(){
          return select(KEY_ALG_PROPERTY);
      }

      public PublicKeyTypeRequest unselectKeyAlg(){
          return unselect(KEY_ALG_PROPERTY);
      }

      public SearchCriteria getKeyAlgSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(KEY_ALG_PROPERTY, pQueryOperator, parameters);
      }

      public PublicKeyTypeRequest orderByKeyAlg(boolean asc){
          addOrderBy(KEY_ALG_PROPERTY, asc);
          return this;
      }
   
      public PublicKeyTypeRequest filterBySignAlg(String signAlg) {
          
          if (signAlg == null) {
              return this;
          }
          
          return filterBySignAlg(QueryOperator.EQUAL, signAlg);
      }
    

      public PublicKeyTypeRequest filterBySignAlg(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getSignAlgSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public PublicKeyTypeRequest selectSignAlg(){
          return select(SIGN_ALG_PROPERTY);
      }

      public PublicKeyTypeRequest unselectSignAlg(){
          return unselect(SIGN_ALG_PROPERTY);
      }

      public SearchCriteria getSignAlgSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(SIGN_ALG_PROPERTY, pQueryOperator, parameters);
      }

      public PublicKeyTypeRequest orderBySignAlg(boolean asc){
          addOrderBy(SIGN_ALG_PROPERTY, asc);
          return this;
      }
   
      public PublicKeyTypeRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public PublicKeyTypeRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public PublicKeyTypeRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public PublicKeyTypeRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public PublicKeyTypeRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public PublicKeyTypeRequest filterByDomain(UserDomainRequest domain){
        return filterByDomain(domain, domainList -> domainList.stream().map(UserDomain::getId).collect(Collectors.toSet()));
    }

    public PublicKeyTypeRequest filterByDomain(UserDomainRequest domain, IDRefine<UserDomain> idRefine) {
        return addSearchCriteria(createDomainCriteria(domain, idRefine));
    }

    public SearchCriteria createDomainCriteria(UserDomainRequest domain, IDRefine<UserDomain> idRefine) {
        return new RefinedIdInCriteria(domain, DOMAIN_PROPERTY, idRefine);
    }
    

    
    public PublicKeyTypeRequest selectDomain(){
        return selectDomain(UserDomainRequest.newInstance().selectSelf());
    }

    public PublicKeyTypeRequest selectDomain(UserDomainRequest domain){
        selectParent(DOMAIN_PROPERTY, domain);
        return this;
    }
    

    public PublicKeyTypeRequest unselectDomain(){
        unselectParent(DOMAIN_PROPERTY);
        return this;
    }

  


  

    public PublicKeyTypeRequest hasKeyPairIdentity() {
      return hasKeyPairIdentity(KeyPairIdentityRequest.newInstance());
    }

    public PublicKeyTypeRequest hasKeyPairIdentity(KeyPairIdentityRequest keyPairIdentity) {
        return hasKeyPairIdentity(keyPairIdentity, keyPairIdentityList -> keyPairIdentityList.stream().map(KeyPairIdentity::getKeyType).map(PublicKeyType::getId).collect(Collectors.toSet()));
    }

    public PublicKeyTypeRequest hasKeyPairIdentity(KeyPairIdentityRequest keyPairIdentity, IDRefine<KeyPairIdentity> idRefine) {
        keyPairIdentity.select(KeyPairIdentity.KEY_TYPE_PROPERTY);
        return addSearchCriteria(createKeyPairIdentityCriteria(keyPairIdentity, idRefine));
    }

    public SearchCriteria createKeyPairIdentityCriteria(KeyPairIdentityRequest keyPairIdentity, IDRefine<KeyPairIdentity> idRefine){
       return new RefinedIdInCriteria(keyPairIdentity, ID_PROPERTY, idRefine);
    }

    public PublicKeyTypeRequest selectKeyPairIdentityList(KeyPairIdentityRequest keyPairIdentity) {
        selectChild(KeyPairIdentity.KEY_TYPE_PROPERTY, keyPairIdentity);
        return this;
    }

    public PublicKeyTypeRequest selectKeyPairIdentityList() {
        return selectKeyPairIdentityList(KeyPairIdentityRequest.newInstance().selectAll());
    }

    public PublicKeyTypeRequest unselectKeyPairIdentityList(){
        unselectChild(KeyPairIdentity.KEY_TYPE_PROPERTY, KeyPairIdentity.class);
        return this;
    }
  

   public PublicKeyTypeRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

