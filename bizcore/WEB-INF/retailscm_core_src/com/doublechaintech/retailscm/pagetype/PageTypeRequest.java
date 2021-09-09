package com.doublechaintech.retailscm.pagetype;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.mobileapp.MobileApp;
import com.doublechaintech.retailscm.mobileapp.MobileAppRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.pagetype.PageType.*;

public class PageTypeRequest extends BaseRequest<PageType> {
    public static PageTypeRequest newInstance() {
        return new PageTypeRequest().selectId();
    }

    public String getInternalType() {
        return "PageType";
    }

    public PageTypeRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public PageTypeRequest select(String... names) {
        super.select(names);
        return this;
    }

    public PageTypeRequest selectAll() {return this.selectId().selectName().selectCode().selectMobileApp().selectFooterTab().selectVersion();
    }

    public PageTypeRequest selectSelf() {return this.selectId().selectName().selectCode().selectFooterTab().selectVersion();
    }

    public PageTypeRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public PageTypeRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static PageTypeRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   
     public static PageTypeRequest withCode(String code) {
          return newInstance().filterByCode(code).selectAll();
     }
   

    
      public PageTypeRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public PageTypeRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public PageTypeRequest selectId(){
          return select(ID_PROPERTY);
      }

      public PageTypeRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public PageTypeRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public PageTypeRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public PageTypeRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public PageTypeRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public PageTypeRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public PageTypeRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public PageTypeRequest filterByCode(String code) {
          
          if (code == null) {
              return this;
          }
          
          return filterByCode(QueryOperator.EQUAL, code);
      }
    

      public PageTypeRequest filterByCode(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getCodeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public PageTypeRequest selectCode(){
          return select(CODE_PROPERTY);
      }

      public PageTypeRequest unselectCode(){
          return unselect(CODE_PROPERTY);
      }

      public SearchCriteria getCodeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(CODE_PROPERTY, pQueryOperator, parameters);
      }

      public PageTypeRequest orderByCode(boolean asc){
          addOrderBy(CODE_PROPERTY, asc);
          return this;
      }
   
      public PageTypeRequest filterByFooterTab(boolean footerTab) {
          
          return filterByFooterTab(QueryOperator.EQUAL, footerTab);
      }
    

      public PageTypeRequest filterByFooterTab(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getFooterTabSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public PageTypeRequest selectFooterTab(){
          return select(FOOTER_TAB_PROPERTY);
      }

      public PageTypeRequest unselectFooterTab(){
          return unselect(FOOTER_TAB_PROPERTY);
      }

      public SearchCriteria getFooterTabSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(FOOTER_TAB_PROPERTY, pQueryOperator, parameters);
      }

      public PageTypeRequest orderByFooterTab(boolean asc){
          addOrderBy(FOOTER_TAB_PROPERTY, asc);
          return this;
      }
   
      public PageTypeRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public PageTypeRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public PageTypeRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public PageTypeRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public PageTypeRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public PageTypeRequest filterByMobileApp(MobileAppRequest mobileApp){
        return filterByMobileApp(mobileApp, mobileAppList -> mobileAppList.stream().map(MobileApp::getId).collect(Collectors.toSet()));
    }

    public PageTypeRequest filterByMobileApp(MobileAppRequest mobileApp, IDRefine<MobileApp> idRefine) {
        return addSearchCriteria(createMobileAppCriteria(mobileApp, idRefine));
    }

    public SearchCriteria createMobileAppCriteria(MobileAppRequest mobileApp, IDRefine<MobileApp> idRefine) {
        return new RefinedIdInCriteria(mobileApp, MOBILE_APP_PROPERTY, idRefine);
    }
    

    
    public PageTypeRequest selectMobileApp(){
        return selectMobileApp(MobileAppRequest.newInstance().selectSelf());
    }

    public PageTypeRequest selectMobileApp(MobileAppRequest mobileApp){
        selectParent(MOBILE_APP_PROPERTY, mobileApp);
        return this;
    }
    

    public PageTypeRequest unselectMobileApp(){
        unselectParent(MOBILE_APP_PROPERTY);
        return this;
    }

  


  

   public PageTypeRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

