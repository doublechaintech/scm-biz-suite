package com.doublechaintech.retailscm.goodsallocation;

import com.doublechaintech.retailscm.search.*;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelf;
import com.doublechaintech.retailscm.goods.GoodsRequest;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelfRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.goodsallocation.GoodsAllocation.*;

public class GoodsAllocationRequest extends BaseRequest<GoodsAllocation> {
    public static GoodsAllocationRequest newInstance() {
        return new GoodsAllocationRequest().selectId();
    }

    public String getInternalType() {
        return "GoodsAllocation";
    }

    public GoodsAllocationRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public GoodsAllocationRequest select(String... names) {
        super.select(names);
        return this;
    }

    public GoodsAllocationRequest selectAll() {return this.selectId().selectLocation().selectLatitude().selectLongitude().selectGoodsShelf().selectVersion();
    }

    public GoodsAllocationRequest selectSelf() {return this.selectId().selectLocation().selectLatitude().selectLongitude().selectVersion();
    }

    public GoodsAllocationRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public GoodsAllocationRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static GoodsAllocationRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public GoodsAllocationRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public GoodsAllocationRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public GoodsAllocationRequest selectId(){
          return select(ID_PROPERTY);
      }

      public GoodsAllocationRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public GoodsAllocationRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public GoodsAllocationRequest filterByLocation(String location) {
          
          if (location == null) {
              return this;
          }
          
          return filterByLocation(QueryOperator.EQUAL, location);
      }
    

      public GoodsAllocationRequest filterByLocation(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLocationSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public GoodsAllocationRequest selectLocation(){
          return select(LOCATION_PROPERTY);
      }

      public GoodsAllocationRequest unselectLocation(){
          return unselect(LOCATION_PROPERTY);
      }

      public SearchCriteria getLocationSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LOCATION_PROPERTY, pQueryOperator, parameters);
      }

      public GoodsAllocationRequest orderByLocation(boolean asc){
          addOrderBy(LOCATION_PROPERTY, asc);
          return this;
      }
   
      public GoodsAllocationRequest filterByLatitude(BigDecimal latitude) {
          
          if (latitude == null) {
              return this;
          }
          
          return filterByLatitude(QueryOperator.EQUAL, latitude);
      }
    

      public GoodsAllocationRequest filterByLatitude(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLatitudeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public GoodsAllocationRequest selectLatitude(){
          return select(LATITUDE_PROPERTY);
      }

      public GoodsAllocationRequest unselectLatitude(){
          return unselect(LATITUDE_PROPERTY);
      }

      public SearchCriteria getLatitudeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LATITUDE_PROPERTY, pQueryOperator, parameters);
      }

      public GoodsAllocationRequest orderByLatitude(boolean asc){
          addOrderBy(LATITUDE_PROPERTY, asc);
          return this;
      }
   
      public GoodsAllocationRequest filterByLongitude(BigDecimal longitude) {
          
          if (longitude == null) {
              return this;
          }
          
          return filterByLongitude(QueryOperator.EQUAL, longitude);
      }
    

      public GoodsAllocationRequest filterByLongitude(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLongitudeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public GoodsAllocationRequest selectLongitude(){
          return select(LONGITUDE_PROPERTY);
      }

      public GoodsAllocationRequest unselectLongitude(){
          return unselect(LONGITUDE_PROPERTY);
      }

      public SearchCriteria getLongitudeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LONGITUDE_PROPERTY, pQueryOperator, parameters);
      }

      public GoodsAllocationRequest orderByLongitude(boolean asc){
          addOrderBy(LONGITUDE_PROPERTY, asc);
          return this;
      }
   
      public GoodsAllocationRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public GoodsAllocationRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public GoodsAllocationRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public GoodsAllocationRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public GoodsAllocationRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public GoodsAllocationRequest filterByGoodsShelf(GoodsShelfRequest goodsShelf){
        return filterByGoodsShelf(goodsShelf, goodsShelfList -> goodsShelfList.stream().map(GoodsShelf::getId).collect(Collectors.toSet()));
    }

    public GoodsAllocationRequest filterByGoodsShelf(GoodsShelfRequest goodsShelf, IDRefine<GoodsShelf> idRefine) {
        return addSearchCriteria(createGoodsShelfCriteria(goodsShelf, idRefine));
    }

    public SearchCriteria createGoodsShelfCriteria(GoodsShelfRequest goodsShelf, IDRefine<GoodsShelf> idRefine) {
        return new RefinedIdInCriteria(goodsShelf, GOODS_SHELF_PROPERTY, idRefine);
    }
    

    
    public GoodsAllocationRequest selectGoodsShelf(){
        return selectGoodsShelf(GoodsShelfRequest.newInstance().selectSelf());
    }

    public GoodsAllocationRequest selectGoodsShelf(GoodsShelfRequest goodsShelf){
        selectParent(GOODS_SHELF_PROPERTY, goodsShelf);
        return this;
    }
    

    public GoodsAllocationRequest unselectGoodsShelf(){
        unselectParent(GOODS_SHELF_PROPERTY);
        return this;
    }

  


  

    public GoodsAllocationRequest hasGoods() {
      return hasGoods(GoodsRequest.newInstance());
    }

    public GoodsAllocationRequest hasGoods(GoodsRequest goods) {
        return hasGoods(goods, goodsList -> goodsList.stream().map(Goods::getGoodsAllocation).map(GoodsAllocation::getId).collect(Collectors.toSet()));
    }

    public GoodsAllocationRequest hasGoods(GoodsRequest goods, IDRefine<Goods> idRefine) {
        goods.select(Goods.GOODS_ALLOCATION_PROPERTY);
        return addSearchCriteria(createGoodsCriteria(goods, idRefine));
    }

    public SearchCriteria createGoodsCriteria(GoodsRequest goods, IDRefine<Goods> idRefine){
       return new RefinedIdInCriteria(goods, ID_PROPERTY, idRefine);
    }

    public GoodsAllocationRequest selectGoodsList(GoodsRequest goods) {
        selectChild(Goods.GOODS_ALLOCATION_PROPERTY, goods);
        return this;
    }

    public GoodsAllocationRequest selectGoodsList() {
        return selectGoodsList(GoodsRequest.newInstance().selectAll());
    }

    public GoodsAllocationRequest unselectGoodsList(){
        unselectChild(Goods.GOODS_ALLOCATION_PROPERTY, Goods.class);
        return this;
    }
  

   public GoodsAllocationRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

