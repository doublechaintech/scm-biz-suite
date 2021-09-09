package com.doublechaintech.retailscm.stockcountissuetrack;

import com.doublechaintech.retailscm.search.*;
import java.util.Date;
import com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCount;
import com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCountRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.stockcountissuetrack.StockCountIssueTrack.*;

public class StockCountIssueTrackRequest extends BaseRequest<StockCountIssueTrack> {
    public static StockCountIssueTrackRequest newInstance() {
        return new StockCountIssueTrackRequest().selectId();
    }

    public String getInternalType() {
        return "StockCountIssueTrack";
    }

    public StockCountIssueTrackRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public StockCountIssueTrackRequest select(String... names) {
        super.select(names);
        return this;
    }

    public StockCountIssueTrackRequest selectAll() {return this.selectId().selectTitle().selectCountTime().selectSummary().selectStockCount().selectVersion();
    }

    public StockCountIssueTrackRequest selectSelf() {return this.selectId().selectTitle().selectCountTime().selectSummary().selectVersion();
    }

    public StockCountIssueTrackRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public StockCountIssueTrackRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static StockCountIssueTrackRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public StockCountIssueTrackRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public StockCountIssueTrackRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public StockCountIssueTrackRequest selectId(){
          return select(ID_PROPERTY);
      }

      public StockCountIssueTrackRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public StockCountIssueTrackRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public StockCountIssueTrackRequest filterByTitle(String title) {
          
          if (title == null) {
              return this;
          }
          
          return filterByTitle(QueryOperator.EQUAL, title);
      }
    

      public StockCountIssueTrackRequest filterByTitle(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getTitleSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public StockCountIssueTrackRequest selectTitle(){
          return select(TITLE_PROPERTY);
      }

      public StockCountIssueTrackRequest unselectTitle(){
          return unselect(TITLE_PROPERTY);
      }

      public SearchCriteria getTitleSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(TITLE_PROPERTY, pQueryOperator, parameters);
      }

      public StockCountIssueTrackRequest orderByTitle(boolean asc){
          addOrderBy(TITLE_PROPERTY, asc);
          return this;
      }
   
      public StockCountIssueTrackRequest filterByCountTime(Date countTime) {
          
          if (countTime == null) {
              return this;
          }
          
          return filterByCountTime(QueryOperator.EQUAL, countTime);
      }
    

      public StockCountIssueTrackRequest filterByCountTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getCountTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public StockCountIssueTrackRequest selectCountTime(){
          return select(COUNT_TIME_PROPERTY);
      }

      public StockCountIssueTrackRequest unselectCountTime(){
          return unselect(COUNT_TIME_PROPERTY);
      }

      public SearchCriteria getCountTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(COUNT_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public StockCountIssueTrackRequest orderByCountTime(boolean asc){
          addOrderBy(COUNT_TIME_PROPERTY, asc);
          return this;
      }
   
      public StockCountIssueTrackRequest filterBySummary(String summary) {
          
          if (summary == null) {
              return this;
          }
          
          return filterBySummary(QueryOperator.EQUAL, summary);
      }
    

      public StockCountIssueTrackRequest filterBySummary(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getSummarySearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public StockCountIssueTrackRequest selectSummary(){
          return select(SUMMARY_PROPERTY);
      }

      public StockCountIssueTrackRequest unselectSummary(){
          return unselect(SUMMARY_PROPERTY);
      }

      public SearchCriteria getSummarySearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(SUMMARY_PROPERTY, pQueryOperator, parameters);
      }

      public StockCountIssueTrackRequest orderBySummary(boolean asc){
          addOrderBy(SUMMARY_PROPERTY, asc);
          return this;
      }
   
      public StockCountIssueTrackRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public StockCountIssueTrackRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public StockCountIssueTrackRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public StockCountIssueTrackRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public StockCountIssueTrackRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public StockCountIssueTrackRequest filterByStockCount(GoodsShelfStockCountRequest stockCount){
        return filterByStockCount(stockCount, stockCountList -> stockCountList.stream().map(GoodsShelfStockCount::getId).collect(Collectors.toSet()));
    }

    public StockCountIssueTrackRequest filterByStockCount(GoodsShelfStockCountRequest stockCount, IDRefine<GoodsShelfStockCount> idRefine) {
        return addSearchCriteria(createStockCountCriteria(stockCount, idRefine));
    }

    public SearchCriteria createStockCountCriteria(GoodsShelfStockCountRequest stockCount, IDRefine<GoodsShelfStockCount> idRefine) {
        return new RefinedIdInCriteria(stockCount, STOCK_COUNT_PROPERTY, idRefine);
    }
    

    
    public StockCountIssueTrackRequest selectStockCount(){
        return selectStockCount(GoodsShelfStockCountRequest.newInstance().selectSelf());
    }

    public StockCountIssueTrackRequest selectStockCount(GoodsShelfStockCountRequest stockCount){
        selectParent(STOCK_COUNT_PROPERTY, stockCount);
        return this;
    }
    

    public StockCountIssueTrackRequest unselectStockCount(){
        unselectParent(STOCK_COUNT_PROPERTY);
        return this;
    }

  


  

   public StockCountIssueTrackRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

