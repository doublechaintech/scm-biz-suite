package com.doublechaintech.retailscm.memberwishlistproduct;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.memberwishlist.MemberWishlist;
import com.doublechaintech.retailscm.memberwishlist.MemberWishlistRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.memberwishlistproduct.MemberWishlistProduct.*;

public class MemberWishlistProductRequest extends BaseRequest<MemberWishlistProduct> {
    public static MemberWishlistProductRequest newInstance() {
        return new MemberWishlistProductRequest().selectId();
    }

    public String getInternalType() {
        return "MemberWishlistProduct";
    }

    public MemberWishlistProductRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public MemberWishlistProductRequest select(String... names) {
        super.select(names);
        return this;
    }

    public MemberWishlistProductRequest selectAll() {return this.selectId().selectName().selectOwner().selectVersion();
    }

    public MemberWishlistProductRequest selectSelf() {return this.selectId().selectName().selectVersion();
    }

    public MemberWishlistProductRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public MemberWishlistProductRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static MemberWishlistProductRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public MemberWishlistProductRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public MemberWishlistProductRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public MemberWishlistProductRequest selectId(){
          return select(ID_PROPERTY);
      }

      public MemberWishlistProductRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public MemberWishlistProductRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public MemberWishlistProductRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public MemberWishlistProductRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public MemberWishlistProductRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public MemberWishlistProductRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public MemberWishlistProductRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public MemberWishlistProductRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public MemberWishlistProductRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public MemberWishlistProductRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public MemberWishlistProductRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public MemberWishlistProductRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public MemberWishlistProductRequest filterByOwner(MemberWishlistRequest owner){
        return filterByOwner(owner, ownerList -> ownerList.stream().map(MemberWishlist::getId).collect(Collectors.toSet()));
    }

    public MemberWishlistProductRequest filterByOwner(MemberWishlistRequest owner, IDRefine<MemberWishlist> idRefine) {
        return addSearchCriteria(createOwnerCriteria(owner, idRefine));
    }

    public SearchCriteria createOwnerCriteria(MemberWishlistRequest owner, IDRefine<MemberWishlist> idRefine) {
        return new RefinedIdInCriteria(owner, OWNER_PROPERTY, idRefine);
    }
    

    
    public MemberWishlistProductRequest selectOwner(){
        return selectOwner(MemberWishlistRequest.newInstance().selectSelf());
    }

    public MemberWishlistProductRequest selectOwner(MemberWishlistRequest owner){
        selectParent(OWNER_PROPERTY, owner);
        return this;
    }
    

    public MemberWishlistProductRequest unselectOwner(){
        unselectParent(OWNER_PROPERTY);
        return this;
    }

  


  

   public MemberWishlistProductRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

