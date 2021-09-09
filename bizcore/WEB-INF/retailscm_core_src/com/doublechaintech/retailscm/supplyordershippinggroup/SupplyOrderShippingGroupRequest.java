package com.doublechaintech.retailscm.supplyordershippinggroup;

import com.doublechaintech.retailscm.search.*;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;
import com.doublechaintech.retailscm.supplyorder.SupplyOrderRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.supplyordershippinggroup.SupplyOrderShippingGroup.*;

public class SupplyOrderShippingGroupRequest extends BaseRequest<SupplyOrderShippingGroup> {
    public static SupplyOrderShippingGroupRequest newInstance() {
        return new SupplyOrderShippingGroupRequest().selectId();
    }

    public String getInternalType() {
        return "SupplyOrderShippingGroup";
    }

    public SupplyOrderShippingGroupRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public SupplyOrderShippingGroupRequest select(String... names) {
        super.select(names);
        return this;
    }

    public SupplyOrderShippingGroupRequest selectAll() {return this.selectId().selectName().selectBizOrder().selectAmount().selectVersion();
    }

    public SupplyOrderShippingGroupRequest selectSelf() {return this.selectId().selectName().selectAmount().selectVersion();
    }

    public SupplyOrderShippingGroupRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public SupplyOrderShippingGroupRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static SupplyOrderShippingGroupRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public SupplyOrderShippingGroupRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public SupplyOrderShippingGroupRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SupplyOrderShippingGroupRequest selectId(){
          return select(ID_PROPERTY);
      }

      public SupplyOrderShippingGroupRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public SupplyOrderShippingGroupRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public SupplyOrderShippingGroupRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public SupplyOrderShippingGroupRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SupplyOrderShippingGroupRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public SupplyOrderShippingGroupRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public SupplyOrderShippingGroupRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public SupplyOrderShippingGroupRequest filterByAmount(BigDecimal amount) {
          
          if (amount == null) {
              return this;
          }
          
          return filterByAmount(QueryOperator.EQUAL, amount);
      }
    

      public SupplyOrderShippingGroupRequest filterByAmount(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getAmountSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SupplyOrderShippingGroupRequest selectAmount(){
          return select(AMOUNT_PROPERTY);
      }

      public SupplyOrderShippingGroupRequest unselectAmount(){
          return unselect(AMOUNT_PROPERTY);
      }

      public SearchCriteria getAmountSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(AMOUNT_PROPERTY, pQueryOperator, parameters);
      }

      public SupplyOrderShippingGroupRequest orderByAmount(boolean asc){
          addOrderBy(AMOUNT_PROPERTY, asc);
          return this;
      }
   
      public SupplyOrderShippingGroupRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public SupplyOrderShippingGroupRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SupplyOrderShippingGroupRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public SupplyOrderShippingGroupRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public SupplyOrderShippingGroupRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public SupplyOrderShippingGroupRequest filterByBizOrder(SupplyOrderRequest bizOrder){
        return filterByBizOrder(bizOrder, bizOrderList -> bizOrderList.stream().map(SupplyOrder::getId).collect(Collectors.toSet()));
    }

    public SupplyOrderShippingGroupRequest filterByBizOrder(SupplyOrderRequest bizOrder, IDRefine<SupplyOrder> idRefine) {
        return addSearchCriteria(createBizOrderCriteria(bizOrder, idRefine));
    }

    public SearchCriteria createBizOrderCriteria(SupplyOrderRequest bizOrder, IDRefine<SupplyOrder> idRefine) {
        return new RefinedIdInCriteria(bizOrder, BIZ_ORDER_PROPERTY, idRefine);
    }
    

    
    public SupplyOrderShippingGroupRequest selectBizOrder(){
        return selectBizOrder(SupplyOrderRequest.newInstance().selectSelf());
    }

    public SupplyOrderShippingGroupRequest selectBizOrder(SupplyOrderRequest bizOrder){
        selectParent(BIZ_ORDER_PROPERTY, bizOrder);
        return this;
    }
    

    public SupplyOrderShippingGroupRequest unselectBizOrder(){
        unselectParent(BIZ_ORDER_PROPERTY);
        return this;
    }

  


  

   public SupplyOrderShippingGroupRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

