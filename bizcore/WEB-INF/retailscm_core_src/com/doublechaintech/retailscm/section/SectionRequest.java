package com.doublechaintech.retailscm.section;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.page.Page;
import com.doublechaintech.retailscm.page.PageRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.section.Section.*;

public class SectionRequest extends BaseRequest<Section> {
    public static SectionRequest newInstance() {
        return new SectionRequest().selectId();
    }

    public String getInternalType() {
        return "Section";
    }

    public SectionRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public SectionRequest select(String... names) {
        super.select(names);
        return this;
    }

    public SectionRequest selectAll() {return this.selectId().selectTitle().selectBrief().selectIcon().selectDisplayOrder().selectViewGroup().selectLinkToUrl().selectPage().selectVersion();
    }

    public SectionRequest selectSelf() {return this.selectId().selectTitle().selectBrief().selectIcon().selectDisplayOrder().selectViewGroup().selectLinkToUrl().selectVersion();
    }

    public SectionRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public SectionRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static SectionRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public SectionRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public SectionRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SectionRequest selectId(){
          return select(ID_PROPERTY);
      }

      public SectionRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public SectionRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public SectionRequest filterByTitle(String title) {
          
          if (title == null) {
              return this;
          }
          
          return filterByTitle(QueryOperator.EQUAL, title);
      }
    

      public SectionRequest filterByTitle(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getTitleSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SectionRequest selectTitle(){
          return select(TITLE_PROPERTY);
      }

      public SectionRequest unselectTitle(){
          return unselect(TITLE_PROPERTY);
      }

      public SearchCriteria getTitleSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(TITLE_PROPERTY, pQueryOperator, parameters);
      }

      public SectionRequest orderByTitle(boolean asc){
          addOrderBy(TITLE_PROPERTY, asc);
          return this;
      }
   
      public SectionRequest filterByBrief(String brief) {
          
          if (brief == null) {
              return this;
          }
          
          return filterByBrief(QueryOperator.EQUAL, brief);
      }
    

      public SectionRequest filterByBrief(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getBriefSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SectionRequest selectBrief(){
          return select(BRIEF_PROPERTY);
      }

      public SectionRequest unselectBrief(){
          return unselect(BRIEF_PROPERTY);
      }

      public SearchCriteria getBriefSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(BRIEF_PROPERTY, pQueryOperator, parameters);
      }

      public SectionRequest orderByBrief(boolean asc){
          addOrderBy(BRIEF_PROPERTY, asc);
          return this;
      }
   
      public SectionRequest filterByIcon(String icon) {
          
          if (icon == null) {
              return this;
          }
          
          return filterByIcon(QueryOperator.EQUAL, icon);
      }
    

      public SectionRequest filterByIcon(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIconSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SectionRequest selectIcon(){
          return select(ICON_PROPERTY);
      }

      public SectionRequest unselectIcon(){
          return unselect(ICON_PROPERTY);
      }

      public SearchCriteria getIconSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ICON_PROPERTY, pQueryOperator, parameters);
      }

      public SectionRequest orderByIcon(boolean asc){
          addOrderBy(ICON_PROPERTY, asc);
          return this;
      }
   
      public SectionRequest filterByDisplayOrder(int displayOrder) {
          
          return filterByDisplayOrder(QueryOperator.EQUAL, displayOrder);
      }
    

      public SectionRequest filterByDisplayOrder(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getDisplayOrderSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SectionRequest selectDisplayOrder(){
          return select(DISPLAY_ORDER_PROPERTY);
      }

      public SectionRequest unselectDisplayOrder(){
          return unselect(DISPLAY_ORDER_PROPERTY);
      }

      public SearchCriteria getDisplayOrderSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(DISPLAY_ORDER_PROPERTY, pQueryOperator, parameters);
      }

      public SectionRequest orderByDisplayOrder(boolean asc){
          addOrderBy(DISPLAY_ORDER_PROPERTY, asc);
          return this;
      }
   
      public SectionRequest filterByViewGroup(String viewGroup) {
          
          if (viewGroup == null) {
              return this;
          }
          
          return filterByViewGroup(QueryOperator.EQUAL, viewGroup);
      }
    

      public SectionRequest filterByViewGroup(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getViewGroupSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SectionRequest selectViewGroup(){
          return select(VIEW_GROUP_PROPERTY);
      }

      public SectionRequest unselectViewGroup(){
          return unselect(VIEW_GROUP_PROPERTY);
      }

      public SearchCriteria getViewGroupSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VIEW_GROUP_PROPERTY, pQueryOperator, parameters);
      }

      public SectionRequest orderByViewGroup(boolean asc){
          addOrderBy(VIEW_GROUP_PROPERTY, asc);
          return this;
      }
   
      public SectionRequest filterByLinkToUrl(String linkToUrl) {
          
          if (linkToUrl == null) {
              return this;
          }
          
          return filterByLinkToUrl(QueryOperator.EQUAL, linkToUrl);
      }
    

      public SectionRequest filterByLinkToUrl(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLinkToUrlSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SectionRequest selectLinkToUrl(){
          return select(LINK_TO_URL_PROPERTY);
      }

      public SectionRequest unselectLinkToUrl(){
          return unselect(LINK_TO_URL_PROPERTY);
      }

      public SearchCriteria getLinkToUrlSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LINK_TO_URL_PROPERTY, pQueryOperator, parameters);
      }

      public SectionRequest orderByLinkToUrl(boolean asc){
          addOrderBy(LINK_TO_URL_PROPERTY, asc);
          return this;
      }
   
      public SectionRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public SectionRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SectionRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public SectionRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public SectionRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public SectionRequest filterByPage(PageRequest page){
        return filterByPage(page, pageList -> pageList.stream().map(Page::getId).collect(Collectors.toSet()));
    }

    public SectionRequest filterByPage(PageRequest page, IDRefine<Page> idRefine) {
        return addSearchCriteria(createPageCriteria(page, idRefine));
    }

    public SearchCriteria createPageCriteria(PageRequest page, IDRefine<Page> idRefine) {
        return new RefinedIdInCriteria(page, PAGE_PROPERTY, idRefine);
    }
    

    
    public SectionRequest selectPage(){
        return selectPage(PageRequest.newInstance().selectSelf());
    }

    public SectionRequest selectPage(PageRequest page){
        selectParent(PAGE_PROPERTY, page);
        return this;
    }
    

    public SectionRequest unselectPage(){
        unselectParent(PAGE_PROPERTY);
        return this;
    }

  


  

   public SectionRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

