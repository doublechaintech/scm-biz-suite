package com.doublechaintech.retailscm.mobileapp;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.page.Page;
import com.doublechaintech.retailscm.pagetype.PageType;
import com.doublechaintech.retailscm.page.PageRequest;
import com.doublechaintech.retailscm.pagetype.PageTypeRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.mobileapp.MobileApp.*;

public class MobileAppRequest extends BaseRequest<MobileApp> {
    public static MobileAppRequest newInstance() {
        return new MobileAppRequest().selectId();
    }

    public String getInternalType() {
        return "MobileApp";
    }

    public MobileAppRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public MobileAppRequest select(String... names) {
        super.select(names);
        return this;
    }

    public MobileAppRequest selectAll() {return this.selectId().selectName().selectVersion();
    }

    public MobileAppRequest selectSelf() {return this.selectId().selectName().selectVersion();
    }

    public MobileAppRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public MobileAppRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static MobileAppRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public MobileAppRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public MobileAppRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public MobileAppRequest selectId(){
          return select(ID_PROPERTY);
      }

      public MobileAppRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public MobileAppRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public MobileAppRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public MobileAppRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public MobileAppRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public MobileAppRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public MobileAppRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public MobileAppRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public MobileAppRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public MobileAppRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public MobileAppRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public MobileAppRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  


  

    public MobileAppRequest hasPage() {
      return hasPage(PageRequest.newInstance());
    }

    public MobileAppRequest hasPage(PageRequest page) {
        return hasPage(page, pageList -> pageList.stream().map(Page::getMobileApp).map(MobileApp::getId).collect(Collectors.toSet()));
    }

    public MobileAppRequest hasPage(PageRequest page, IDRefine<Page> idRefine) {
        page.select(Page.MOBILE_APP_PROPERTY);
        return addSearchCriteria(createPageCriteria(page, idRefine));
    }

    public SearchCriteria createPageCriteria(PageRequest page, IDRefine<Page> idRefine){
       return new RefinedIdInCriteria(page, ID_PROPERTY, idRefine);
    }

    public MobileAppRequest selectPageList(PageRequest page) {
        selectChild(Page.MOBILE_APP_PROPERTY, page);
        return this;
    }

    public MobileAppRequest selectPageList() {
        return selectPageList(PageRequest.newInstance().selectAll());
    }

    public MobileAppRequest unselectPageList(){
        unselectChild(Page.MOBILE_APP_PROPERTY, Page.class);
        return this;
    }
  

    public MobileAppRequest hasPageType() {
      return hasPageType(PageTypeRequest.newInstance());
    }

    public MobileAppRequest hasPageType(PageTypeRequest pageType) {
        return hasPageType(pageType, pageTypeList -> pageTypeList.stream().map(PageType::getMobileApp).map(MobileApp::getId).collect(Collectors.toSet()));
    }

    public MobileAppRequest hasPageType(PageTypeRequest pageType, IDRefine<PageType> idRefine) {
        pageType.select(PageType.MOBILE_APP_PROPERTY);
        return addSearchCriteria(createPageTypeCriteria(pageType, idRefine));
    }

    public SearchCriteria createPageTypeCriteria(PageTypeRequest pageType, IDRefine<PageType> idRefine){
       return new RefinedIdInCriteria(pageType, ID_PROPERTY, idRefine);
    }

    public MobileAppRequest selectPageTypeList(PageTypeRequest pageType) {
        selectChild(PageType.MOBILE_APP_PROPERTY, pageType);
        return this;
    }

    public MobileAppRequest selectPageTypeList() {
        return selectPageTypeList(PageTypeRequest.newInstance().selectAll());
    }

    public MobileAppRequest unselectPageTypeList(){
        unselectChild(PageType.MOBILE_APP_PROPERTY, PageType.class);
        return this;
    }
  

   public MobileAppRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

