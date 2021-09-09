package com.doublechaintech.retailscm.levelonedepartment;

import com.doublechaintech.retailscm.search.*;
import java.util.Date;
import com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartment;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartmentRequest;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartment.*;

public class LevelOneDepartmentRequest extends BaseRequest<LevelOneDepartment> {
    public static LevelOneDepartmentRequest newInstance() {
        return new LevelOneDepartmentRequest().selectId();
    }

    public String getInternalType() {
        return "LevelOneDepartment";
    }

    public LevelOneDepartmentRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public LevelOneDepartmentRequest select(String... names) {
        super.select(names);
        return this;
    }

    public LevelOneDepartmentRequest selectAll() {return this.selectId().selectBelongsTo().selectName().selectDescription().selectManager().selectFounded().selectVersion();
    }

    public LevelOneDepartmentRequest selectSelf() {return this.selectId().selectName().selectDescription().selectManager().selectFounded().selectVersion();
    }

    public LevelOneDepartmentRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public LevelOneDepartmentRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static LevelOneDepartmentRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public LevelOneDepartmentRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public LevelOneDepartmentRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public LevelOneDepartmentRequest selectId(){
          return select(ID_PROPERTY);
      }

      public LevelOneDepartmentRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public LevelOneDepartmentRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public LevelOneDepartmentRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public LevelOneDepartmentRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public LevelOneDepartmentRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public LevelOneDepartmentRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public LevelOneDepartmentRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public LevelOneDepartmentRequest filterByDescription(String description) {
          
          if (description == null) {
              return this;
          }
          
          return filterByDescription(QueryOperator.EQUAL, description);
      }
    

      public LevelOneDepartmentRequest filterByDescription(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public LevelOneDepartmentRequest selectDescription(){
          return select(DESCRIPTION_PROPERTY);
      }

      public LevelOneDepartmentRequest unselectDescription(){
          return unselect(DESCRIPTION_PROPERTY);
      }

      public SearchCriteria getDescriptionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
      }

      public LevelOneDepartmentRequest orderByDescription(boolean asc){
          addOrderBy(DESCRIPTION_PROPERTY, asc);
          return this;
      }
   
      public LevelOneDepartmentRequest filterByManager(String manager) {
          
          if (manager == null) {
              return this;
          }
          
          return filterByManager(QueryOperator.EQUAL, manager);
      }
    

      public LevelOneDepartmentRequest filterByManager(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getManagerSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public LevelOneDepartmentRequest selectManager(){
          return select(MANAGER_PROPERTY);
      }

      public LevelOneDepartmentRequest unselectManager(){
          return unselect(MANAGER_PROPERTY);
      }

      public SearchCriteria getManagerSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(MANAGER_PROPERTY, pQueryOperator, parameters);
      }

      public LevelOneDepartmentRequest orderByManager(boolean asc){
          addOrderBy(MANAGER_PROPERTY, asc);
          return this;
      }
   
      public LevelOneDepartmentRequest filterByFounded(Date founded) {
          
          if (founded == null) {
              return this;
          }
          
          return filterByFounded(QueryOperator.EQUAL, founded);
      }
    

      public LevelOneDepartmentRequest filterByFounded(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getFoundedSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public LevelOneDepartmentRequest selectFounded(){
          return select(FOUNDED_PROPERTY);
      }

      public LevelOneDepartmentRequest unselectFounded(){
          return unselect(FOUNDED_PROPERTY);
      }

      public SearchCriteria getFoundedSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(FOUNDED_PROPERTY, pQueryOperator, parameters);
      }

      public LevelOneDepartmentRequest orderByFounded(boolean asc){
          addOrderBy(FOUNDED_PROPERTY, asc);
          return this;
      }
   
      public LevelOneDepartmentRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public LevelOneDepartmentRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public LevelOneDepartmentRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public LevelOneDepartmentRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public LevelOneDepartmentRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public LevelOneDepartmentRequest filterByBelongsTo(RetailStoreCountryCenterRequest belongsTo){
        return filterByBelongsTo(belongsTo, belongsToList -> belongsToList.stream().map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public LevelOneDepartmentRequest filterByBelongsTo(RetailStoreCountryCenterRequest belongsTo, IDRefine<RetailStoreCountryCenter> idRefine) {
        return addSearchCriteria(createBelongsToCriteria(belongsTo, idRefine));
    }

    public SearchCriteria createBelongsToCriteria(RetailStoreCountryCenterRequest belongsTo, IDRefine<RetailStoreCountryCenter> idRefine) {
        return new RefinedIdInCriteria(belongsTo, BELONGS_TO_PROPERTY, idRefine);
    }
    

    
    public LevelOneDepartmentRequest selectBelongsTo(){
        return selectBelongsTo(RetailStoreCountryCenterRequest.newInstance().selectSelf());
    }

    public LevelOneDepartmentRequest selectBelongsTo(RetailStoreCountryCenterRequest belongsTo){
        selectParent(BELONGS_TO_PROPERTY, belongsTo);
        return this;
    }
    

    public LevelOneDepartmentRequest unselectBelongsTo(){
        unselectParent(BELONGS_TO_PROPERTY);
        return this;
    }

  


  

    public LevelOneDepartmentRequest hasLevelTwoDepartment() {
      return hasLevelTwoDepartment(LevelTwoDepartmentRequest.newInstance());
    }

    public LevelOneDepartmentRequest hasLevelTwoDepartment(LevelTwoDepartmentRequest levelTwoDepartment) {
        return hasLevelTwoDepartment(levelTwoDepartment, levelTwoDepartmentList -> levelTwoDepartmentList.stream().map(LevelTwoDepartment::getBelongsTo).map(LevelOneDepartment::getId).collect(Collectors.toSet()));
    }

    public LevelOneDepartmentRequest hasLevelTwoDepartment(LevelTwoDepartmentRequest levelTwoDepartment, IDRefine<LevelTwoDepartment> idRefine) {
        levelTwoDepartment.select(LevelTwoDepartment.BELONGS_TO_PROPERTY);
        return addSearchCriteria(createLevelTwoDepartmentCriteria(levelTwoDepartment, idRefine));
    }

    public SearchCriteria createLevelTwoDepartmentCriteria(LevelTwoDepartmentRequest levelTwoDepartment, IDRefine<LevelTwoDepartment> idRefine){
       return new RefinedIdInCriteria(levelTwoDepartment, ID_PROPERTY, idRefine);
    }

    public LevelOneDepartmentRequest selectLevelTwoDepartmentList(LevelTwoDepartmentRequest levelTwoDepartment) {
        selectChild(LevelTwoDepartment.BELONGS_TO_PROPERTY, levelTwoDepartment);
        return this;
    }

    public LevelOneDepartmentRequest selectLevelTwoDepartmentList() {
        return selectLevelTwoDepartmentList(LevelTwoDepartmentRequest.newInstance().selectAll());
    }

    public LevelOneDepartmentRequest unselectLevelTwoDepartmentList(){
        unselectChild(LevelTwoDepartment.BELONGS_TO_PROPERTY, LevelTwoDepartment.class);
        return this;
    }
  

   public LevelOneDepartmentRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

