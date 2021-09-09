package com.doublechaintech.retailscm.levelthreecategory;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategory;
import com.doublechaintech.retailscm.product.Product;
import com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategoryRequest;
import com.doublechaintech.retailscm.product.ProductRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategory.*;

public class LevelThreeCategoryRequest extends BaseRequest<LevelThreeCategory> {
    public static LevelThreeCategoryRequest newInstance() {
        return new LevelThreeCategoryRequest().selectId();
    }

    public String getInternalType() {
        return "LevelThreeCategory";
    }

    public LevelThreeCategoryRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public LevelThreeCategoryRequest select(String... names) {
        super.select(names);
        return this;
    }

    public LevelThreeCategoryRequest selectAll() {return this.selectId().selectParentCategory().selectName().selectVersion();
    }

    public LevelThreeCategoryRequest selectSelf() {return this.selectId().selectName().selectVersion();
    }

    public LevelThreeCategoryRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public LevelThreeCategoryRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static LevelThreeCategoryRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public LevelThreeCategoryRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public LevelThreeCategoryRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public LevelThreeCategoryRequest selectId(){
          return select(ID_PROPERTY);
      }

      public LevelThreeCategoryRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public LevelThreeCategoryRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public LevelThreeCategoryRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public LevelThreeCategoryRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public LevelThreeCategoryRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public LevelThreeCategoryRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public LevelThreeCategoryRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public LevelThreeCategoryRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public LevelThreeCategoryRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public LevelThreeCategoryRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public LevelThreeCategoryRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public LevelThreeCategoryRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public LevelThreeCategoryRequest filterByParentCategory(LevelTwoCategoryRequest parentCategory){
        return filterByParentCategory(parentCategory, parentCategoryList -> parentCategoryList.stream().map(LevelTwoCategory::getId).collect(Collectors.toSet()));
    }

    public LevelThreeCategoryRequest filterByParentCategory(LevelTwoCategoryRequest parentCategory, IDRefine<LevelTwoCategory> idRefine) {
        return addSearchCriteria(createParentCategoryCriteria(parentCategory, idRefine));
    }

    public SearchCriteria createParentCategoryCriteria(LevelTwoCategoryRequest parentCategory, IDRefine<LevelTwoCategory> idRefine) {
        return new RefinedIdInCriteria(parentCategory, PARENT_CATEGORY_PROPERTY, idRefine);
    }
    

    
    public LevelThreeCategoryRequest selectParentCategory(){
        return selectParentCategory(LevelTwoCategoryRequest.newInstance().selectSelf());
    }

    public LevelThreeCategoryRequest selectParentCategory(LevelTwoCategoryRequest parentCategory){
        selectParent(PARENT_CATEGORY_PROPERTY, parentCategory);
        return this;
    }
    

    public LevelThreeCategoryRequest unselectParentCategory(){
        unselectParent(PARENT_CATEGORY_PROPERTY);
        return this;
    }

  


  

    public LevelThreeCategoryRequest hasProduct() {
      return hasProduct(ProductRequest.newInstance());
    }

    public LevelThreeCategoryRequest hasProduct(ProductRequest product) {
        return hasProduct(product, productList -> productList.stream().map(Product::getParentCategory).map(LevelThreeCategory::getId).collect(Collectors.toSet()));
    }

    public LevelThreeCategoryRequest hasProduct(ProductRequest product, IDRefine<Product> idRefine) {
        product.select(Product.PARENT_CATEGORY_PROPERTY);
        return addSearchCriteria(createProductCriteria(product, idRefine));
    }

    public SearchCriteria createProductCriteria(ProductRequest product, IDRefine<Product> idRefine){
       return new RefinedIdInCriteria(product, ID_PROPERTY, idRefine);
    }

    public LevelThreeCategoryRequest selectProductList(ProductRequest product) {
        selectChild(Product.PARENT_CATEGORY_PROPERTY, product);
        return this;
    }

    public LevelThreeCategoryRequest selectProductList() {
        return selectProductList(ProductRequest.newInstance().selectAll());
    }

    public LevelThreeCategoryRequest unselectProductList(){
        unselectChild(Product.PARENT_CATEGORY_PROPERTY, Product.class);
        return this;
    }
  

   public LevelThreeCategoryRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

