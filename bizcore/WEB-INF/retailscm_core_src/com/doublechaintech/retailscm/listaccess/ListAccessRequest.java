package com.doublechaintech.retailscm.listaccess;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.userapp.UserAppRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.listaccess.ListAccess.*;

public class ListAccessRequest extends BaseRequest<ListAccess> {
    public static ListAccessRequest newInstance() {
        return new ListAccessRequest().selectId();
    }

    public String getInternalType() {
        return "ListAccess";
    }

    public ListAccessRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public ListAccessRequest select(String... names) {
        super.select(names);
        return this;
    }

    public ListAccessRequest selectAll() {return this.selectId().selectName().selectInternalName().selectReadPermission().selectCreatePermission().selectDeletePermission().selectUpdatePermission().selectExecutionPermission().selectApp().selectVersion();
    }

    public ListAccessRequest selectSelf() {return this.selectId().selectName().selectInternalName().selectReadPermission().selectCreatePermission().selectDeletePermission().selectUpdatePermission().selectExecutionPermission().selectVersion();
    }

    public ListAccessRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public ListAccessRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static ListAccessRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public ListAccessRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public ListAccessRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ListAccessRequest selectId(){
          return select(ID_PROPERTY);
      }

      public ListAccessRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public ListAccessRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public ListAccessRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public ListAccessRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ListAccessRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public ListAccessRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public ListAccessRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public ListAccessRequest filterByInternalName(String internalName) {
          
          if (internalName == null) {
              return this;
          }
          
          return filterByInternalName(QueryOperator.EQUAL, internalName);
      }
    

      public ListAccessRequest filterByInternalName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getInternalNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ListAccessRequest selectInternalName(){
          return select(INTERNAL_NAME_PROPERTY);
      }

      public ListAccessRequest unselectInternalName(){
          return unselect(INTERNAL_NAME_PROPERTY);
      }

      public SearchCriteria getInternalNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(INTERNAL_NAME_PROPERTY, pQueryOperator, parameters);
      }

      public ListAccessRequest orderByInternalName(boolean asc){
          addOrderBy(INTERNAL_NAME_PROPERTY, asc);
          return this;
      }
   
      public ListAccessRequest filterByReadPermission(boolean readPermission) {
          
          return filterByReadPermission(QueryOperator.EQUAL, readPermission);
      }
    

      public ListAccessRequest filterByReadPermission(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getReadPermissionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ListAccessRequest selectReadPermission(){
          return select(READ_PERMISSION_PROPERTY);
      }

      public ListAccessRequest unselectReadPermission(){
          return unselect(READ_PERMISSION_PROPERTY);
      }

      public SearchCriteria getReadPermissionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(READ_PERMISSION_PROPERTY, pQueryOperator, parameters);
      }

      public ListAccessRequest orderByReadPermission(boolean asc){
          addOrderBy(READ_PERMISSION_PROPERTY, asc);
          return this;
      }
   
      public ListAccessRequest filterByCreatePermission(boolean createPermission) {
          
          return filterByCreatePermission(QueryOperator.EQUAL, createPermission);
      }
    

      public ListAccessRequest filterByCreatePermission(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getCreatePermissionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ListAccessRequest selectCreatePermission(){
          return select(CREATE_PERMISSION_PROPERTY);
      }

      public ListAccessRequest unselectCreatePermission(){
          return unselect(CREATE_PERMISSION_PROPERTY);
      }

      public SearchCriteria getCreatePermissionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(CREATE_PERMISSION_PROPERTY, pQueryOperator, parameters);
      }

      public ListAccessRequest orderByCreatePermission(boolean asc){
          addOrderBy(CREATE_PERMISSION_PROPERTY, asc);
          return this;
      }
   
      public ListAccessRequest filterByDeletePermission(boolean deletePermission) {
          
          return filterByDeletePermission(QueryOperator.EQUAL, deletePermission);
      }
    

      public ListAccessRequest filterByDeletePermission(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getDeletePermissionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ListAccessRequest selectDeletePermission(){
          return select(DELETE_PERMISSION_PROPERTY);
      }

      public ListAccessRequest unselectDeletePermission(){
          return unselect(DELETE_PERMISSION_PROPERTY);
      }

      public SearchCriteria getDeletePermissionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(DELETE_PERMISSION_PROPERTY, pQueryOperator, parameters);
      }

      public ListAccessRequest orderByDeletePermission(boolean asc){
          addOrderBy(DELETE_PERMISSION_PROPERTY, asc);
          return this;
      }
   
      public ListAccessRequest filterByUpdatePermission(boolean updatePermission) {
          
          return filterByUpdatePermission(QueryOperator.EQUAL, updatePermission);
      }
    

      public ListAccessRequest filterByUpdatePermission(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getUpdatePermissionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ListAccessRequest selectUpdatePermission(){
          return select(UPDATE_PERMISSION_PROPERTY);
      }

      public ListAccessRequest unselectUpdatePermission(){
          return unselect(UPDATE_PERMISSION_PROPERTY);
      }

      public SearchCriteria getUpdatePermissionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(UPDATE_PERMISSION_PROPERTY, pQueryOperator, parameters);
      }

      public ListAccessRequest orderByUpdatePermission(boolean asc){
          addOrderBy(UPDATE_PERMISSION_PROPERTY, asc);
          return this;
      }
   
      public ListAccessRequest filterByExecutionPermission(boolean executionPermission) {
          
          return filterByExecutionPermission(QueryOperator.EQUAL, executionPermission);
      }
    

      public ListAccessRequest filterByExecutionPermission(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getExecutionPermissionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ListAccessRequest selectExecutionPermission(){
          return select(EXECUTION_PERMISSION_PROPERTY);
      }

      public ListAccessRequest unselectExecutionPermission(){
          return unselect(EXECUTION_PERMISSION_PROPERTY);
      }

      public SearchCriteria getExecutionPermissionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(EXECUTION_PERMISSION_PROPERTY, pQueryOperator, parameters);
      }

      public ListAccessRequest orderByExecutionPermission(boolean asc){
          addOrderBy(EXECUTION_PERMISSION_PROPERTY, asc);
          return this;
      }
   
      public ListAccessRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public ListAccessRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ListAccessRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public ListAccessRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public ListAccessRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public ListAccessRequest filterByApp(UserAppRequest app){
        return filterByApp(app, appList -> appList.stream().map(UserApp::getId).collect(Collectors.toSet()));
    }

    public ListAccessRequest filterByApp(UserAppRequest app, IDRefine<UserApp> idRefine) {
        return addSearchCriteria(createAppCriteria(app, idRefine));
    }

    public SearchCriteria createAppCriteria(UserAppRequest app, IDRefine<UserApp> idRefine) {
        return new RefinedIdInCriteria(app, APP_PROPERTY, idRefine);
    }
    

    
    public ListAccessRequest selectApp(){
        return selectApp(UserAppRequest.newInstance().selectSelf());
    }

    public ListAccessRequest selectApp(UserAppRequest app){
        selectParent(APP_PROPERTY, app);
        return this;
    }
    

    public ListAccessRequest unselectApp(){
        unselectParent(APP_PROPERTY);
        return this;
    }

  


  

   public ListAccessRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

