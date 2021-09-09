package com.doublechaintech.retailscm.supplyorderpaymentgroup;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.supplyorder.SupplyOrder;
import com.doublechaintech.retailscm.supplyorder.SupplyOrderRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.supplyorderpaymentgroup.SupplyOrderPaymentGroup.*;

public class SupplyOrderPaymentGroupRequest extends BaseRequest<SupplyOrderPaymentGroup> {
    public static SupplyOrderPaymentGroupRequest newInstance() {
        return new SupplyOrderPaymentGroupRequest().selectId();
    }

    public String getInternalType() {
        return "SupplyOrderPaymentGroup";
    }

    public SupplyOrderPaymentGroupRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public SupplyOrderPaymentGroupRequest select(String... names) {
        super.select(names);
        return this;
    }

    public SupplyOrderPaymentGroupRequest selectAll() {return this.selectId().selectName().selectBizOrder().selectCardNumber().selectVersion();
    }

    public SupplyOrderPaymentGroupRequest selectSelf() {return this.selectId().selectName().selectCardNumber().selectVersion();
    }

    public SupplyOrderPaymentGroupRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public SupplyOrderPaymentGroupRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static SupplyOrderPaymentGroupRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public SupplyOrderPaymentGroupRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public SupplyOrderPaymentGroupRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SupplyOrderPaymentGroupRequest selectId(){
          return select(ID_PROPERTY);
      }

      public SupplyOrderPaymentGroupRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public SupplyOrderPaymentGroupRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public SupplyOrderPaymentGroupRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public SupplyOrderPaymentGroupRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SupplyOrderPaymentGroupRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public SupplyOrderPaymentGroupRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public SupplyOrderPaymentGroupRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public SupplyOrderPaymentGroupRequest filterByCardNumber(String cardNumber) {
          
          if (cardNumber == null) {
              return this;
          }
          
          return filterByCardNumber(QueryOperator.EQUAL, cardNumber);
      }
    

      public SupplyOrderPaymentGroupRequest filterByCardNumber(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getCardNumberSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SupplyOrderPaymentGroupRequest selectCardNumber(){
          return select(CARD_NUMBER_PROPERTY);
      }

      public SupplyOrderPaymentGroupRequest unselectCardNumber(){
          return unselect(CARD_NUMBER_PROPERTY);
      }

      public SearchCriteria getCardNumberSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(CARD_NUMBER_PROPERTY, pQueryOperator, parameters);
      }

      public SupplyOrderPaymentGroupRequest orderByCardNumber(boolean asc){
          addOrderBy(CARD_NUMBER_PROPERTY, asc);
          return this;
      }
   
      public SupplyOrderPaymentGroupRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public SupplyOrderPaymentGroupRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SupplyOrderPaymentGroupRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public SupplyOrderPaymentGroupRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public SupplyOrderPaymentGroupRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public SupplyOrderPaymentGroupRequest filterByBizOrder(SupplyOrderRequest bizOrder){
        return filterByBizOrder(bizOrder, bizOrderList -> bizOrderList.stream().map(SupplyOrder::getId).collect(Collectors.toSet()));
    }

    public SupplyOrderPaymentGroupRequest filterByBizOrder(SupplyOrderRequest bizOrder, IDRefine<SupplyOrder> idRefine) {
        return addSearchCriteria(createBizOrderCriteria(bizOrder, idRefine));
    }

    public SearchCriteria createBizOrderCriteria(SupplyOrderRequest bizOrder, IDRefine<SupplyOrder> idRefine) {
        return new RefinedIdInCriteria(bizOrder, BIZ_ORDER_PROPERTY, idRefine);
    }
    

    
    public SupplyOrderPaymentGroupRequest selectBizOrder(){
        return selectBizOrder(SupplyOrderRequest.newInstance().selectSelf());
    }

    public SupplyOrderPaymentGroupRequest selectBizOrder(SupplyOrderRequest bizOrder){
        selectParent(BIZ_ORDER_PROPERTY, bizOrder);
        return this;
    }
    

    public SupplyOrderPaymentGroupRequest unselectBizOrder(){
        unselectParent(BIZ_ORDER_PROPERTY);
        return this;
    }

  


  

   public SupplyOrderPaymentGroupRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

