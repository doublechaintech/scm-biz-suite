package com.doublechaintech.retailscm.product;

import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategory;
import com.doublechaintech.retailscm.sku.Sku;
import com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategoryRequest;
import com.doublechaintech.retailscm.sku.SkuRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.product.Product.*;

public class ProductRequest extends BaseRequest<Product> {
    public static ProductRequest newInstance() {
        return new ProductRequest().selectId();
    }

    public String getInternalType() {
        return "Product";
    }

    public ProductRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public ProductRequest select(String... names) {
        super.select(names);
        return this;
    }

    public ProductRequest selectAll() {return this.selectId().selectName().selectParentCategory().selectOrigin().selectRemark().selectBrand().selectPicture().selectLastUpdateTime().selectVersion();
    }

    public ProductRequest selectSelf() {return this.selectId().selectName().selectOrigin().selectRemark().selectBrand().selectPicture().selectLastUpdateTime().selectVersion();
    }

    public ProductRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public ProductRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static ProductRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public ProductRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public ProductRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ProductRequest selectId(){
          return select(ID_PROPERTY);
      }

      public ProductRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public ProductRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public ProductRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public ProductRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ProductRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public ProductRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public ProductRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public ProductRequest filterByOrigin(String origin) {
          
          if (origin == null) {
              return this;
          }
          
          return filterByOrigin(QueryOperator.EQUAL, origin);
      }
    

      public ProductRequest filterByOrigin(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getOriginSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ProductRequest selectOrigin(){
          return select(ORIGIN_PROPERTY);
      }

      public ProductRequest unselectOrigin(){
          return unselect(ORIGIN_PROPERTY);
      }

      public SearchCriteria getOriginSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ORIGIN_PROPERTY, pQueryOperator, parameters);
      }

      public ProductRequest orderByOrigin(boolean asc){
          addOrderBy(ORIGIN_PROPERTY, asc);
          return this;
      }
   
      public ProductRequest filterByRemark(String remark) {
          
          if (remark == null) {
              return this;
          }
          
          return filterByRemark(QueryOperator.EQUAL, remark);
      }
    

      public ProductRequest filterByRemark(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getRemarkSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ProductRequest selectRemark(){
          return select(REMARK_PROPERTY);
      }

      public ProductRequest unselectRemark(){
          return unselect(REMARK_PROPERTY);
      }

      public SearchCriteria getRemarkSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(REMARK_PROPERTY, pQueryOperator, parameters);
      }

      public ProductRequest orderByRemark(boolean asc){
          addOrderBy(REMARK_PROPERTY, asc);
          return this;
      }
   
      public ProductRequest filterByBrand(String brand) {
          
          if (brand == null) {
              return this;
          }
          
          return filterByBrand(QueryOperator.EQUAL, brand);
      }
    

      public ProductRequest filterByBrand(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getBrandSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ProductRequest selectBrand(){
          return select(BRAND_PROPERTY);
      }

      public ProductRequest unselectBrand(){
          return unselect(BRAND_PROPERTY);
      }

      public SearchCriteria getBrandSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(BRAND_PROPERTY, pQueryOperator, parameters);
      }

      public ProductRequest orderByBrand(boolean asc){
          addOrderBy(BRAND_PROPERTY, asc);
          return this;
      }
   
      public ProductRequest filterByPicture(String picture) {
          
          if (picture == null) {
              return this;
          }
          
          return filterByPicture(QueryOperator.EQUAL, picture);
      }
    

      public ProductRequest filterByPicture(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getPictureSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ProductRequest selectPicture(){
          return select(PICTURE_PROPERTY);
      }

      public ProductRequest unselectPicture(){
          return unselect(PICTURE_PROPERTY);
      }

      public SearchCriteria getPictureSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(PICTURE_PROPERTY, pQueryOperator, parameters);
      }

      public ProductRequest orderByPicture(boolean asc){
          addOrderBy(PICTURE_PROPERTY, asc);
          return this;
      }
   
      public ProductRequest filterByLastUpdateTime(DateTime lastUpdateTime) {
          
          if (lastUpdateTime == null) {
              return this;
          }
          
          return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
      }
    

      public ProductRequest filterByLastUpdateTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ProductRequest selectLastUpdateTime(){
          return select(LAST_UPDATE_TIME_PROPERTY);
      }

      public ProductRequest unselectLastUpdateTime(){
          return unselect(LAST_UPDATE_TIME_PROPERTY);
      }

      public SearchCriteria getLastUpdateTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public ProductRequest orderByLastUpdateTime(boolean asc){
          addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
          return this;
      }
   
      public ProductRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public ProductRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ProductRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public ProductRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public ProductRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public ProductRequest filterByParentCategory(LevelThreeCategoryRequest parentCategory){
        return filterByParentCategory(parentCategory, parentCategoryList -> parentCategoryList.stream().map(LevelThreeCategory::getId).collect(Collectors.toSet()));
    }

    public ProductRequest filterByParentCategory(LevelThreeCategoryRequest parentCategory, IDRefine<LevelThreeCategory> idRefine) {
        return addSearchCriteria(createParentCategoryCriteria(parentCategory, idRefine));
    }

    public SearchCriteria createParentCategoryCriteria(LevelThreeCategoryRequest parentCategory, IDRefine<LevelThreeCategory> idRefine) {
        return new RefinedIdInCriteria(parentCategory, PARENT_CATEGORY_PROPERTY, idRefine);
    }
    

    
    public ProductRequest selectParentCategory(){
        return selectParentCategory(LevelThreeCategoryRequest.newInstance().selectSelf());
    }

    public ProductRequest selectParentCategory(LevelThreeCategoryRequest parentCategory){
        selectParent(PARENT_CATEGORY_PROPERTY, parentCategory);
        return this;
    }
    

    public ProductRequest unselectParentCategory(){
        unselectParent(PARENT_CATEGORY_PROPERTY);
        return this;
    }

  


  

    public ProductRequest hasSku() {
      return hasSku(SkuRequest.newInstance());
    }

    public ProductRequest hasSku(SkuRequest sku) {
        return hasSku(sku, skuList -> skuList.stream().map(Sku::getProduct).map(Product::getId).collect(Collectors.toSet()));
    }

    public ProductRequest hasSku(SkuRequest sku, IDRefine<Sku> idRefine) {
        sku.select(Sku.PRODUCT_PROPERTY);
        return addSearchCriteria(createSkuCriteria(sku, idRefine));
    }

    public SearchCriteria createSkuCriteria(SkuRequest sku, IDRefine<Sku> idRefine){
       return new RefinedIdInCriteria(sku, ID_PROPERTY, idRefine);
    }

    public ProductRequest selectSkuList(SkuRequest sku) {
        selectChild(Sku.PRODUCT_PROPERTY, sku);
        return this;
    }

    public ProductRequest selectSkuList() {
        return selectSkuList(SkuRequest.newInstance().selectAll());
    }

    public ProductRequest unselectSkuList(){
        unselectChild(Sku.PRODUCT_PROPERTY, Sku.class);
        return this;
    }
  

   public ProductRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

