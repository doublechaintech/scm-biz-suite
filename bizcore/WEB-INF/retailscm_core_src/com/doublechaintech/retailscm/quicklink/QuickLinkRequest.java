package com.doublechaintech.retailscm.quicklink;

import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.userapp.UserAppRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.quicklink.QuickLink.*;

public class QuickLinkRequest extends BaseRequest<QuickLink> {
    public static QuickLinkRequest newInstance() {
        return new QuickLinkRequest().selectId();
    }

    public String getInternalType() {
        return "QuickLink";
    }

    public QuickLinkRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public QuickLinkRequest select(String... names) {
        super.select(names);
        return this;
    }

    public QuickLinkRequest selectAll() {return this.selectId().selectName().selectIcon().selectImagePath().selectLinkTarget().selectCreateTime().selectApp().selectVersion();
    }

    public QuickLinkRequest selectSelf() {return this.selectId().selectName().selectIcon().selectImagePath().selectLinkTarget().selectCreateTime().selectVersion();
    }

    public QuickLinkRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public QuickLinkRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static QuickLinkRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public QuickLinkRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public QuickLinkRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public QuickLinkRequest selectId(){
          return select(ID_PROPERTY);
      }

      public QuickLinkRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public QuickLinkRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public QuickLinkRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public QuickLinkRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public QuickLinkRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public QuickLinkRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public QuickLinkRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public QuickLinkRequest filterByIcon(String icon) {
          
          if (icon == null) {
              return this;
          }
          
          return filterByIcon(QueryOperator.EQUAL, icon);
      }
    

      public QuickLinkRequest filterByIcon(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIconSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public QuickLinkRequest selectIcon(){
          return select(ICON_PROPERTY);
      }

      public QuickLinkRequest unselectIcon(){
          return unselect(ICON_PROPERTY);
      }

      public SearchCriteria getIconSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ICON_PROPERTY, pQueryOperator, parameters);
      }

      public QuickLinkRequest orderByIcon(boolean asc){
          addOrderBy(ICON_PROPERTY, asc);
          return this;
      }
   
      public QuickLinkRequest filterByImagePath(String imagePath) {
          
          if (imagePath == null) {
              return this;
          }
          
          return filterByImagePath(QueryOperator.EQUAL, imagePath);
      }
    

      public QuickLinkRequest filterByImagePath(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getImagePathSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public QuickLinkRequest selectImagePath(){
          return select(IMAGE_PATH_PROPERTY);
      }

      public QuickLinkRequest unselectImagePath(){
          return unselect(IMAGE_PATH_PROPERTY);
      }

      public SearchCriteria getImagePathSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(IMAGE_PATH_PROPERTY, pQueryOperator, parameters);
      }

      public QuickLinkRequest orderByImagePath(boolean asc){
          addOrderBy(IMAGE_PATH_PROPERTY, asc);
          return this;
      }
   
      public QuickLinkRequest filterByLinkTarget(String linkTarget) {
          
          if (linkTarget == null) {
              return this;
          }
          
          return filterByLinkTarget(QueryOperator.EQUAL, linkTarget);
      }
    

      public QuickLinkRequest filterByLinkTarget(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLinkTargetSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public QuickLinkRequest selectLinkTarget(){
          return select(LINK_TARGET_PROPERTY);
      }

      public QuickLinkRequest unselectLinkTarget(){
          return unselect(LINK_TARGET_PROPERTY);
      }

      public SearchCriteria getLinkTargetSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LINK_TARGET_PROPERTY, pQueryOperator, parameters);
      }

      public QuickLinkRequest orderByLinkTarget(boolean asc){
          addOrderBy(LINK_TARGET_PROPERTY, asc);
          return this;
      }
   
      public QuickLinkRequest filterByCreateTime(DateTime createTime) {
          
          if (createTime == null) {
              return this;
          }
          
          return filterByCreateTime(QueryOperator.EQUAL, createTime);
      }
    

      public QuickLinkRequest filterByCreateTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getCreateTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public QuickLinkRequest selectCreateTime(){
          return select(CREATE_TIME_PROPERTY);
      }

      public QuickLinkRequest unselectCreateTime(){
          return unselect(CREATE_TIME_PROPERTY);
      }

      public SearchCriteria getCreateTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(CREATE_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public QuickLinkRequest orderByCreateTime(boolean asc){
          addOrderBy(CREATE_TIME_PROPERTY, asc);
          return this;
      }
   
      public QuickLinkRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public QuickLinkRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public QuickLinkRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public QuickLinkRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public QuickLinkRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public QuickLinkRequest filterByApp(UserAppRequest app){
        return filterByApp(app, appList -> appList.stream().map(UserApp::getId).collect(Collectors.toSet()));
    }

    public QuickLinkRequest filterByApp(UserAppRequest app, IDRefine<UserApp> idRefine) {
        return addSearchCriteria(createAppCriteria(app, idRefine));
    }

    public SearchCriteria createAppCriteria(UserAppRequest app, IDRefine<UserApp> idRefine) {
        return new RefinedIdInCriteria(app, APP_PROPERTY, idRefine);
    }
    

    
    public QuickLinkRequest selectApp(){
        return selectApp(UserAppRequest.newInstance().selectSelf());
    }

    public QuickLinkRequest selectApp(UserAppRequest app){
        selectParent(APP_PROPERTY, app);
        return this;
    }
    

    public QuickLinkRequest unselectApp(){
        unselectParent(APP_PROPERTY);
        return this;
    }

  


  

   public QuickLinkRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

