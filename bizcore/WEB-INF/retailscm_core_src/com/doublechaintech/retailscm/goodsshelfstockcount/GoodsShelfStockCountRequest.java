package com.doublechaintech.retailscm.goodsshelfstockcount;

import com.doublechaintech.retailscm.search.*;
import java.util.Date;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelf;
import com.doublechaintech.retailscm.stockcountissuetrack.StockCountIssueTrack;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelfRequest;
import com.doublechaintech.retailscm.stockcountissuetrack.StockCountIssueTrackRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCount.*;

public class GoodsShelfStockCountRequest extends BaseRequest<GoodsShelfStockCount> {
    public static GoodsShelfStockCountRequest newInstance() {
        return new GoodsShelfStockCountRequest().selectId();
    }

    public String getInternalType() {
        return "GoodsShelfStockCount";
    }

    public GoodsShelfStockCountRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public GoodsShelfStockCountRequest select(String... names) {
        super.select(names);
        return this;
    }

    public GoodsShelfStockCountRequest selectAll() {return this.selectId().selectTitle().selectCountTime().selectSummary().selectShelf().selectVersion();
    }

    public GoodsShelfStockCountRequest selectSelf() {return this.selectId().selectTitle().selectCountTime().selectSummary().selectVersion();
    }

    public GoodsShelfStockCountRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public GoodsShelfStockCountRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static GoodsShelfStockCountRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public GoodsShelfStockCountRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public GoodsShelfStockCountRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public GoodsShelfStockCountRequest selectId(){
          return select(ID_PROPERTY);
      }

      public GoodsShelfStockCountRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public GoodsShelfStockCountRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public GoodsShelfStockCountRequest filterByTitle(String title) {
          
          if (title == null) {
              return this;
          }
          
          return filterByTitle(QueryOperator.EQUAL, title);
      }
    

      public GoodsShelfStockCountRequest filterByTitle(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getTitleSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public GoodsShelfStockCountRequest selectTitle(){
          return select(TITLE_PROPERTY);
      }

      public GoodsShelfStockCountRequest unselectTitle(){
          return unselect(TITLE_PROPERTY);
      }

      public SearchCriteria getTitleSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(TITLE_PROPERTY, pQueryOperator, parameters);
      }

      public GoodsShelfStockCountRequest orderByTitle(boolean asc){
          addOrderBy(TITLE_PROPERTY, asc);
          return this;
      }
   
      public GoodsShelfStockCountRequest filterByCountTime(Date countTime) {
          
          if (countTime == null) {
              return this;
          }
          
          return filterByCountTime(QueryOperator.EQUAL, countTime);
      }
    

      public GoodsShelfStockCountRequest filterByCountTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getCountTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public GoodsShelfStockCountRequest selectCountTime(){
          return select(COUNT_TIME_PROPERTY);
      }

      public GoodsShelfStockCountRequest unselectCountTime(){
          return unselect(COUNT_TIME_PROPERTY);
      }

      public SearchCriteria getCountTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(COUNT_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public GoodsShelfStockCountRequest orderByCountTime(boolean asc){
          addOrderBy(COUNT_TIME_PROPERTY, asc);
          return this;
      }
   
      public GoodsShelfStockCountRequest filterBySummary(String summary) {
          
          if (summary == null) {
              return this;
          }
          
          return filterBySummary(QueryOperator.EQUAL, summary);
      }
    

      public GoodsShelfStockCountRequest filterBySummary(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getSummarySearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public GoodsShelfStockCountRequest selectSummary(){
          return select(SUMMARY_PROPERTY);
      }

      public GoodsShelfStockCountRequest unselectSummary(){
          return unselect(SUMMARY_PROPERTY);
      }

      public SearchCriteria getSummarySearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(SUMMARY_PROPERTY, pQueryOperator, parameters);
      }

      public GoodsShelfStockCountRequest orderBySummary(boolean asc){
          addOrderBy(SUMMARY_PROPERTY, asc);
          return this;
      }
   
      public GoodsShelfStockCountRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public GoodsShelfStockCountRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public GoodsShelfStockCountRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public GoodsShelfStockCountRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public GoodsShelfStockCountRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public GoodsShelfStockCountRequest filterByShelf(GoodsShelfRequest shelf){
        return filterByShelf(shelf, shelfList -> shelfList.stream().map(GoodsShelf::getId).collect(Collectors.toSet()));
    }

    public GoodsShelfStockCountRequest filterByShelf(GoodsShelfRequest shelf, IDRefine<GoodsShelf> idRefine) {
        return addSearchCriteria(createShelfCriteria(shelf, idRefine));
    }

    public SearchCriteria createShelfCriteria(GoodsShelfRequest shelf, IDRefine<GoodsShelf> idRefine) {
        return new RefinedIdInCriteria(shelf, SHELF_PROPERTY, idRefine);
    }
    

    
    public GoodsShelfStockCountRequest selectShelf(){
        return selectShelf(GoodsShelfRequest.newInstance().selectSelf());
    }

    public GoodsShelfStockCountRequest selectShelf(GoodsShelfRequest shelf){
        selectParent(SHELF_PROPERTY, shelf);
        return this;
    }
    

    public GoodsShelfStockCountRequest unselectShelf(){
        unselectParent(SHELF_PROPERTY);
        return this;
    }

  


  

    public GoodsShelfStockCountRequest hasStockCountIssueTrack() {
      return hasStockCountIssueTrack(StockCountIssueTrackRequest.newInstance());
    }

    public GoodsShelfStockCountRequest hasStockCountIssueTrack(StockCountIssueTrackRequest stockCountIssueTrack) {
        return hasStockCountIssueTrack(stockCountIssueTrack, stockCountIssueTrackList -> stockCountIssueTrackList.stream().map(StockCountIssueTrack::getStockCount).map(GoodsShelfStockCount::getId).collect(Collectors.toSet()));
    }

    public GoodsShelfStockCountRequest hasStockCountIssueTrack(StockCountIssueTrackRequest stockCountIssueTrack, IDRefine<StockCountIssueTrack> idRefine) {
        stockCountIssueTrack.select(StockCountIssueTrack.STOCK_COUNT_PROPERTY);
        return addSearchCriteria(createStockCountIssueTrackCriteria(stockCountIssueTrack, idRefine));
    }

    public SearchCriteria createStockCountIssueTrackCriteria(StockCountIssueTrackRequest stockCountIssueTrack, IDRefine<StockCountIssueTrack> idRefine){
       return new RefinedIdInCriteria(stockCountIssueTrack, ID_PROPERTY, idRefine);
    }

    public GoodsShelfStockCountRequest selectStockCountIssueTrackList(StockCountIssueTrackRequest stockCountIssueTrack) {
        selectChild(StockCountIssueTrack.STOCK_COUNT_PROPERTY, stockCountIssueTrack);
        return this;
    }

    public GoodsShelfStockCountRequest selectStockCountIssueTrackList() {
        return selectStockCountIssueTrackList(StockCountIssueTrackRequest.newInstance().selectAll());
    }

    public GoodsShelfStockCountRequest unselectStockCountIssueTrackList(){
        unselectChild(StockCountIssueTrack.STOCK_COUNT_PROPERTY, StockCountIssueTrack.class);
        return this;
    }
  

   public GoodsShelfStockCountRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

