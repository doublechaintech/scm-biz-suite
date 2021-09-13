package com.doublechaintech.retailscm.retailstoreorder;

import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.retailstoreorderlineitem.RetailStoreOrderLineItem;
import com.doublechaintech.retailscm.retailstoreorderpaymentgroup.RetailStoreOrderPaymentGroup;
import com.doublechaintech.retailscm.retailstoreordershippinggroup.RetailStoreOrderShippingGroup;
import com.doublechaintech.retailscm.goods.GoodsRequest;
import com.doublechaintech.retailscm.retailstore.RetailStoreRequest;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;
import com.doublechaintech.retailscm.retailstoreorderlineitem.RetailStoreOrderLineItemRequest;
import com.doublechaintech.retailscm.retailstoreorderpaymentgroup.RetailStoreOrderPaymentGroupRequest;
import com.doublechaintech.retailscm.retailstoreordershippinggroup.RetailStoreOrderShippingGroupRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder.*;

public class RetailStoreOrderRequest extends BaseRequest<RetailStoreOrder> {
    public static RetailStoreOrderRequest newInstance() {
        return new RetailStoreOrderRequest().selectId();
    }

    public String getInternalType() {
        return "RetailStoreOrder";
    }

    public RetailStoreOrderRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public RetailStoreOrderRequest select(String... names) {
        super.select(names);
        return this;
    }

    public RetailStoreOrderRequest selectAll() {return this.selectId().selectBuyer().selectSeller().selectTitle().selectTotalAmount().selectContract().selectLastUpdateTime().selectVersion();
    }

    public RetailStoreOrderRequest selectSelf() {return this.selectId().selectTitle().selectTotalAmount().selectContract().selectLastUpdateTime().selectVersion();
    }

    public RetailStoreOrderRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public RetailStoreOrderRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static RetailStoreOrderRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public RetailStoreOrderRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public RetailStoreOrderRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreOrderRequest selectId(){
          return select(ID_PROPERTY);
      }

      public RetailStoreOrderRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreOrderRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreOrderRequest filterByTitle(String title) {
          
          if (title == null) {
              return this;
          }
          
          return filterByTitle(QueryOperator.EQUAL, title);
      }
    

      public RetailStoreOrderRequest filterByTitle(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getTitleSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreOrderRequest selectTitle(){
          return select(TITLE_PROPERTY);
      }

      public RetailStoreOrderRequest unselectTitle(){
          return unselect(TITLE_PROPERTY);
      }

      public SearchCriteria getTitleSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(TITLE_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreOrderRequest orderByTitle(boolean asc){
          addOrderBy(TITLE_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreOrderRequest filterByTotalAmount(BigDecimal totalAmount) {
          
          if (totalAmount == null) {
              return this;
          }
          
          return filterByTotalAmount(QueryOperator.EQUAL, totalAmount);
      }
    

      public RetailStoreOrderRequest filterByTotalAmount(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getTotalAmountSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreOrderRequest selectTotalAmount(){
          return select(TOTAL_AMOUNT_PROPERTY);
      }

      public RetailStoreOrderRequest unselectTotalAmount(){
          return unselect(TOTAL_AMOUNT_PROPERTY);
      }

      public SearchCriteria getTotalAmountSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(TOTAL_AMOUNT_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreOrderRequest orderByTotalAmount(boolean asc){
          addOrderBy(TOTAL_AMOUNT_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreOrderRequest filterByContract(String contract) {
          
          if (contract == null) {
              return this;
          }
          
          return filterByContract(QueryOperator.EQUAL, contract);
      }
    

      public RetailStoreOrderRequest filterByContract(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getContractSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreOrderRequest selectContract(){
          return select(CONTRACT_PROPERTY);
      }

      public RetailStoreOrderRequest unselectContract(){
          return unselect(CONTRACT_PROPERTY);
      }

      public SearchCriteria getContractSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(CONTRACT_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreOrderRequest orderByContract(boolean asc){
          addOrderBy(CONTRACT_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreOrderRequest filterByLastUpdateTime(DateTime lastUpdateTime) {
          
          if (lastUpdateTime == null) {
              return this;
          }
          
          return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
      }
    

      public RetailStoreOrderRequest filterByLastUpdateTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreOrderRequest selectLastUpdateTime(){
          return select(LAST_UPDATE_TIME_PROPERTY);
      }

      public RetailStoreOrderRequest unselectLastUpdateTime(){
          return unselect(LAST_UPDATE_TIME_PROPERTY);
      }

      public SearchCriteria getLastUpdateTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreOrderRequest orderByLastUpdateTime(boolean asc){
          addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreOrderRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public RetailStoreOrderRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreOrderRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public RetailStoreOrderRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreOrderRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public RetailStoreOrderRequest filterByBuyer(RetailStoreRequest buyer){
        return filterByBuyer(buyer, buyerList -> buyerList.stream().map(RetailStore::getId).collect(Collectors.toSet()));
    }

    public RetailStoreOrderRequest filterByBuyer(RetailStoreRequest buyer, IDRefine<RetailStore> idRefine) {
        return addSearchCriteria(createBuyerCriteria(buyer, idRefine));
    }

    public SearchCriteria createBuyerCriteria(RetailStoreRequest buyer, IDRefine<RetailStore> idRefine) {
        return new RefinedIdInCriteria(buyer, BUYER_PROPERTY, idRefine);
    }
    

    
    public RetailStoreOrderRequest selectBuyer(){
        return selectBuyer(RetailStoreRequest.newInstance().selectSelf());
    }

    public RetailStoreOrderRequest selectBuyer(RetailStoreRequest buyer){
        selectParent(BUYER_PROPERTY, buyer);
        return this;
    }
    

    public RetailStoreOrderRequest unselectBuyer(){
        unselectParent(BUYER_PROPERTY);
        return this;
    }

  

    
    public RetailStoreOrderRequest filterBySeller(RetailStoreCountryCenterRequest seller){
        return filterBySeller(seller, sellerList -> sellerList.stream().map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public RetailStoreOrderRequest filterBySeller(RetailStoreCountryCenterRequest seller, IDRefine<RetailStoreCountryCenter> idRefine) {
        return addSearchCriteria(createSellerCriteria(seller, idRefine));
    }

    public SearchCriteria createSellerCriteria(RetailStoreCountryCenterRequest seller, IDRefine<RetailStoreCountryCenter> idRefine) {
        return new RefinedIdInCriteria(seller, SELLER_PROPERTY, idRefine);
    }
    

    
    public RetailStoreOrderRequest selectSeller(){
        return selectSeller(RetailStoreCountryCenterRequest.newInstance().selectSelf());
    }

    public RetailStoreOrderRequest selectSeller(RetailStoreCountryCenterRequest seller){
        selectParent(SELLER_PROPERTY, seller);
        return this;
    }
    

    public RetailStoreOrderRequest unselectSeller(){
        unselectParent(SELLER_PROPERTY);
        return this;
    }

  


  

    public RetailStoreOrderRequest hasRetailStoreOrderLineItem() {
      return hasRetailStoreOrderLineItem(RetailStoreOrderLineItemRequest.newInstance());
    }

    public RetailStoreOrderRequest hasRetailStoreOrderLineItem(RetailStoreOrderLineItemRequest retailStoreOrderLineItem) {
        return hasRetailStoreOrderLineItem(retailStoreOrderLineItem, retailStoreOrderLineItemList -> retailStoreOrderLineItemList.stream().map(RetailStoreOrderLineItem::getBizOrder).map(RetailStoreOrder::getId).collect(Collectors.toSet()));
    }

    public RetailStoreOrderRequest hasRetailStoreOrderLineItem(RetailStoreOrderLineItemRequest retailStoreOrderLineItem, IDRefine<RetailStoreOrderLineItem> idRefine) {
        retailStoreOrderLineItem.select(RetailStoreOrderLineItem.BIZ_ORDER_PROPERTY);
        return addSearchCriteria(createRetailStoreOrderLineItemCriteria(retailStoreOrderLineItem, idRefine));
    }

    public SearchCriteria createRetailStoreOrderLineItemCriteria(RetailStoreOrderLineItemRequest retailStoreOrderLineItem, IDRefine<RetailStoreOrderLineItem> idRefine){
       return new RefinedIdInCriteria(retailStoreOrderLineItem, ID_PROPERTY, idRefine);
    }

    public RetailStoreOrderRequest selectRetailStoreOrderLineItemList(RetailStoreOrderLineItemRequest retailStoreOrderLineItem) {
        selectChild(RetailStoreOrderLineItem.BIZ_ORDER_PROPERTY, retailStoreOrderLineItem);
        return this;
    }

    public RetailStoreOrderRequest selectRetailStoreOrderLineItemList() {
        return selectRetailStoreOrderLineItemList(RetailStoreOrderLineItemRequest.newInstance().selectAll());
    }

    public RetailStoreOrderRequest unselectRetailStoreOrderLineItemList(){
        unselectChild(RetailStoreOrderLineItem.BIZ_ORDER_PROPERTY, RetailStoreOrderLineItem.class);
        return this;
    }
  

    public RetailStoreOrderRequest hasRetailStoreOrderShippingGroup() {
      return hasRetailStoreOrderShippingGroup(RetailStoreOrderShippingGroupRequest.newInstance());
    }

    public RetailStoreOrderRequest hasRetailStoreOrderShippingGroup(RetailStoreOrderShippingGroupRequest retailStoreOrderShippingGroup) {
        return hasRetailStoreOrderShippingGroup(retailStoreOrderShippingGroup, retailStoreOrderShippingGroupList -> retailStoreOrderShippingGroupList.stream().map(RetailStoreOrderShippingGroup::getBizOrder).map(RetailStoreOrder::getId).collect(Collectors.toSet()));
    }

    public RetailStoreOrderRequest hasRetailStoreOrderShippingGroup(RetailStoreOrderShippingGroupRequest retailStoreOrderShippingGroup, IDRefine<RetailStoreOrderShippingGroup> idRefine) {
        retailStoreOrderShippingGroup.select(RetailStoreOrderShippingGroup.BIZ_ORDER_PROPERTY);
        return addSearchCriteria(createRetailStoreOrderShippingGroupCriteria(retailStoreOrderShippingGroup, idRefine));
    }

    public SearchCriteria createRetailStoreOrderShippingGroupCriteria(RetailStoreOrderShippingGroupRequest retailStoreOrderShippingGroup, IDRefine<RetailStoreOrderShippingGroup> idRefine){
       return new RefinedIdInCriteria(retailStoreOrderShippingGroup, ID_PROPERTY, idRefine);
    }

    public RetailStoreOrderRequest selectRetailStoreOrderShippingGroupList(RetailStoreOrderShippingGroupRequest retailStoreOrderShippingGroup) {
        selectChild(RetailStoreOrderShippingGroup.BIZ_ORDER_PROPERTY, retailStoreOrderShippingGroup);
        return this;
    }

    public RetailStoreOrderRequest selectRetailStoreOrderShippingGroupList() {
        return selectRetailStoreOrderShippingGroupList(RetailStoreOrderShippingGroupRequest.newInstance().selectAll());
    }

    public RetailStoreOrderRequest unselectRetailStoreOrderShippingGroupList(){
        unselectChild(RetailStoreOrderShippingGroup.BIZ_ORDER_PROPERTY, RetailStoreOrderShippingGroup.class);
        return this;
    }
  

    public RetailStoreOrderRequest hasRetailStoreOrderPaymentGroup() {
      return hasRetailStoreOrderPaymentGroup(RetailStoreOrderPaymentGroupRequest.newInstance());
    }

    public RetailStoreOrderRequest hasRetailStoreOrderPaymentGroup(RetailStoreOrderPaymentGroupRequest retailStoreOrderPaymentGroup) {
        return hasRetailStoreOrderPaymentGroup(retailStoreOrderPaymentGroup, retailStoreOrderPaymentGroupList -> retailStoreOrderPaymentGroupList.stream().map(RetailStoreOrderPaymentGroup::getBizOrder).map(RetailStoreOrder::getId).collect(Collectors.toSet()));
    }

    public RetailStoreOrderRequest hasRetailStoreOrderPaymentGroup(RetailStoreOrderPaymentGroupRequest retailStoreOrderPaymentGroup, IDRefine<RetailStoreOrderPaymentGroup> idRefine) {
        retailStoreOrderPaymentGroup.select(RetailStoreOrderPaymentGroup.BIZ_ORDER_PROPERTY);
        return addSearchCriteria(createRetailStoreOrderPaymentGroupCriteria(retailStoreOrderPaymentGroup, idRefine));
    }

    public SearchCriteria createRetailStoreOrderPaymentGroupCriteria(RetailStoreOrderPaymentGroupRequest retailStoreOrderPaymentGroup, IDRefine<RetailStoreOrderPaymentGroup> idRefine){
       return new RefinedIdInCriteria(retailStoreOrderPaymentGroup, ID_PROPERTY, idRefine);
    }

    public RetailStoreOrderRequest selectRetailStoreOrderPaymentGroupList(RetailStoreOrderPaymentGroupRequest retailStoreOrderPaymentGroup) {
        selectChild(RetailStoreOrderPaymentGroup.BIZ_ORDER_PROPERTY, retailStoreOrderPaymentGroup);
        return this;
    }

    public RetailStoreOrderRequest selectRetailStoreOrderPaymentGroupList() {
        return selectRetailStoreOrderPaymentGroupList(RetailStoreOrderPaymentGroupRequest.newInstance().selectAll());
    }

    public RetailStoreOrderRequest unselectRetailStoreOrderPaymentGroupList(){
        unselectChild(RetailStoreOrderPaymentGroup.BIZ_ORDER_PROPERTY, RetailStoreOrderPaymentGroup.class);
        return this;
    }
  

    public RetailStoreOrderRequest hasGoods() {
      return hasGoods(GoodsRequest.newInstance());
    }

    public RetailStoreOrderRequest hasGoods(GoodsRequest goods) {
        return hasGoods(goods, goodsList -> goodsList.stream().map(Goods::getRetailStoreOrder).map(RetailStoreOrder::getId).collect(Collectors.toSet()));
    }

    public RetailStoreOrderRequest hasGoods(GoodsRequest goods, IDRefine<Goods> idRefine) {
        goods.select(Goods.RETAIL_STORE_ORDER_PROPERTY);
        return addSearchCriteria(createGoodsCriteria(goods, idRefine));
    }

    public SearchCriteria createGoodsCriteria(GoodsRequest goods, IDRefine<Goods> idRefine){
       return new RefinedIdInCriteria(goods, ID_PROPERTY, idRefine);
    }

    public RetailStoreOrderRequest selectGoodsList(GoodsRequest goods) {
        selectChild(Goods.RETAIL_STORE_ORDER_PROPERTY, goods);
        return this;
    }

    public RetailStoreOrderRequest selectGoodsList() {
        return selectGoodsList(GoodsRequest.newInstance().selectAll());
    }

    public RetailStoreOrderRequest unselectGoodsList(){
        unselectChild(Goods.RETAIL_STORE_ORDER_PROPERTY, Goods.class);
        return this;
    }
  

   public RetailStoreOrderRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

