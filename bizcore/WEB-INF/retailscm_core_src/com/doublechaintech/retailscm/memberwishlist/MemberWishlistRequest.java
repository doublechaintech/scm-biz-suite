package com.doublechaintech.retailscm.memberwishlist;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.memberwishlistproduct.MemberWishlistProduct;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;
import com.doublechaintech.retailscm.memberwishlistproduct.MemberWishlistProductRequest;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.memberwishlist.MemberWishlist.*;

public class MemberWishlistRequest extends BaseRequest<MemberWishlist> {
    public static MemberWishlistRequest newInstance() {
        return new MemberWishlistRequest().selectId();
    }

    public String getInternalType() {
        return "MemberWishlist";
    }

    public MemberWishlistRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public MemberWishlistRequest select(String... names) {
        super.select(names);
        return this;
    }

    public MemberWishlistRequest selectAll() {return this.selectId().selectName().selectOwner().selectVersion();
    }

    public MemberWishlistRequest selectSelf() {return this.selectId().selectName().selectVersion();
    }

    public MemberWishlistRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public MemberWishlistRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static MemberWishlistRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public MemberWishlistRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public MemberWishlistRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public MemberWishlistRequest selectId(){
          return select(ID_PROPERTY);
      }

      public MemberWishlistRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public MemberWishlistRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public MemberWishlistRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public MemberWishlistRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public MemberWishlistRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public MemberWishlistRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public MemberWishlistRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public MemberWishlistRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public MemberWishlistRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public MemberWishlistRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public MemberWishlistRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public MemberWishlistRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public MemberWishlistRequest filterByOwner(RetailStoreMemberRequest owner){
        return filterByOwner(owner, ownerList -> ownerList.stream().map(RetailStoreMember::getId).collect(Collectors.toSet()));
    }

    public MemberWishlistRequest filterByOwner(RetailStoreMemberRequest owner, IDRefine<RetailStoreMember> idRefine) {
        return addSearchCriteria(createOwnerCriteria(owner, idRefine));
    }

    public SearchCriteria createOwnerCriteria(RetailStoreMemberRequest owner, IDRefine<RetailStoreMember> idRefine) {
        return new RefinedIdInCriteria(owner, OWNER_PROPERTY, idRefine);
    }
    

    
    public MemberWishlistRequest selectOwner(){
        return selectOwner(RetailStoreMemberRequest.newInstance().selectSelf());
    }

    public MemberWishlistRequest selectOwner(RetailStoreMemberRequest owner){
        selectParent(OWNER_PROPERTY, owner);
        return this;
    }
    

    public MemberWishlistRequest unselectOwner(){
        unselectParent(OWNER_PROPERTY);
        return this;
    }

  


  

    public MemberWishlistRequest hasMemberWishlistProduct() {
      return hasMemberWishlistProduct(MemberWishlistProductRequest.newInstance());
    }

    public MemberWishlistRequest hasMemberWishlistProduct(MemberWishlistProductRequest memberWishlistProduct) {
        return hasMemberWishlistProduct(memberWishlistProduct, memberWishlistProductList -> memberWishlistProductList.stream().map(MemberWishlistProduct::getOwner).map(MemberWishlist::getId).collect(Collectors.toSet()));
    }

    public MemberWishlistRequest hasMemberWishlistProduct(MemberWishlistProductRequest memberWishlistProduct, IDRefine<MemberWishlistProduct> idRefine) {
        memberWishlistProduct.select(MemberWishlistProduct.OWNER_PROPERTY);
        return addSearchCriteria(createMemberWishlistProductCriteria(memberWishlistProduct, idRefine));
    }

    public SearchCriteria createMemberWishlistProductCriteria(MemberWishlistProductRequest memberWishlistProduct, IDRefine<MemberWishlistProduct> idRefine){
       return new RefinedIdInCriteria(memberWishlistProduct, ID_PROPERTY, idRefine);
    }

    public MemberWishlistRequest selectMemberWishlistProductList(MemberWishlistProductRequest memberWishlistProduct) {
        selectChild(MemberWishlistProduct.OWNER_PROPERTY, memberWishlistProduct);
        return this;
    }

    public MemberWishlistRequest selectMemberWishlistProductList() {
        return selectMemberWishlistProductList(MemberWishlistProductRequest.newInstance().selectAll());
    }

    public MemberWishlistRequest unselectMemberWishlistProductList(){
        unselectChild(MemberWishlistProduct.OWNER_PROPERTY, MemberWishlistProduct.class);
        return this;
    }
  

   public MemberWishlistRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

