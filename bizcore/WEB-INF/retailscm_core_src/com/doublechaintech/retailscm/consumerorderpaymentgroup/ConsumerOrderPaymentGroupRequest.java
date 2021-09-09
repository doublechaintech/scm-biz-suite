package com.doublechaintech.retailscm.consumerorderpaymentgroup;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrderRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.consumerorderpaymentgroup.ConsumerOrderPaymentGroup.*;

public class ConsumerOrderPaymentGroupRequest extends BaseRequest<ConsumerOrderPaymentGroup> {
    public static ConsumerOrderPaymentGroupRequest newInstance() {
        return new ConsumerOrderPaymentGroupRequest().selectId();
    }

    public String getInternalType() {
        return "ConsumerOrderPaymentGroup";
    }

    public ConsumerOrderPaymentGroupRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public ConsumerOrderPaymentGroupRequest select(String... names) {
        super.select(names);
        return this;
    }

    public ConsumerOrderPaymentGroupRequest selectAll() {return this.selectId().selectName().selectBizOrder().selectCardNumber().selectVersion();
    }

    public ConsumerOrderPaymentGroupRequest selectSelf() {return this.selectId().selectName().selectCardNumber().selectVersion();
    }

    public ConsumerOrderPaymentGroupRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public ConsumerOrderPaymentGroupRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static ConsumerOrderPaymentGroupRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public ConsumerOrderPaymentGroupRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public ConsumerOrderPaymentGroupRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ConsumerOrderPaymentGroupRequest selectId(){
          return select(ID_PROPERTY);
      }

      public ConsumerOrderPaymentGroupRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public ConsumerOrderPaymentGroupRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public ConsumerOrderPaymentGroupRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public ConsumerOrderPaymentGroupRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ConsumerOrderPaymentGroupRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public ConsumerOrderPaymentGroupRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public ConsumerOrderPaymentGroupRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public ConsumerOrderPaymentGroupRequest filterByCardNumber(String cardNumber) {
          
          if (cardNumber == null) {
              return this;
          }
          
          return filterByCardNumber(QueryOperator.EQUAL, cardNumber);
      }
    

      public ConsumerOrderPaymentGroupRequest filterByCardNumber(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getCardNumberSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ConsumerOrderPaymentGroupRequest selectCardNumber(){
          return select(CARD_NUMBER_PROPERTY);
      }

      public ConsumerOrderPaymentGroupRequest unselectCardNumber(){
          return unselect(CARD_NUMBER_PROPERTY);
      }

      public SearchCriteria getCardNumberSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(CARD_NUMBER_PROPERTY, pQueryOperator, parameters);
      }

      public ConsumerOrderPaymentGroupRequest orderByCardNumber(boolean asc){
          addOrderBy(CARD_NUMBER_PROPERTY, asc);
          return this;
      }
   
      public ConsumerOrderPaymentGroupRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public ConsumerOrderPaymentGroupRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ConsumerOrderPaymentGroupRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public ConsumerOrderPaymentGroupRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public ConsumerOrderPaymentGroupRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public ConsumerOrderPaymentGroupRequest filterByBizOrder(ConsumerOrderRequest bizOrder){
        return filterByBizOrder(bizOrder, bizOrderList -> bizOrderList.stream().map(ConsumerOrder::getId).collect(Collectors.toSet()));
    }

    public ConsumerOrderPaymentGroupRequest filterByBizOrder(ConsumerOrderRequest bizOrder, IDRefine<ConsumerOrder> idRefine) {
        return addSearchCriteria(createBizOrderCriteria(bizOrder, idRefine));
    }

    public SearchCriteria createBizOrderCriteria(ConsumerOrderRequest bizOrder, IDRefine<ConsumerOrder> idRefine) {
        return new RefinedIdInCriteria(bizOrder, BIZ_ORDER_PROPERTY, idRefine);
    }
    

    
    public ConsumerOrderPaymentGroupRequest selectBizOrder(){
        return selectBizOrder(ConsumerOrderRequest.newInstance().selectSelf());
    }

    public ConsumerOrderPaymentGroupRequest selectBizOrder(ConsumerOrderRequest bizOrder){
        selectParent(BIZ_ORDER_PROPERTY, bizOrder);
        return this;
    }
    

    public ConsumerOrderPaymentGroupRequest unselectBizOrder(){
        unselectParent(BIZ_ORDER_PROPERTY);
        return this;
    }

  


  

   public ConsumerOrderPaymentGroupRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

