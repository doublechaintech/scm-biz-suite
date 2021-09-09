package com.doublechaintech.retailscm.levelonecategory;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.catalog.Catalog;
import com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategory;
import com.doublechaintech.retailscm.catalog.CatalogRequest;
import com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategoryRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.levelonecategory.LevelOneCategory.*;

public class LevelOneCategoryRequest extends BaseRequest<LevelOneCategory> {
    public static LevelOneCategoryRequest newInstance() {
        return new LevelOneCategoryRequest().selectId();
    }

    public String getInternalType() {
        return "LevelOneCategory";
    }

    public LevelOneCategoryRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public LevelOneCategoryRequest select(String... names) {
        super.select(names);
        return this;
    }

    public LevelOneCategoryRequest selectAll() {return this.selectId().selectCatalog().selectName().selectVersion();
    }

    public LevelOneCategoryRequest selectSelf() {return this.selectId().selectName().selectVersion();
    }

    public LevelOneCategoryRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public LevelOneCategoryRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static LevelOneCategoryRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public LevelOneCategoryRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public LevelOneCategoryRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public LevelOneCategoryRequest selectId(){
          return select(ID_PROPERTY);
      }

      public LevelOneCategoryRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public LevelOneCategoryRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public LevelOneCategoryRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public LevelOneCategoryRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public LevelOneCategoryRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public LevelOneCategoryRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public LevelOneCategoryRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public LevelOneCategoryRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public LevelOneCategoryRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public LevelOneCategoryRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public LevelOneCategoryRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public LevelOneCategoryRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public LevelOneCategoryRequest filterByCatalog(CatalogRequest catalog){
        return filterByCatalog(catalog, catalogList -> catalogList.stream().map(Catalog::getId).collect(Collectors.toSet()));
    }

    public LevelOneCategoryRequest filterByCatalog(CatalogRequest catalog, IDRefine<Catalog> idRefine) {
        return addSearchCriteria(createCatalogCriteria(catalog, idRefine));
    }

    public SearchCriteria createCatalogCriteria(CatalogRequest catalog, IDRefine<Catalog> idRefine) {
        return new RefinedIdInCriteria(catalog, CATALOG_PROPERTY, idRefine);
    }
    

    
    public LevelOneCategoryRequest selectCatalog(){
        return selectCatalog(CatalogRequest.newInstance().selectSelf());
    }

    public LevelOneCategoryRequest selectCatalog(CatalogRequest catalog){
        selectParent(CATALOG_PROPERTY, catalog);
        return this;
    }
    

    public LevelOneCategoryRequest unselectCatalog(){
        unselectParent(CATALOG_PROPERTY);
        return this;
    }

  


  

    public LevelOneCategoryRequest hasLevelTwoCategory() {
      return hasLevelTwoCategory(LevelTwoCategoryRequest.newInstance());
    }

    public LevelOneCategoryRequest hasLevelTwoCategory(LevelTwoCategoryRequest levelTwoCategory) {
        return hasLevelTwoCategory(levelTwoCategory, levelTwoCategoryList -> levelTwoCategoryList.stream().map(LevelTwoCategory::getParentCategory).map(LevelOneCategory::getId).collect(Collectors.toSet()));
    }

    public LevelOneCategoryRequest hasLevelTwoCategory(LevelTwoCategoryRequest levelTwoCategory, IDRefine<LevelTwoCategory> idRefine) {
        levelTwoCategory.select(LevelTwoCategory.PARENT_CATEGORY_PROPERTY);
        return addSearchCriteria(createLevelTwoCategoryCriteria(levelTwoCategory, idRefine));
    }

    public SearchCriteria createLevelTwoCategoryCriteria(LevelTwoCategoryRequest levelTwoCategory, IDRefine<LevelTwoCategory> idRefine){
       return new RefinedIdInCriteria(levelTwoCategory, ID_PROPERTY, idRefine);
    }

    public LevelOneCategoryRequest selectLevelTwoCategoryList(LevelTwoCategoryRequest levelTwoCategory) {
        selectChild(LevelTwoCategory.PARENT_CATEGORY_PROPERTY, levelTwoCategory);
        return this;
    }

    public LevelOneCategoryRequest selectLevelTwoCategoryList() {
        return selectLevelTwoCategoryList(LevelTwoCategoryRequest.newInstance().selectAll());
    }

    public LevelOneCategoryRequest unselectLevelTwoCategoryList(){
        unselectChild(LevelTwoCategory.PARENT_CATEGORY_PROPERTY, LevelTwoCategory.class);
        return this;
    }
  

   public LevelOneCategoryRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

