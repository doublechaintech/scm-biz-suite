package com.doublechaintech.retailscm.goodsmovement;

import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.goods.GoodsRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.goodsmovement.GoodsMovement.*;

public class GoodsMovementRequest extends BaseRequest<GoodsMovement> {
    public static GoodsMovementRequest newInstance() {
        return new GoodsMovementRequest().selectId();
    }

    public String getInternalType() {
        return "GoodsMovement";
    }

    public GoodsMovementRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public GoodsMovementRequest select(String... names) {
        super.select(names);
        return this;
    }

    public GoodsMovementRequest selectAll() {return this.selectId().selectMoveTime().selectFacility().selectFacilityId().selectFromIp().selectUserAgent().selectSessionId().selectLatitude().selectLongitude().selectGoods().selectVersion();
    }

    public GoodsMovementRequest selectSelf() {return this.selectId().selectMoveTime().selectFacility().selectFacilityId().selectFromIp().selectUserAgent().selectSessionId().selectLatitude().selectLongitude().selectVersion();
    }

    public GoodsMovementRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public GoodsMovementRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static GoodsMovementRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public GoodsMovementRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public GoodsMovementRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public GoodsMovementRequest selectId(){
          return select(ID_PROPERTY);
      }

      public GoodsMovementRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public GoodsMovementRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public GoodsMovementRequest filterByMoveTime(DateTime moveTime) {
          
          if (moveTime == null) {
              return this;
          }
          
          return filterByMoveTime(QueryOperator.EQUAL, moveTime);
      }
    

      public GoodsMovementRequest filterByMoveTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getMoveTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public GoodsMovementRequest selectMoveTime(){
          return select(MOVE_TIME_PROPERTY);
      }

      public GoodsMovementRequest unselectMoveTime(){
          return unselect(MOVE_TIME_PROPERTY);
      }

      public SearchCriteria getMoveTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(MOVE_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public GoodsMovementRequest orderByMoveTime(boolean asc){
          addOrderBy(MOVE_TIME_PROPERTY, asc);
          return this;
      }
   
      public GoodsMovementRequest filterByFacility(String facility) {
          
          if (facility == null) {
              return this;
          }
          
          return filterByFacility(QueryOperator.EQUAL, facility);
      }
    

      public GoodsMovementRequest filterByFacility(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getFacilitySearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public GoodsMovementRequest selectFacility(){
          return select(FACILITY_PROPERTY);
      }

      public GoodsMovementRequest unselectFacility(){
          return unselect(FACILITY_PROPERTY);
      }

      public SearchCriteria getFacilitySearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(FACILITY_PROPERTY, pQueryOperator, parameters);
      }

      public GoodsMovementRequest orderByFacility(boolean asc){
          addOrderBy(FACILITY_PROPERTY, asc);
          return this;
      }
   
      public GoodsMovementRequest filterByFacilityId(String facilityId) {
          
          if (facilityId == null) {
              return this;
          }
          
          return filterByFacilityId(QueryOperator.EQUAL, facilityId);
      }
    

      public GoodsMovementRequest filterByFacilityId(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getFacilityIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public GoodsMovementRequest selectFacilityId(){
          return select(FACILITY_ID_PROPERTY);
      }

      public GoodsMovementRequest unselectFacilityId(){
          return unselect(FACILITY_ID_PROPERTY);
      }

      public SearchCriteria getFacilityIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(FACILITY_ID_PROPERTY, pQueryOperator, parameters);
      }

      public GoodsMovementRequest orderByFacilityId(boolean asc){
          addOrderBy(FACILITY_ID_PROPERTY, asc);
          return this;
      }
   
      public GoodsMovementRequest filterByFromIp(String fromIp) {
          
          if (fromIp == null) {
              return this;
          }
          
          return filterByFromIp(QueryOperator.EQUAL, fromIp);
      }
    

      public GoodsMovementRequest filterByFromIp(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getFromIpSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public GoodsMovementRequest selectFromIp(){
          return select(FROM_IP_PROPERTY);
      }

      public GoodsMovementRequest unselectFromIp(){
          return unselect(FROM_IP_PROPERTY);
      }

      public SearchCriteria getFromIpSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(FROM_IP_PROPERTY, pQueryOperator, parameters);
      }

      public GoodsMovementRequest orderByFromIp(boolean asc){
          addOrderBy(FROM_IP_PROPERTY, asc);
          return this;
      }
   
      public GoodsMovementRequest filterByUserAgent(String userAgent) {
          
          if (userAgent == null) {
              return this;
          }
          
          return filterByUserAgent(QueryOperator.EQUAL, userAgent);
      }
    

      public GoodsMovementRequest filterByUserAgent(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getUserAgentSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public GoodsMovementRequest selectUserAgent(){
          return select(USER_AGENT_PROPERTY);
      }

      public GoodsMovementRequest unselectUserAgent(){
          return unselect(USER_AGENT_PROPERTY);
      }

      public SearchCriteria getUserAgentSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(USER_AGENT_PROPERTY, pQueryOperator, parameters);
      }

      public GoodsMovementRequest orderByUserAgent(boolean asc){
          addOrderBy(USER_AGENT_PROPERTY, asc);
          return this;
      }
   
      public GoodsMovementRequest filterBySessionId(String sessionId) {
          
          if (sessionId == null) {
              return this;
          }
          
          return filterBySessionId(QueryOperator.EQUAL, sessionId);
      }
    

      public GoodsMovementRequest filterBySessionId(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getSessionIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public GoodsMovementRequest selectSessionId(){
          return select(SESSION_ID_PROPERTY);
      }

      public GoodsMovementRequest unselectSessionId(){
          return unselect(SESSION_ID_PROPERTY);
      }

      public SearchCriteria getSessionIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(SESSION_ID_PROPERTY, pQueryOperator, parameters);
      }

      public GoodsMovementRequest orderBySessionId(boolean asc){
          addOrderBy(SESSION_ID_PROPERTY, asc);
          return this;
      }
   
      public GoodsMovementRequest filterByLatitude(BigDecimal latitude) {
          
          if (latitude == null) {
              return this;
          }
          
          return filterByLatitude(QueryOperator.EQUAL, latitude);
      }
    

      public GoodsMovementRequest filterByLatitude(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLatitudeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public GoodsMovementRequest selectLatitude(){
          return select(LATITUDE_PROPERTY);
      }

      public GoodsMovementRequest unselectLatitude(){
          return unselect(LATITUDE_PROPERTY);
      }

      public SearchCriteria getLatitudeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LATITUDE_PROPERTY, pQueryOperator, parameters);
      }

      public GoodsMovementRequest orderByLatitude(boolean asc){
          addOrderBy(LATITUDE_PROPERTY, asc);
          return this;
      }
   
      public GoodsMovementRequest filterByLongitude(BigDecimal longitude) {
          
          if (longitude == null) {
              return this;
          }
          
          return filterByLongitude(QueryOperator.EQUAL, longitude);
      }
    

      public GoodsMovementRequest filterByLongitude(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLongitudeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public GoodsMovementRequest selectLongitude(){
          return select(LONGITUDE_PROPERTY);
      }

      public GoodsMovementRequest unselectLongitude(){
          return unselect(LONGITUDE_PROPERTY);
      }

      public SearchCriteria getLongitudeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LONGITUDE_PROPERTY, pQueryOperator, parameters);
      }

      public GoodsMovementRequest orderByLongitude(boolean asc){
          addOrderBy(LONGITUDE_PROPERTY, asc);
          return this;
      }
   
      public GoodsMovementRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public GoodsMovementRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public GoodsMovementRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public GoodsMovementRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public GoodsMovementRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public GoodsMovementRequest filterByGoods(GoodsRequest goods){
        return filterByGoods(goods, goodsList -> goodsList.stream().map(Goods::getId).collect(Collectors.toSet()));
    }

    public GoodsMovementRequest filterByGoods(GoodsRequest goods, IDRefine<Goods> idRefine) {
        return addSearchCriteria(createGoodsCriteria(goods, idRefine));
    }

    public SearchCriteria createGoodsCriteria(GoodsRequest goods, IDRefine<Goods> idRefine) {
        return new RefinedIdInCriteria(goods, GOODS_PROPERTY, idRefine);
    }
    

    
    public GoodsMovementRequest selectGoods(){
        return selectGoods(GoodsRequest.newInstance().selectSelf());
    }

    public GoodsMovementRequest selectGoods(GoodsRequest goods){
        selectParent(GOODS_PROPERTY, goods);
        return this;
    }
    

    public GoodsMovementRequest unselectGoods(){
        unselectParent(GOODS_PROPERTY);
        return this;
    }

  


  

   public GoodsMovementRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

