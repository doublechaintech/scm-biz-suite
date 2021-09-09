package com.doublechaintech.retailscm.leveltwocategory;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.levelonecategory.LevelOneCategory;
import com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategory;
import com.doublechaintech.retailscm.levelonecategory.LevelOneCategoryRequest;
import com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategoryRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategory.*;

public class LevelTwoCategoryRequest extends BaseRequest<LevelTwoCategory> {
    public static LevelTwoCategoryRequest newInstance() {
        return new LevelTwoCategoryRequest().selectId();
    }

    public String getInternalType() {
        return "LevelTwoCategory";
    }

    public LevelTwoCategoryRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public LevelTwoCategoryRequest select(String... names) {
        super.select(names);
        return this;
    }

    public LevelTwoCategoryRequest selectAll() {return this.selectId().selectParentCategory().selectName().selectVersion();
    }

    public LevelTwoCategoryRequest selectSelf() {return this.selectId().selectName().selectVersion();
    }

    public LevelTwoCategoryRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public LevelTwoCategoryRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static LevelTwoCategoryRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public LevelTwoCategoryRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public LevelTwoCategoryRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public LevelTwoCategoryRequest selectId(){
          return select(ID_PROPERTY);
      }

      public LevelTwoCategoryRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public LevelTwoCategoryRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public LevelTwoCategoryRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public LevelTwoCategoryRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public LevelTwoCategoryRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public LevelTwoCategoryRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public LevelTwoCategoryRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public LevelTwoCategoryRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public LevelTwoCategoryRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public LevelTwoCategoryRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public LevelTwoCategoryRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public LevelTwoCategoryRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public LevelTwoCategoryRequest filterByParentCategory(LevelOneCategoryRequest parentCategory){
        return filterByParentCategory(parentCategory, parentCategoryList -> parentCategoryList.stream().map(LevelOneCategory::getId).collect(Collectors.toSet()));
    }

    public LevelTwoCategoryRequest filterByParentCategory(LevelOneCategoryRequest parentCategory, IDRefine<LevelOneCategory> idRefine) {
        return addSearchCriteria(createParentCategoryCriteria(parentCategory, idRefine));
    }

    public SearchCriteria createParentCategoryCriteria(LevelOneCategoryRequest parentCategory, IDRefine<LevelOneCategory> idRefine) {
        return new RefinedIdInCriteria(parentCategory, PARENT_CATEGORY_PROPERTY, idRefine);
    }
    

    
    public LevelTwoCategoryRequest selectParentCategory(){
        return selectParentCategory(LevelOneCategoryRequest.newInstance().selectSelf());
    }

    public LevelTwoCategoryRequest selectParentCategory(LevelOneCategoryRequest parentCategory){
        selectParent(PARENT_CATEGORY_PROPERTY, parentCategory);
        return this;
    }
    

    public LevelTwoCategoryRequest unselectParentCategory(){
        unselectParent(PARENT_CATEGORY_PROPERTY);
        return this;
    }

  


  

    public LevelTwoCategoryRequest hasLevelThreeCategory() {
      return hasLevelThreeCategory(LevelThreeCategoryRequest.newInstance());
    }

    public LevelTwoCategoryRequest hasLevelThreeCategory(LevelThreeCategoryRequest levelThreeCategory) {
        return hasLevelThreeCategory(levelThreeCategory, levelThreeCategoryList -> levelThreeCategoryList.stream().map(LevelThreeCategory::getParentCategory).map(LevelTwoCategory::getId).collect(Collectors.toSet()));
    }

    public LevelTwoCategoryRequest hasLevelThreeCategory(LevelThreeCategoryRequest levelThreeCategory, IDRefine<LevelThreeCategory> idRefine) {
        levelThreeCategory.select(LevelThreeCategory.PARENT_CATEGORY_PROPERTY);
        return addSearchCriteria(createLevelThreeCategoryCriteria(levelThreeCategory, idRefine));
    }

    public SearchCriteria createLevelThreeCategoryCriteria(LevelThreeCategoryRequest levelThreeCategory, IDRefine<LevelThreeCategory> idRefine){
       return new RefinedIdInCriteria(levelThreeCategory, ID_PROPERTY, idRefine);
    }

    public LevelTwoCategoryRequest selectLevelThreeCategoryList(LevelThreeCategoryRequest levelThreeCategory) {
        selectChild(LevelThreeCategory.PARENT_CATEGORY_PROPERTY, levelThreeCategory);
        return this;
    }

    public LevelTwoCategoryRequest selectLevelThreeCategoryList() {
        return selectLevelThreeCategoryList(LevelThreeCategoryRequest.newInstance().selectAll());
    }

    public LevelTwoCategoryRequest unselectLevelThreeCategoryList(){
        unselectChild(LevelThreeCategory.PARENT_CATEGORY_PROPERTY, LevelThreeCategory.class);
        return this;
    }
  

   public LevelTwoCategoryRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

