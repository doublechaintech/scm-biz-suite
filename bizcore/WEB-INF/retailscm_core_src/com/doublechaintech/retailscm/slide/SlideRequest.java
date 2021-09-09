package com.doublechaintech.retailscm.slide;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.page.Page;
import com.doublechaintech.retailscm.page.PageRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.slide.Slide.*;

public class SlideRequest extends BaseRequest<Slide> {
    public static SlideRequest newInstance() {
        return new SlideRequest().selectId();
    }

    public String getInternalType() {
        return "Slide";
    }

    public SlideRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public SlideRequest select(String... names) {
        super.select(names);
        return this;
    }

    public SlideRequest selectAll() {return this.selectId().selectName().selectDisplayOrder().selectImageUrl().selectVideoUrl().selectLinkToUrl().selectPage().selectVersion();
    }

    public SlideRequest selectSelf() {return this.selectId().selectName().selectDisplayOrder().selectImageUrl().selectVideoUrl().selectLinkToUrl().selectVersion();
    }

    public SlideRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public SlideRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static SlideRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public SlideRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public SlideRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SlideRequest selectId(){
          return select(ID_PROPERTY);
      }

      public SlideRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public SlideRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public SlideRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public SlideRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SlideRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public SlideRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public SlideRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public SlideRequest filterByDisplayOrder(int displayOrder) {
          
          return filterByDisplayOrder(QueryOperator.EQUAL, displayOrder);
      }
    

      public SlideRequest filterByDisplayOrder(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getDisplayOrderSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SlideRequest selectDisplayOrder(){
          return select(DISPLAY_ORDER_PROPERTY);
      }

      public SlideRequest unselectDisplayOrder(){
          return unselect(DISPLAY_ORDER_PROPERTY);
      }

      public SearchCriteria getDisplayOrderSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(DISPLAY_ORDER_PROPERTY, pQueryOperator, parameters);
      }

      public SlideRequest orderByDisplayOrder(boolean asc){
          addOrderBy(DISPLAY_ORDER_PROPERTY, asc);
          return this;
      }
   
      public SlideRequest filterByImageUrl(String imageUrl) {
          
          if (imageUrl == null) {
              return this;
          }
          
          return filterByImageUrl(QueryOperator.EQUAL, imageUrl);
      }
    

      public SlideRequest filterByImageUrl(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getImageUrlSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SlideRequest selectImageUrl(){
          return select(IMAGE_URL_PROPERTY);
      }

      public SlideRequest unselectImageUrl(){
          return unselect(IMAGE_URL_PROPERTY);
      }

      public SearchCriteria getImageUrlSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(IMAGE_URL_PROPERTY, pQueryOperator, parameters);
      }

      public SlideRequest orderByImageUrl(boolean asc){
          addOrderBy(IMAGE_URL_PROPERTY, asc);
          return this;
      }
   
      public SlideRequest filterByVideoUrl(String videoUrl) {
          
          if (videoUrl == null) {
              return this;
          }
          
          return filterByVideoUrl(QueryOperator.EQUAL, videoUrl);
      }
    

      public SlideRequest filterByVideoUrl(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVideoUrlSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SlideRequest selectVideoUrl(){
          return select(VIDEO_URL_PROPERTY);
      }

      public SlideRequest unselectVideoUrl(){
          return unselect(VIDEO_URL_PROPERTY);
      }

      public SearchCriteria getVideoUrlSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VIDEO_URL_PROPERTY, pQueryOperator, parameters);
      }

      public SlideRequest orderByVideoUrl(boolean asc){
          addOrderBy(VIDEO_URL_PROPERTY, asc);
          return this;
      }
   
      public SlideRequest filterByLinkToUrl(String linkToUrl) {
          
          if (linkToUrl == null) {
              return this;
          }
          
          return filterByLinkToUrl(QueryOperator.EQUAL, linkToUrl);
      }
    

      public SlideRequest filterByLinkToUrl(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLinkToUrlSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SlideRequest selectLinkToUrl(){
          return select(LINK_TO_URL_PROPERTY);
      }

      public SlideRequest unselectLinkToUrl(){
          return unselect(LINK_TO_URL_PROPERTY);
      }

      public SearchCriteria getLinkToUrlSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LINK_TO_URL_PROPERTY, pQueryOperator, parameters);
      }

      public SlideRequest orderByLinkToUrl(boolean asc){
          addOrderBy(LINK_TO_URL_PROPERTY, asc);
          return this;
      }
   
      public SlideRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public SlideRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SlideRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public SlideRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public SlideRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public SlideRequest filterByPage(PageRequest page){
        return filterByPage(page, pageList -> pageList.stream().map(Page::getId).collect(Collectors.toSet()));
    }

    public SlideRequest filterByPage(PageRequest page, IDRefine<Page> idRefine) {
        return addSearchCriteria(createPageCriteria(page, idRefine));
    }

    public SearchCriteria createPageCriteria(PageRequest page, IDRefine<Page> idRefine) {
        return new RefinedIdInCriteria(page, PAGE_PROPERTY, idRefine);
    }
    

    
    public SlideRequest selectPage(){
        return selectPage(PageRequest.newInstance().selectSelf());
    }

    public SlideRequest selectPage(PageRequest page){
        selectParent(PAGE_PROPERTY, page);
        return this;
    }
    

    public SlideRequest unselectPage(){
        unselectParent(PAGE_PROPERTY);
        return this;
    }

  


  

   public SlideRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

