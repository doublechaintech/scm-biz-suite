package com.doublechaintech.retailscm.userapp;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.listaccess.ListAccess;
import com.doublechaintech.retailscm.quicklink.QuickLink;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.listaccess.ListAccessRequest;
import com.doublechaintech.retailscm.quicklink.QuickLinkRequest;
import com.doublechaintech.retailscm.secuser.SecUserRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.userapp.UserApp.*;

public class UserAppRequest extends BaseRequest<UserApp> {
    public static UserAppRequest newInstance() {
        return new UserAppRequest().selectId();
    }

    public String getInternalType() {
        return "UserApp";
    }

    public UserAppRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public UserAppRequest select(String... names) {
        super.select(names);
        return this;
    }

    public UserAppRequest selectAll() {return this.selectId().selectTitle().selectSecUser().selectAppIcon().selectFullAccess().selectPermission().selectAppType().selectAppId().selectCtxType().selectCtxId().selectLocation().selectVersion();
    }

    public UserAppRequest selectSelf() {return this.selectId().selectTitle().selectAppIcon().selectFullAccess().selectPermission().selectAppType().selectAppId().selectCtxType().selectCtxId().selectLocation().selectVersion();
    }

    public UserAppRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public UserAppRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static UserAppRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public UserAppRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public UserAppRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public UserAppRequest selectId(){
          return select(ID_PROPERTY);
      }

      public UserAppRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public UserAppRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public UserAppRequest filterByTitle(String title) {
          
          if (title == null) {
              return this;
          }
          
          return filterByTitle(QueryOperator.EQUAL, title);
      }
    

      public UserAppRequest filterByTitle(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getTitleSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public UserAppRequest selectTitle(){
          return select(TITLE_PROPERTY);
      }

      public UserAppRequest unselectTitle(){
          return unselect(TITLE_PROPERTY);
      }

      public SearchCriteria getTitleSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(TITLE_PROPERTY, pQueryOperator, parameters);
      }

      public UserAppRequest orderByTitle(boolean asc){
          addOrderBy(TITLE_PROPERTY, asc);
          return this;
      }
   
      public UserAppRequest filterByAppIcon(String appIcon) {
          
          if (appIcon == null) {
              return this;
          }
          
          return filterByAppIcon(QueryOperator.EQUAL, appIcon);
      }
    

      public UserAppRequest filterByAppIcon(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getAppIconSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public UserAppRequest selectAppIcon(){
          return select(APP_ICON_PROPERTY);
      }

      public UserAppRequest unselectAppIcon(){
          return unselect(APP_ICON_PROPERTY);
      }

      public SearchCriteria getAppIconSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(APP_ICON_PROPERTY, pQueryOperator, parameters);
      }

      public UserAppRequest orderByAppIcon(boolean asc){
          addOrderBy(APP_ICON_PROPERTY, asc);
          return this;
      }
   
      public UserAppRequest filterByFullAccess(boolean fullAccess) {
          
          return filterByFullAccess(QueryOperator.EQUAL, fullAccess);
      }
    

      public UserAppRequest filterByFullAccess(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getFullAccessSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public UserAppRequest selectFullAccess(){
          return select(FULL_ACCESS_PROPERTY);
      }

      public UserAppRequest unselectFullAccess(){
          return unselect(FULL_ACCESS_PROPERTY);
      }

      public SearchCriteria getFullAccessSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(FULL_ACCESS_PROPERTY, pQueryOperator, parameters);
      }

      public UserAppRequest orderByFullAccess(boolean asc){
          addOrderBy(FULL_ACCESS_PROPERTY, asc);
          return this;
      }
   
      public UserAppRequest filterByPermission(String permission) {
          
          if (permission == null) {
              return this;
          }
          
          return filterByPermission(QueryOperator.EQUAL, permission);
      }
    

      public UserAppRequest filterByPermission(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getPermissionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public UserAppRequest selectPermission(){
          return select(PERMISSION_PROPERTY);
      }

      public UserAppRequest unselectPermission(){
          return unselect(PERMISSION_PROPERTY);
      }

      public SearchCriteria getPermissionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(PERMISSION_PROPERTY, pQueryOperator, parameters);
      }

      public UserAppRequest orderByPermission(boolean asc){
          addOrderBy(PERMISSION_PROPERTY, asc);
          return this;
      }
   
      public UserAppRequest filterByAppType(String appType) {
          
          if (appType == null) {
              return this;
          }
          
          return filterByAppType(QueryOperator.EQUAL, appType);
      }
    

      public UserAppRequest filterByAppType(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getAppTypeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public UserAppRequest selectAppType(){
          return select(APP_TYPE_PROPERTY);
      }

      public UserAppRequest unselectAppType(){
          return unselect(APP_TYPE_PROPERTY);
      }

      public SearchCriteria getAppTypeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(APP_TYPE_PROPERTY, pQueryOperator, parameters);
      }

      public UserAppRequest orderByAppType(boolean asc){
          addOrderBy(APP_TYPE_PROPERTY, asc);
          return this;
      }
   
      public UserAppRequest filterByAppId(String appId) {
          
          if (appId == null) {
              return this;
          }
          
          return filterByAppId(QueryOperator.EQUAL, appId);
      }
    

      public UserAppRequest filterByAppId(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getAppIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public UserAppRequest selectAppId(){
          return select(APP_ID_PROPERTY);
      }

      public UserAppRequest unselectAppId(){
          return unselect(APP_ID_PROPERTY);
      }

      public SearchCriteria getAppIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(APP_ID_PROPERTY, pQueryOperator, parameters);
      }

      public UserAppRequest orderByAppId(boolean asc){
          addOrderBy(APP_ID_PROPERTY, asc);
          return this;
      }
   
      public UserAppRequest filterByCtxType(String ctxType) {
          
          if (ctxType == null) {
              return this;
          }
          
          return filterByCtxType(QueryOperator.EQUAL, ctxType);
      }
    

      public UserAppRequest filterByCtxType(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getCtxTypeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public UserAppRequest selectCtxType(){
          return select(CTX_TYPE_PROPERTY);
      }

      public UserAppRequest unselectCtxType(){
          return unselect(CTX_TYPE_PROPERTY);
      }

      public SearchCriteria getCtxTypeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(CTX_TYPE_PROPERTY, pQueryOperator, parameters);
      }

      public UserAppRequest orderByCtxType(boolean asc){
          addOrderBy(CTX_TYPE_PROPERTY, asc);
          return this;
      }
   
      public UserAppRequest filterByCtxId(String ctxId) {
          
          if (ctxId == null) {
              return this;
          }
          
          return filterByCtxId(QueryOperator.EQUAL, ctxId);
      }
    

      public UserAppRequest filterByCtxId(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getCtxIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public UserAppRequest selectCtxId(){
          return select(CTX_ID_PROPERTY);
      }

      public UserAppRequest unselectCtxId(){
          return unselect(CTX_ID_PROPERTY);
      }

      public SearchCriteria getCtxIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(CTX_ID_PROPERTY, pQueryOperator, parameters);
      }

      public UserAppRequest orderByCtxId(boolean asc){
          addOrderBy(CTX_ID_PROPERTY, asc);
          return this;
      }
   
      public UserAppRequest filterByLocation(String location) {
          
          if (location == null) {
              return this;
          }
          
          return filterByLocation(QueryOperator.EQUAL, location);
      }
    

      public UserAppRequest filterByLocation(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLocationSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public UserAppRequest selectLocation(){
          return select(LOCATION_PROPERTY);
      }

      public UserAppRequest unselectLocation(){
          return unselect(LOCATION_PROPERTY);
      }

      public SearchCriteria getLocationSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LOCATION_PROPERTY, pQueryOperator, parameters);
      }

      public UserAppRequest orderByLocation(boolean asc){
          addOrderBy(LOCATION_PROPERTY, asc);
          return this;
      }
   
      public UserAppRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public UserAppRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public UserAppRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public UserAppRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public UserAppRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public UserAppRequest filterBySecUser(SecUserRequest secUser){
        return filterBySecUser(secUser, secUserList -> secUserList.stream().map(SecUser::getId).collect(Collectors.toSet()));
    }

    public UserAppRequest filterBySecUser(SecUserRequest secUser, IDRefine<SecUser> idRefine) {
        return addSearchCriteria(createSecUserCriteria(secUser, idRefine));
    }

    public SearchCriteria createSecUserCriteria(SecUserRequest secUser, IDRefine<SecUser> idRefine) {
        return new RefinedIdInCriteria(secUser, SEC_USER_PROPERTY, idRefine);
    }
    

    
    public UserAppRequest selectSecUser(){
        return selectSecUser(SecUserRequest.newInstance().selectSelf());
    }

    public UserAppRequest selectSecUser(SecUserRequest secUser){
        selectParent(SEC_USER_PROPERTY, secUser);
        return this;
    }
    

    public UserAppRequest unselectSecUser(){
        unselectParent(SEC_USER_PROPERTY);
        return this;
    }

  


  

    public UserAppRequest hasQuickLink() {
      return hasQuickLink(QuickLinkRequest.newInstance());
    }

    public UserAppRequest hasQuickLink(QuickLinkRequest quickLink) {
        return hasQuickLink(quickLink, quickLinkList -> quickLinkList.stream().map(QuickLink::getApp).map(UserApp::getId).collect(Collectors.toSet()));
    }

    public UserAppRequest hasQuickLink(QuickLinkRequest quickLink, IDRefine<QuickLink> idRefine) {
        quickLink.select(QuickLink.APP_PROPERTY);
        return addSearchCriteria(createQuickLinkCriteria(quickLink, idRefine));
    }

    public SearchCriteria createQuickLinkCriteria(QuickLinkRequest quickLink, IDRefine<QuickLink> idRefine){
       return new RefinedIdInCriteria(quickLink, ID_PROPERTY, idRefine);
    }

    public UserAppRequest selectQuickLinkList(QuickLinkRequest quickLink) {
        selectChild(QuickLink.APP_PROPERTY, quickLink);
        return this;
    }

    public UserAppRequest selectQuickLinkList() {
        return selectQuickLinkList(QuickLinkRequest.newInstance().selectAll());
    }

    public UserAppRequest unselectQuickLinkList(){
        unselectChild(QuickLink.APP_PROPERTY, QuickLink.class);
        return this;
    }
  

    public UserAppRequest hasListAccess() {
      return hasListAccess(ListAccessRequest.newInstance());
    }

    public UserAppRequest hasListAccess(ListAccessRequest listAccess) {
        return hasListAccess(listAccess, listAccessList -> listAccessList.stream().map(ListAccess::getApp).map(UserApp::getId).collect(Collectors.toSet()));
    }

    public UserAppRequest hasListAccess(ListAccessRequest listAccess, IDRefine<ListAccess> idRefine) {
        listAccess.select(ListAccess.APP_PROPERTY);
        return addSearchCriteria(createListAccessCriteria(listAccess, idRefine));
    }

    public SearchCriteria createListAccessCriteria(ListAccessRequest listAccess, IDRefine<ListAccess> idRefine){
       return new RefinedIdInCriteria(listAccess, ID_PROPERTY, idRefine);
    }

    public UserAppRequest selectListAccessList(ListAccessRequest listAccess) {
        selectChild(ListAccess.APP_PROPERTY, listAccess);
        return this;
    }

    public UserAppRequest selectListAccessList() {
        return selectListAccessList(ListAccessRequest.newInstance().selectAll());
    }

    public UserAppRequest unselectListAccessList(){
        unselectChild(ListAccess.APP_PROPERTY, ListAccess.class);
        return this;
    }
  

   public UserAppRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

