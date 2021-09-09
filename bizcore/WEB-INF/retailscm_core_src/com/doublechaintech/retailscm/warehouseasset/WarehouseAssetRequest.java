package com.doublechaintech.retailscm.warehouseasset;

import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.warehouse.Warehouse;
import com.doublechaintech.retailscm.warehouse.WarehouseRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.warehouseasset.WarehouseAsset.*;

public class WarehouseAssetRequest extends BaseRequest<WarehouseAsset> {
    public static WarehouseAssetRequest newInstance() {
        return new WarehouseAssetRequest().selectId();
    }

    public String getInternalType() {
        return "WarehouseAsset";
    }

    public WarehouseAssetRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public WarehouseAssetRequest select(String... names) {
        super.select(names);
        return this;
    }

    public WarehouseAssetRequest selectAll() {return this.selectId().selectName().selectPosition().selectOwner().selectLastUpdateTime().selectVersion();
    }

    public WarehouseAssetRequest selectSelf() {return this.selectId().selectName().selectPosition().selectLastUpdateTime().selectVersion();
    }

    public WarehouseAssetRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public WarehouseAssetRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static WarehouseAssetRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public WarehouseAssetRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public WarehouseAssetRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public WarehouseAssetRequest selectId(){
          return select(ID_PROPERTY);
      }

      public WarehouseAssetRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public WarehouseAssetRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public WarehouseAssetRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public WarehouseAssetRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public WarehouseAssetRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public WarehouseAssetRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public WarehouseAssetRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public WarehouseAssetRequest filterByPosition(String position) {
          
          if (position == null) {
              return this;
          }
          
          return filterByPosition(QueryOperator.EQUAL, position);
      }
    

      public WarehouseAssetRequest filterByPosition(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getPositionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public WarehouseAssetRequest selectPosition(){
          return select(POSITION_PROPERTY);
      }

      public WarehouseAssetRequest unselectPosition(){
          return unselect(POSITION_PROPERTY);
      }

      public SearchCriteria getPositionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(POSITION_PROPERTY, pQueryOperator, parameters);
      }

      public WarehouseAssetRequest orderByPosition(boolean asc){
          addOrderBy(POSITION_PROPERTY, asc);
          return this;
      }
   
      public WarehouseAssetRequest filterByLastUpdateTime(DateTime lastUpdateTime) {
          
          if (lastUpdateTime == null) {
              return this;
          }
          
          return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
      }
    

      public WarehouseAssetRequest filterByLastUpdateTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public WarehouseAssetRequest selectLastUpdateTime(){
          return select(LAST_UPDATE_TIME_PROPERTY);
      }

      public WarehouseAssetRequest unselectLastUpdateTime(){
          return unselect(LAST_UPDATE_TIME_PROPERTY);
      }

      public SearchCriteria getLastUpdateTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public WarehouseAssetRequest orderByLastUpdateTime(boolean asc){
          addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
          return this;
      }
   
      public WarehouseAssetRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public WarehouseAssetRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public WarehouseAssetRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public WarehouseAssetRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public WarehouseAssetRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public WarehouseAssetRequest filterByOwner(WarehouseRequest owner){
        return filterByOwner(owner, ownerList -> ownerList.stream().map(Warehouse::getId).collect(Collectors.toSet()));
    }

    public WarehouseAssetRequest filterByOwner(WarehouseRequest owner, IDRefine<Warehouse> idRefine) {
        return addSearchCriteria(createOwnerCriteria(owner, idRefine));
    }

    public SearchCriteria createOwnerCriteria(WarehouseRequest owner, IDRefine<Warehouse> idRefine) {
        return new RefinedIdInCriteria(owner, OWNER_PROPERTY, idRefine);
    }
    

    
    public WarehouseAssetRequest selectOwner(){
        return selectOwner(WarehouseRequest.newInstance().selectSelf());
    }

    public WarehouseAssetRequest selectOwner(WarehouseRequest owner){
        selectParent(OWNER_PROPERTY, owner);
        return this;
    }
    

    public WarehouseAssetRequest unselectOwner(){
        unselectParent(OWNER_PROPERTY);
        return this;
    }

  


  

   public WarehouseAssetRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

