package com.doublechaintech.retailscm.catalog;

import com.doublechaintech.retailscm.search.*;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.levelonecategory.LevelOneCategory;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.levelonecategory.LevelOneCategoryRequest;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.catalog.Catalog.*;

public class CatalogRequest extends BaseRequest<Catalog> {
    public static CatalogRequest newInstance() {
        return new CatalogRequest().selectId();
    }

    public String getInternalType() {
        return "Catalog";
    }

    public CatalogRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public CatalogRequest select(String... names) {
        super.select(names);
        return this;
    }

    public CatalogRequest selectAll() {return this.selectId().selectName().selectOwner().selectSubCount().selectAmount().selectVersion();
    }

    public CatalogRequest selectSelf() {return this.selectId().selectName().selectSubCount().selectAmount().selectVersion();
    }

    public CatalogRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public CatalogRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static CatalogRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public CatalogRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public CatalogRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public CatalogRequest selectId(){
          return select(ID_PROPERTY);
      }

      public CatalogRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public CatalogRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public CatalogRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public CatalogRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public CatalogRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public CatalogRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public CatalogRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public CatalogRequest filterBySubCount(int subCount) {
          
          return filterBySubCount(QueryOperator.EQUAL, subCount);
      }
    

      public CatalogRequest filterBySubCount(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getSubCountSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public CatalogRequest selectSubCount(){
          return select(SUB_COUNT_PROPERTY);
      }

      public CatalogRequest unselectSubCount(){
          return unselect(SUB_COUNT_PROPERTY);
      }

      public SearchCriteria getSubCountSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(SUB_COUNT_PROPERTY, pQueryOperator, parameters);
      }

      public CatalogRequest orderBySubCount(boolean asc){
          addOrderBy(SUB_COUNT_PROPERTY, asc);
          return this;
      }
   
      public CatalogRequest filterByAmount(BigDecimal amount) {
          
          if (amount == null) {
              return this;
          }
          
          return filterByAmount(QueryOperator.EQUAL, amount);
      }
    

      public CatalogRequest filterByAmount(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getAmountSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public CatalogRequest selectAmount(){
          return select(AMOUNT_PROPERTY);
      }

      public CatalogRequest unselectAmount(){
          return unselect(AMOUNT_PROPERTY);
      }

      public SearchCriteria getAmountSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(AMOUNT_PROPERTY, pQueryOperator, parameters);
      }

      public CatalogRequest orderByAmount(boolean asc){
          addOrderBy(AMOUNT_PROPERTY, asc);
          return this;
      }
   
      public CatalogRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public CatalogRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public CatalogRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public CatalogRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public CatalogRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public CatalogRequest filterByOwner(RetailStoreCountryCenterRequest owner){
        return filterByOwner(owner, ownerList -> ownerList.stream().map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public CatalogRequest filterByOwner(RetailStoreCountryCenterRequest owner, IDRefine<RetailStoreCountryCenter> idRefine) {
        return addSearchCriteria(createOwnerCriteria(owner, idRefine));
    }

    public SearchCriteria createOwnerCriteria(RetailStoreCountryCenterRequest owner, IDRefine<RetailStoreCountryCenter> idRefine) {
        return new RefinedIdInCriteria(owner, OWNER_PROPERTY, idRefine);
    }
    

    
    public CatalogRequest selectOwner(){
        return selectOwner(RetailStoreCountryCenterRequest.newInstance().selectSelf());
    }

    public CatalogRequest selectOwner(RetailStoreCountryCenterRequest owner){
        selectParent(OWNER_PROPERTY, owner);
        return this;
    }
    

    public CatalogRequest unselectOwner(){
        unselectParent(OWNER_PROPERTY);
        return this;
    }

  


  

    public CatalogRequest hasLevelOneCategory() {
      return hasLevelOneCategory(LevelOneCategoryRequest.newInstance());
    }

    public CatalogRequest hasLevelOneCategory(LevelOneCategoryRequest levelOneCategory) {
        return hasLevelOneCategory(levelOneCategory, levelOneCategoryList -> levelOneCategoryList.stream().map(LevelOneCategory::getCatalog).map(Catalog::getId).collect(Collectors.toSet()));
    }

    public CatalogRequest hasLevelOneCategory(LevelOneCategoryRequest levelOneCategory, IDRefine<LevelOneCategory> idRefine) {
        levelOneCategory.select(LevelOneCategory.CATALOG_PROPERTY);
        return addSearchCriteria(createLevelOneCategoryCriteria(levelOneCategory, idRefine));
    }

    public SearchCriteria createLevelOneCategoryCriteria(LevelOneCategoryRequest levelOneCategory, IDRefine<LevelOneCategory> idRefine){
       return new RefinedIdInCriteria(levelOneCategory, ID_PROPERTY, idRefine);
    }

    public CatalogRequest selectLevelOneCategoryList(LevelOneCategoryRequest levelOneCategory) {
        selectChild(LevelOneCategory.CATALOG_PROPERTY, levelOneCategory);
        return this;
    }

    public CatalogRequest selectLevelOneCategoryList() {
        return selectLevelOneCategoryList(LevelOneCategoryRequest.newInstance().selectAll());
    }

    public CatalogRequest unselectLevelOneCategoryList(){
        unselectChild(LevelOneCategory.CATALOG_PROPERTY, LevelOneCategory.class);
        return this;
    }
  

   public CatalogRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

