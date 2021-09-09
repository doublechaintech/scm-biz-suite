package com.doublechaintech.retailscm.page;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.mobileapp.MobileApp;
import com.doublechaintech.retailscm.pagetype.PageType;
import com.doublechaintech.retailscm.section.Section;
import com.doublechaintech.retailscm.slide.Slide;
import com.doublechaintech.retailscm.uiaction.UiAction;
import com.doublechaintech.retailscm.mobileapp.MobileAppRequest;
import com.doublechaintech.retailscm.pagetype.PageTypeRequest;
import com.doublechaintech.retailscm.section.SectionRequest;
import com.doublechaintech.retailscm.slide.SlideRequest;
import com.doublechaintech.retailscm.uiaction.UiActionRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.page.Page.*;

public class PageRequest extends BaseRequest<Page> {
    public static PageRequest newInstance() {
        return new PageRequest().selectId();
    }

    public String getInternalType() {
        return "Page";
    }

    public PageRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public PageRequest select(String... names) {
        super.select(names);
        return this;
    }

    public PageRequest selectAll() {return this.selectId().selectPageTitle().selectLinkToUrl().selectPageType().selectDisplayOrder().selectMobileApp().selectVersion();
    }

    public PageRequest selectSelf() {return this.selectId().selectPageTitle().selectLinkToUrl().selectDisplayOrder().selectVersion();
    }

    public PageRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public PageRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static PageRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public PageRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public PageRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public PageRequest selectId(){
          return select(ID_PROPERTY);
      }

      public PageRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public PageRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public PageRequest filterByPageTitle(String pageTitle) {
          
          if (pageTitle == null) {
              return this;
          }
          
          return filterByPageTitle(QueryOperator.EQUAL, pageTitle);
      }
    

      public PageRequest filterByPageTitle(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getPageTitleSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public PageRequest selectPageTitle(){
          return select(PAGE_TITLE_PROPERTY);
      }

      public PageRequest unselectPageTitle(){
          return unselect(PAGE_TITLE_PROPERTY);
      }

      public SearchCriteria getPageTitleSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(PAGE_TITLE_PROPERTY, pQueryOperator, parameters);
      }

      public PageRequest orderByPageTitle(boolean asc){
          addOrderBy(PAGE_TITLE_PROPERTY, asc);
          return this;
      }
   
      public PageRequest filterByLinkToUrl(String linkToUrl) {
          
          if (linkToUrl == null) {
              return this;
          }
          
          return filterByLinkToUrl(QueryOperator.EQUAL, linkToUrl);
      }
    

      public PageRequest filterByLinkToUrl(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLinkToUrlSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public PageRequest selectLinkToUrl(){
          return select(LINK_TO_URL_PROPERTY);
      }

      public PageRequest unselectLinkToUrl(){
          return unselect(LINK_TO_URL_PROPERTY);
      }

      public SearchCriteria getLinkToUrlSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LINK_TO_URL_PROPERTY, pQueryOperator, parameters);
      }

      public PageRequest orderByLinkToUrl(boolean asc){
          addOrderBy(LINK_TO_URL_PROPERTY, asc);
          return this;
      }
   
      public PageRequest filterByDisplayOrder(int displayOrder) {
          
          return filterByDisplayOrder(QueryOperator.EQUAL, displayOrder);
      }
    

      public PageRequest filterByDisplayOrder(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getDisplayOrderSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public PageRequest selectDisplayOrder(){
          return select(DISPLAY_ORDER_PROPERTY);
      }

      public PageRequest unselectDisplayOrder(){
          return unselect(DISPLAY_ORDER_PROPERTY);
      }

      public SearchCriteria getDisplayOrderSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(DISPLAY_ORDER_PROPERTY, pQueryOperator, parameters);
      }

      public PageRequest orderByDisplayOrder(boolean asc){
          addOrderBy(DISPLAY_ORDER_PROPERTY, asc);
          return this;
      }
   
      public PageRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public PageRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public PageRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public PageRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public PageRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public PageRequest filterByPageType(PageTypeRequest pageType){
        return filterByPageType(pageType, pageTypeList -> pageTypeList.stream().map(PageType::getId).collect(Collectors.toSet()));
    }

    public PageRequest filterByPageType(PageTypeRequest pageType, IDRefine<PageType> idRefine) {
        return addSearchCriteria(createPageTypeCriteria(pageType, idRefine));
    }

    public SearchCriteria createPageTypeCriteria(PageTypeRequest pageType, IDRefine<PageType> idRefine) {
        return new RefinedIdInCriteria(pageType, PAGE_TYPE_PROPERTY, idRefine);
    }
    

    
    public PageRequest selectPageType(){
        return selectPageType(PageTypeRequest.newInstance().selectSelf());
    }

    public PageRequest selectPageType(PageTypeRequest pageType){
        selectParent(PAGE_TYPE_PROPERTY, pageType);
        return this;
    }
    

    public PageRequest unselectPageType(){
        unselectParent(PAGE_TYPE_PROPERTY);
        return this;
    }

  

    
    public PageRequest filterByMobileApp(MobileAppRequest mobileApp){
        return filterByMobileApp(mobileApp, mobileAppList -> mobileAppList.stream().map(MobileApp::getId).collect(Collectors.toSet()));
    }

    public PageRequest filterByMobileApp(MobileAppRequest mobileApp, IDRefine<MobileApp> idRefine) {
        return addSearchCriteria(createMobileAppCriteria(mobileApp, idRefine));
    }

    public SearchCriteria createMobileAppCriteria(MobileAppRequest mobileApp, IDRefine<MobileApp> idRefine) {
        return new RefinedIdInCriteria(mobileApp, MOBILE_APP_PROPERTY, idRefine);
    }
    

    
    public PageRequest selectMobileApp(){
        return selectMobileApp(MobileAppRequest.newInstance().selectSelf());
    }

    public PageRequest selectMobileApp(MobileAppRequest mobileApp){
        selectParent(MOBILE_APP_PROPERTY, mobileApp);
        return this;
    }
    

    public PageRequest unselectMobileApp(){
        unselectParent(MOBILE_APP_PROPERTY);
        return this;
    }

  


  

    public PageRequest hasSlide() {
      return hasSlide(SlideRequest.newInstance());
    }

    public PageRequest hasSlide(SlideRequest slide) {
        return hasSlide(slide, slideList -> slideList.stream().map(Slide::getPage).map(Page::getId).collect(Collectors.toSet()));
    }

    public PageRequest hasSlide(SlideRequest slide, IDRefine<Slide> idRefine) {
        slide.select(Slide.PAGE_PROPERTY);
        return addSearchCriteria(createSlideCriteria(slide, idRefine));
    }

    public SearchCriteria createSlideCriteria(SlideRequest slide, IDRefine<Slide> idRefine){
       return new RefinedIdInCriteria(slide, ID_PROPERTY, idRefine);
    }

    public PageRequest selectSlideList(SlideRequest slide) {
        selectChild(Slide.PAGE_PROPERTY, slide);
        return this;
    }

    public PageRequest selectSlideList() {
        return selectSlideList(SlideRequest.newInstance().selectAll());
    }

    public PageRequest unselectSlideList(){
        unselectChild(Slide.PAGE_PROPERTY, Slide.class);
        return this;
    }
  

    public PageRequest hasUiAction() {
      return hasUiAction(UiActionRequest.newInstance());
    }

    public PageRequest hasUiAction(UiActionRequest uiAction) {
        return hasUiAction(uiAction, uiActionList -> uiActionList.stream().map(UiAction::getPage).map(Page::getId).collect(Collectors.toSet()));
    }

    public PageRequest hasUiAction(UiActionRequest uiAction, IDRefine<UiAction> idRefine) {
        uiAction.select(UiAction.PAGE_PROPERTY);
        return addSearchCriteria(createUiActionCriteria(uiAction, idRefine));
    }

    public SearchCriteria createUiActionCriteria(UiActionRequest uiAction, IDRefine<UiAction> idRefine){
       return new RefinedIdInCriteria(uiAction, ID_PROPERTY, idRefine);
    }

    public PageRequest selectUiActionList(UiActionRequest uiAction) {
        selectChild(UiAction.PAGE_PROPERTY, uiAction);
        return this;
    }

    public PageRequest selectUiActionList() {
        return selectUiActionList(UiActionRequest.newInstance().selectAll());
    }

    public PageRequest unselectUiActionList(){
        unselectChild(UiAction.PAGE_PROPERTY, UiAction.class);
        return this;
    }
  

    public PageRequest hasSection() {
      return hasSection(SectionRequest.newInstance());
    }

    public PageRequest hasSection(SectionRequest section) {
        return hasSection(section, sectionList -> sectionList.stream().map(Section::getPage).map(Page::getId).collect(Collectors.toSet()));
    }

    public PageRequest hasSection(SectionRequest section, IDRefine<Section> idRefine) {
        section.select(Section.PAGE_PROPERTY);
        return addSearchCriteria(createSectionCriteria(section, idRefine));
    }

    public SearchCriteria createSectionCriteria(SectionRequest section, IDRefine<Section> idRefine){
       return new RefinedIdInCriteria(section, ID_PROPERTY, idRefine);
    }

    public PageRequest selectSectionList(SectionRequest section) {
        selectChild(Section.PAGE_PROPERTY, section);
        return this;
    }

    public PageRequest selectSectionList() {
        return selectSectionList(SectionRequest.newInstance().selectAll());
    }

    public PageRequest unselectSectionList(){
        unselectChild(Section.PAGE_PROPERTY, Section.class);
        return this;
    }
  

   public PageRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

