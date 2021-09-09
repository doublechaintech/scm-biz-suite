package com.doublechaintech.retailscm.leveltwodepartment;

import com.doublechaintech.retailscm.search.*;
import java.util.Date;
import com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartment;
import com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartment;
import com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartmentRequest;
import com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartmentRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartment.*;

public class LevelTwoDepartmentRequest extends BaseRequest<LevelTwoDepartment> {
    public static LevelTwoDepartmentRequest newInstance() {
        return new LevelTwoDepartmentRequest().selectId();
    }

    public String getInternalType() {
        return "LevelTwoDepartment";
    }

    public LevelTwoDepartmentRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public LevelTwoDepartmentRequest select(String... names) {
        super.select(names);
        return this;
    }

    public LevelTwoDepartmentRequest selectAll() {return this.selectId().selectBelongsTo().selectName().selectDescription().selectFounded().selectVersion();
    }

    public LevelTwoDepartmentRequest selectSelf() {return this.selectId().selectName().selectDescription().selectFounded().selectVersion();
    }

    public LevelTwoDepartmentRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public LevelTwoDepartmentRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static LevelTwoDepartmentRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public LevelTwoDepartmentRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public LevelTwoDepartmentRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public LevelTwoDepartmentRequest selectId(){
          return select(ID_PROPERTY);
      }

      public LevelTwoDepartmentRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public LevelTwoDepartmentRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public LevelTwoDepartmentRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public LevelTwoDepartmentRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public LevelTwoDepartmentRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public LevelTwoDepartmentRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public LevelTwoDepartmentRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public LevelTwoDepartmentRequest filterByDescription(String description) {
          
          if (description == null) {
              return this;
          }
          
          return filterByDescription(QueryOperator.EQUAL, description);
      }
    

      public LevelTwoDepartmentRequest filterByDescription(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public LevelTwoDepartmentRequest selectDescription(){
          return select(DESCRIPTION_PROPERTY);
      }

      public LevelTwoDepartmentRequest unselectDescription(){
          return unselect(DESCRIPTION_PROPERTY);
      }

      public SearchCriteria getDescriptionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
      }

      public LevelTwoDepartmentRequest orderByDescription(boolean asc){
          addOrderBy(DESCRIPTION_PROPERTY, asc);
          return this;
      }
   
      public LevelTwoDepartmentRequest filterByFounded(Date founded) {
          
          if (founded == null) {
              return this;
          }
          
          return filterByFounded(QueryOperator.EQUAL, founded);
      }
    

      public LevelTwoDepartmentRequest filterByFounded(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getFoundedSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public LevelTwoDepartmentRequest selectFounded(){
          return select(FOUNDED_PROPERTY);
      }

      public LevelTwoDepartmentRequest unselectFounded(){
          return unselect(FOUNDED_PROPERTY);
      }

      public SearchCriteria getFoundedSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(FOUNDED_PROPERTY, pQueryOperator, parameters);
      }

      public LevelTwoDepartmentRequest orderByFounded(boolean asc){
          addOrderBy(FOUNDED_PROPERTY, asc);
          return this;
      }
   
      public LevelTwoDepartmentRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public LevelTwoDepartmentRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public LevelTwoDepartmentRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public LevelTwoDepartmentRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public LevelTwoDepartmentRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public LevelTwoDepartmentRequest filterByBelongsTo(LevelOneDepartmentRequest belongsTo){
        return filterByBelongsTo(belongsTo, belongsToList -> belongsToList.stream().map(LevelOneDepartment::getId).collect(Collectors.toSet()));
    }

    public LevelTwoDepartmentRequest filterByBelongsTo(LevelOneDepartmentRequest belongsTo, IDRefine<LevelOneDepartment> idRefine) {
        return addSearchCriteria(createBelongsToCriteria(belongsTo, idRefine));
    }

    public SearchCriteria createBelongsToCriteria(LevelOneDepartmentRequest belongsTo, IDRefine<LevelOneDepartment> idRefine) {
        return new RefinedIdInCriteria(belongsTo, BELONGS_TO_PROPERTY, idRefine);
    }
    

    
    public LevelTwoDepartmentRequest selectBelongsTo(){
        return selectBelongsTo(LevelOneDepartmentRequest.newInstance().selectSelf());
    }

    public LevelTwoDepartmentRequest selectBelongsTo(LevelOneDepartmentRequest belongsTo){
        selectParent(BELONGS_TO_PROPERTY, belongsTo);
        return this;
    }
    

    public LevelTwoDepartmentRequest unselectBelongsTo(){
        unselectParent(BELONGS_TO_PROPERTY);
        return this;
    }

  


  

    public LevelTwoDepartmentRequest hasLevelThreeDepartment() {
      return hasLevelThreeDepartment(LevelThreeDepartmentRequest.newInstance());
    }

    public LevelTwoDepartmentRequest hasLevelThreeDepartment(LevelThreeDepartmentRequest levelThreeDepartment) {
        return hasLevelThreeDepartment(levelThreeDepartment, levelThreeDepartmentList -> levelThreeDepartmentList.stream().map(LevelThreeDepartment::getBelongsTo).map(LevelTwoDepartment::getId).collect(Collectors.toSet()));
    }

    public LevelTwoDepartmentRequest hasLevelThreeDepartment(LevelThreeDepartmentRequest levelThreeDepartment, IDRefine<LevelThreeDepartment> idRefine) {
        levelThreeDepartment.select(LevelThreeDepartment.BELONGS_TO_PROPERTY);
        return addSearchCriteria(createLevelThreeDepartmentCriteria(levelThreeDepartment, idRefine));
    }

    public SearchCriteria createLevelThreeDepartmentCriteria(LevelThreeDepartmentRequest levelThreeDepartment, IDRefine<LevelThreeDepartment> idRefine){
       return new RefinedIdInCriteria(levelThreeDepartment, ID_PROPERTY, idRefine);
    }

    public LevelTwoDepartmentRequest selectLevelThreeDepartmentList(LevelThreeDepartmentRequest levelThreeDepartment) {
        selectChild(LevelThreeDepartment.BELONGS_TO_PROPERTY, levelThreeDepartment);
        return this;
    }

    public LevelTwoDepartmentRequest selectLevelThreeDepartmentList() {
        return selectLevelThreeDepartmentList(LevelThreeDepartmentRequest.newInstance().selectAll());
    }

    public LevelTwoDepartmentRequest unselectLevelThreeDepartmentList(){
        unselectChild(LevelThreeDepartment.BELONGS_TO_PROPERTY, LevelThreeDepartment.class);
        return this;
    }
  

   public LevelTwoDepartmentRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

