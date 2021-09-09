package com.doublechaintech.retailscm.uiaction;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.page.Page;
import com.doublechaintech.retailscm.page.PageRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.uiaction.UiAction.*;

public class UiActionRequest extends BaseRequest<UiAction> {
    public static UiActionRequest newInstance() {
        return new UiActionRequest().selectId();
    }

    public String getInternalType() {
        return "UiAction";
    }

    public UiActionRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public UiActionRequest select(String... names) {
        super.select(names);
        return this;
    }

    public UiActionRequest selectAll() {return this.selectId().selectCode().selectIcon().selectTitle().selectDisplayOrder().selectBrief().selectImageUrl().selectLinkToUrl().selectExtraData().selectPage().selectVersion();
    }

    public UiActionRequest selectSelf() {return this.selectId().selectCode().selectIcon().selectTitle().selectDisplayOrder().selectBrief().selectImageUrl().selectLinkToUrl().selectExtraData().selectVersion();
    }

    public UiActionRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public UiActionRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static UiActionRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public UiActionRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public UiActionRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public UiActionRequest selectId(){
          return select(ID_PROPERTY);
      }

      public UiActionRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public UiActionRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public UiActionRequest filterByCode(String code) {
          
          if (code == null) {
              return this;
          }
          
          return filterByCode(QueryOperator.EQUAL, code);
      }
    

      public UiActionRequest filterByCode(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getCodeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public UiActionRequest selectCode(){
          return select(CODE_PROPERTY);
      }

      public UiActionRequest unselectCode(){
          return unselect(CODE_PROPERTY);
      }

      public SearchCriteria getCodeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(CODE_PROPERTY, pQueryOperator, parameters);
      }

      public UiActionRequest orderByCode(boolean asc){
          addOrderBy(CODE_PROPERTY, asc);
          return this;
      }
   
      public UiActionRequest filterByIcon(String icon) {
          
          if (icon == null) {
              return this;
          }
          
          return filterByIcon(QueryOperator.EQUAL, icon);
      }
    

      public UiActionRequest filterByIcon(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIconSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public UiActionRequest selectIcon(){
          return select(ICON_PROPERTY);
      }

      public UiActionRequest unselectIcon(){
          return unselect(ICON_PROPERTY);
      }

      public SearchCriteria getIconSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ICON_PROPERTY, pQueryOperator, parameters);
      }

      public UiActionRequest orderByIcon(boolean asc){
          addOrderBy(ICON_PROPERTY, asc);
          return this;
      }
   
      public UiActionRequest filterByTitle(String title) {
          
          if (title == null) {
              return this;
          }
          
          return filterByTitle(QueryOperator.EQUAL, title);
      }
    

      public UiActionRequest filterByTitle(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getTitleSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public UiActionRequest selectTitle(){
          return select(TITLE_PROPERTY);
      }

      public UiActionRequest unselectTitle(){
          return unselect(TITLE_PROPERTY);
      }

      public SearchCriteria getTitleSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(TITLE_PROPERTY, pQueryOperator, parameters);
      }

      public UiActionRequest orderByTitle(boolean asc){
          addOrderBy(TITLE_PROPERTY, asc);
          return this;
      }
   
      public UiActionRequest filterByDisplayOrder(int displayOrder) {
          
          return filterByDisplayOrder(QueryOperator.EQUAL, displayOrder);
      }
    

      public UiActionRequest filterByDisplayOrder(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getDisplayOrderSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public UiActionRequest selectDisplayOrder(){
          return select(DISPLAY_ORDER_PROPERTY);
      }

      public UiActionRequest unselectDisplayOrder(){
          return unselect(DISPLAY_ORDER_PROPERTY);
      }

      public SearchCriteria getDisplayOrderSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(DISPLAY_ORDER_PROPERTY, pQueryOperator, parameters);
      }

      public UiActionRequest orderByDisplayOrder(boolean asc){
          addOrderBy(DISPLAY_ORDER_PROPERTY, asc);
          return this;
      }
   
      public UiActionRequest filterByBrief(String brief) {
          
          if (brief == null) {
              return this;
          }
          
          return filterByBrief(QueryOperator.EQUAL, brief);
      }
    

      public UiActionRequest filterByBrief(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getBriefSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public UiActionRequest selectBrief(){
          return select(BRIEF_PROPERTY);
      }

      public UiActionRequest unselectBrief(){
          return unselect(BRIEF_PROPERTY);
      }

      public SearchCriteria getBriefSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(BRIEF_PROPERTY, pQueryOperator, parameters);
      }

      public UiActionRequest orderByBrief(boolean asc){
          addOrderBy(BRIEF_PROPERTY, asc);
          return this;
      }
   
      public UiActionRequest filterByImageUrl(String imageUrl) {
          
          if (imageUrl == null) {
              return this;
          }
          
          return filterByImageUrl(QueryOperator.EQUAL, imageUrl);
      }
    

      public UiActionRequest filterByImageUrl(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getImageUrlSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public UiActionRequest selectImageUrl(){
          return select(IMAGE_URL_PROPERTY);
      }

      public UiActionRequest unselectImageUrl(){
          return unselect(IMAGE_URL_PROPERTY);
      }

      public SearchCriteria getImageUrlSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(IMAGE_URL_PROPERTY, pQueryOperator, parameters);
      }

      public UiActionRequest orderByImageUrl(boolean asc){
          addOrderBy(IMAGE_URL_PROPERTY, asc);
          return this;
      }
   
      public UiActionRequest filterByLinkToUrl(String linkToUrl) {
          
          if (linkToUrl == null) {
              return this;
          }
          
          return filterByLinkToUrl(QueryOperator.EQUAL, linkToUrl);
      }
    

      public UiActionRequest filterByLinkToUrl(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLinkToUrlSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public UiActionRequest selectLinkToUrl(){
          return select(LINK_TO_URL_PROPERTY);
      }

      public UiActionRequest unselectLinkToUrl(){
          return unselect(LINK_TO_URL_PROPERTY);
      }

      public SearchCriteria getLinkToUrlSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LINK_TO_URL_PROPERTY, pQueryOperator, parameters);
      }

      public UiActionRequest orderByLinkToUrl(boolean asc){
          addOrderBy(LINK_TO_URL_PROPERTY, asc);
          return this;
      }
   
      public UiActionRequest filterByExtraData(String extraData) {
          
          if (extraData == null) {
              return this;
          }
          
          return filterByExtraData(QueryOperator.EQUAL, extraData);
      }
    

      public UiActionRequest filterByExtraData(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getExtraDataSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public UiActionRequest selectExtraData(){
          return select(EXTRA_DATA_PROPERTY);
      }

      public UiActionRequest unselectExtraData(){
          return unselect(EXTRA_DATA_PROPERTY);
      }

      public SearchCriteria getExtraDataSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(EXTRA_DATA_PROPERTY, pQueryOperator, parameters);
      }

      public UiActionRequest orderByExtraData(boolean asc){
          addOrderBy(EXTRA_DATA_PROPERTY, asc);
          return this;
      }
   
      public UiActionRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public UiActionRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public UiActionRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public UiActionRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public UiActionRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public UiActionRequest filterByPage(PageRequest page){
        return filterByPage(page, pageList -> pageList.stream().map(Page::getId).collect(Collectors.toSet()));
    }

    public UiActionRequest filterByPage(PageRequest page, IDRefine<Page> idRefine) {
        return addSearchCriteria(createPageCriteria(page, idRefine));
    }

    public SearchCriteria createPageCriteria(PageRequest page, IDRefine<Page> idRefine) {
        return new RefinedIdInCriteria(page, PAGE_PROPERTY, idRefine);
    }
    

    
    public UiActionRequest selectPage(){
        return selectPage(PageRequest.newInstance().selectSelf());
    }

    public UiActionRequest selectPage(PageRequest page){
        selectParent(PAGE_PROPERTY, page);
        return this;
    }
    

    public UiActionRequest unselectPage(){
        unselectParent(PAGE_PROPERTY);
        return this;
    }

  


  

   public UiActionRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

