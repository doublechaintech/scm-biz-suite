package com.doublechaintech.retailscm.supplyorder;

import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.supplyorderlineitem.SupplyOrderLineItem;
import com.doublechaintech.retailscm.supplyorderpaymentgroup.SupplyOrderPaymentGroup;
import com.doublechaintech.retailscm.supplyordershippinggroup.SupplyOrderShippingGroup;
import com.doublechaintech.retailscm.goods.GoodsRequest;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplierRequest;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;
import com.doublechaintech.retailscm.supplyorderlineitem.SupplyOrderLineItemRequest;
import com.doublechaintech.retailscm.supplyorderpaymentgroup.SupplyOrderPaymentGroupRequest;
import com.doublechaintech.retailscm.supplyordershippinggroup.SupplyOrderShippingGroupRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.supplyorder.SupplyOrder.*;

public class SupplyOrderRequest extends BaseRequest<SupplyOrder> {
    public static SupplyOrderRequest newInstance() {
        return new SupplyOrderRequest().selectId();
    }

    public String getInternalType() {
        return "SupplyOrder";
    }

    public SupplyOrderRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public SupplyOrderRequest select(String... names) {
        super.select(names);
        return this;
    }

    public SupplyOrderRequest selectAll() {return this.selectId().selectBuyer().selectSeller().selectTitle().selectContract().selectTotalAmount().selectLastUpdateTime().selectVersion();
    }

    public SupplyOrderRequest selectSelf() {return this.selectId().selectTitle().selectContract().selectTotalAmount().selectLastUpdateTime().selectVersion();
    }

    public SupplyOrderRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public SupplyOrderRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static SupplyOrderRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public SupplyOrderRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public SupplyOrderRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SupplyOrderRequest selectId(){
          return select(ID_PROPERTY);
      }

      public SupplyOrderRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public SupplyOrderRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public SupplyOrderRequest filterByTitle(String title) {
          
          if (title == null) {
              return this;
          }
          
          return filterByTitle(QueryOperator.EQUAL, title);
      }
    

      public SupplyOrderRequest filterByTitle(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getTitleSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SupplyOrderRequest selectTitle(){
          return select(TITLE_PROPERTY);
      }

      public SupplyOrderRequest unselectTitle(){
          return unselect(TITLE_PROPERTY);
      }

      public SearchCriteria getTitleSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(TITLE_PROPERTY, pQueryOperator, parameters);
      }

      public SupplyOrderRequest orderByTitle(boolean asc){
          addOrderBy(TITLE_PROPERTY, asc);
          return this;
      }
   
      public SupplyOrderRequest filterByContract(String contract) {
          
          if (contract == null) {
              return this;
          }
          
          return filterByContract(QueryOperator.EQUAL, contract);
      }
    

      public SupplyOrderRequest filterByContract(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getContractSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SupplyOrderRequest selectContract(){
          return select(CONTRACT_PROPERTY);
      }

      public SupplyOrderRequest unselectContract(){
          return unselect(CONTRACT_PROPERTY);
      }

      public SearchCriteria getContractSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(CONTRACT_PROPERTY, pQueryOperator, parameters);
      }

      public SupplyOrderRequest orderByContract(boolean asc){
          addOrderBy(CONTRACT_PROPERTY, asc);
          return this;
      }
   
      public SupplyOrderRequest filterByTotalAmount(BigDecimal totalAmount) {
          
          if (totalAmount == null) {
              return this;
          }
          
          return filterByTotalAmount(QueryOperator.EQUAL, totalAmount);
      }
    

      public SupplyOrderRequest filterByTotalAmount(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getTotalAmountSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SupplyOrderRequest selectTotalAmount(){
          return select(TOTAL_AMOUNT_PROPERTY);
      }

      public SupplyOrderRequest unselectTotalAmount(){
          return unselect(TOTAL_AMOUNT_PROPERTY);
      }

      public SearchCriteria getTotalAmountSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(TOTAL_AMOUNT_PROPERTY, pQueryOperator, parameters);
      }

      public SupplyOrderRequest orderByTotalAmount(boolean asc){
          addOrderBy(TOTAL_AMOUNT_PROPERTY, asc);
          return this;
      }
   
      public SupplyOrderRequest filterByLastUpdateTime(DateTime lastUpdateTime) {
          
          if (lastUpdateTime == null) {
              return this;
          }
          
          return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
      }
    

      public SupplyOrderRequest filterByLastUpdateTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SupplyOrderRequest selectLastUpdateTime(){
          return select(LAST_UPDATE_TIME_PROPERTY);
      }

      public SupplyOrderRequest unselectLastUpdateTime(){
          return unselect(LAST_UPDATE_TIME_PROPERTY);
      }

      public SearchCriteria getLastUpdateTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public SupplyOrderRequest orderByLastUpdateTime(boolean asc){
          addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
          return this;
      }
   
      public SupplyOrderRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public SupplyOrderRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SupplyOrderRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public SupplyOrderRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public SupplyOrderRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public SupplyOrderRequest filterByBuyer(RetailStoreCountryCenterRequest buyer){
        return filterByBuyer(buyer, buyerList -> buyerList.stream().map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public SupplyOrderRequest filterByBuyer(RetailStoreCountryCenterRequest buyer, IDRefine<RetailStoreCountryCenter> idRefine) {
        return addSearchCriteria(createBuyerCriteria(buyer, idRefine));
    }

    public SearchCriteria createBuyerCriteria(RetailStoreCountryCenterRequest buyer, IDRefine<RetailStoreCountryCenter> idRefine) {
        return new RefinedIdInCriteria(buyer, BUYER_PROPERTY, idRefine);
    }
    

    
    public SupplyOrderRequest selectBuyer(){
        return selectBuyer(RetailStoreCountryCenterRequest.newInstance().selectSelf());
    }

    public SupplyOrderRequest selectBuyer(RetailStoreCountryCenterRequest buyer){
        selectParent(BUYER_PROPERTY, buyer);
        return this;
    }
    

    public SupplyOrderRequest unselectBuyer(){
        unselectParent(BUYER_PROPERTY);
        return this;
    }

  

    
    public SupplyOrderRequest filterBySeller(GoodsSupplierRequest seller){
        return filterBySeller(seller, sellerList -> sellerList.stream().map(GoodsSupplier::getId).collect(Collectors.toSet()));
    }

    public SupplyOrderRequest filterBySeller(GoodsSupplierRequest seller, IDRefine<GoodsSupplier> idRefine) {
        return addSearchCriteria(createSellerCriteria(seller, idRefine));
    }

    public SearchCriteria createSellerCriteria(GoodsSupplierRequest seller, IDRefine<GoodsSupplier> idRefine) {
        return new RefinedIdInCriteria(seller, SELLER_PROPERTY, idRefine);
    }
    

    
    public SupplyOrderRequest selectSeller(){
        return selectSeller(GoodsSupplierRequest.newInstance().selectSelf());
    }

    public SupplyOrderRequest selectSeller(GoodsSupplierRequest seller){
        selectParent(SELLER_PROPERTY, seller);
        return this;
    }
    

    public SupplyOrderRequest unselectSeller(){
        unselectParent(SELLER_PROPERTY);
        return this;
    }

  


  

    public SupplyOrderRequest hasSupplyOrderLineItem() {
      return hasSupplyOrderLineItem(SupplyOrderLineItemRequest.newInstance());
    }

    public SupplyOrderRequest hasSupplyOrderLineItem(SupplyOrderLineItemRequest supplyOrderLineItem) {
        return hasSupplyOrderLineItem(supplyOrderLineItem, supplyOrderLineItemList -> supplyOrderLineItemList.stream().map(SupplyOrderLineItem::getBizOrder).map(SupplyOrder::getId).collect(Collectors.toSet()));
    }

    public SupplyOrderRequest hasSupplyOrderLineItem(SupplyOrderLineItemRequest supplyOrderLineItem, IDRefine<SupplyOrderLineItem> idRefine) {
        supplyOrderLineItem.select(SupplyOrderLineItem.BIZ_ORDER_PROPERTY);
        return addSearchCriteria(createSupplyOrderLineItemCriteria(supplyOrderLineItem, idRefine));
    }

    public SearchCriteria createSupplyOrderLineItemCriteria(SupplyOrderLineItemRequest supplyOrderLineItem, IDRefine<SupplyOrderLineItem> idRefine){
       return new RefinedIdInCriteria(supplyOrderLineItem, ID_PROPERTY, idRefine);
    }

    public SupplyOrderRequest selectSupplyOrderLineItemList(SupplyOrderLineItemRequest supplyOrderLineItem) {
        selectChild(SupplyOrderLineItem.BIZ_ORDER_PROPERTY, supplyOrderLineItem);
        return this;
    }

    public SupplyOrderRequest selectSupplyOrderLineItemList() {
        return selectSupplyOrderLineItemList(SupplyOrderLineItemRequest.newInstance().selectAll());
    }

    public SupplyOrderRequest unselectSupplyOrderLineItemList(){
        unselectChild(SupplyOrderLineItem.BIZ_ORDER_PROPERTY, SupplyOrderLineItem.class);
        return this;
    }
  

    public SupplyOrderRequest hasSupplyOrderShippingGroup() {
      return hasSupplyOrderShippingGroup(SupplyOrderShippingGroupRequest.newInstance());
    }

    public SupplyOrderRequest hasSupplyOrderShippingGroup(SupplyOrderShippingGroupRequest supplyOrderShippingGroup) {
        return hasSupplyOrderShippingGroup(supplyOrderShippingGroup, supplyOrderShippingGroupList -> supplyOrderShippingGroupList.stream().map(SupplyOrderShippingGroup::getBizOrder).map(SupplyOrder::getId).collect(Collectors.toSet()));
    }

    public SupplyOrderRequest hasSupplyOrderShippingGroup(SupplyOrderShippingGroupRequest supplyOrderShippingGroup, IDRefine<SupplyOrderShippingGroup> idRefine) {
        supplyOrderShippingGroup.select(SupplyOrderShippingGroup.BIZ_ORDER_PROPERTY);
        return addSearchCriteria(createSupplyOrderShippingGroupCriteria(supplyOrderShippingGroup, idRefine));
    }

    public SearchCriteria createSupplyOrderShippingGroupCriteria(SupplyOrderShippingGroupRequest supplyOrderShippingGroup, IDRefine<SupplyOrderShippingGroup> idRefine){
       return new RefinedIdInCriteria(supplyOrderShippingGroup, ID_PROPERTY, idRefine);
    }

    public SupplyOrderRequest selectSupplyOrderShippingGroupList(SupplyOrderShippingGroupRequest supplyOrderShippingGroup) {
        selectChild(SupplyOrderShippingGroup.BIZ_ORDER_PROPERTY, supplyOrderShippingGroup);
        return this;
    }

    public SupplyOrderRequest selectSupplyOrderShippingGroupList() {
        return selectSupplyOrderShippingGroupList(SupplyOrderShippingGroupRequest.newInstance().selectAll());
    }

    public SupplyOrderRequest unselectSupplyOrderShippingGroupList(){
        unselectChild(SupplyOrderShippingGroup.BIZ_ORDER_PROPERTY, SupplyOrderShippingGroup.class);
        return this;
    }
  

    public SupplyOrderRequest hasSupplyOrderPaymentGroup() {
      return hasSupplyOrderPaymentGroup(SupplyOrderPaymentGroupRequest.newInstance());
    }

    public SupplyOrderRequest hasSupplyOrderPaymentGroup(SupplyOrderPaymentGroupRequest supplyOrderPaymentGroup) {
        return hasSupplyOrderPaymentGroup(supplyOrderPaymentGroup, supplyOrderPaymentGroupList -> supplyOrderPaymentGroupList.stream().map(SupplyOrderPaymentGroup::getBizOrder).map(SupplyOrder::getId).collect(Collectors.toSet()));
    }

    public SupplyOrderRequest hasSupplyOrderPaymentGroup(SupplyOrderPaymentGroupRequest supplyOrderPaymentGroup, IDRefine<SupplyOrderPaymentGroup> idRefine) {
        supplyOrderPaymentGroup.select(SupplyOrderPaymentGroup.BIZ_ORDER_PROPERTY);
        return addSearchCriteria(createSupplyOrderPaymentGroupCriteria(supplyOrderPaymentGroup, idRefine));
    }

    public SearchCriteria createSupplyOrderPaymentGroupCriteria(SupplyOrderPaymentGroupRequest supplyOrderPaymentGroup, IDRefine<SupplyOrderPaymentGroup> idRefine){
       return new RefinedIdInCriteria(supplyOrderPaymentGroup, ID_PROPERTY, idRefine);
    }

    public SupplyOrderRequest selectSupplyOrderPaymentGroupList(SupplyOrderPaymentGroupRequest supplyOrderPaymentGroup) {
        selectChild(SupplyOrderPaymentGroup.BIZ_ORDER_PROPERTY, supplyOrderPaymentGroup);
        return this;
    }

    public SupplyOrderRequest selectSupplyOrderPaymentGroupList() {
        return selectSupplyOrderPaymentGroupList(SupplyOrderPaymentGroupRequest.newInstance().selectAll());
    }

    public SupplyOrderRequest unselectSupplyOrderPaymentGroupList(){
        unselectChild(SupplyOrderPaymentGroup.BIZ_ORDER_PROPERTY, SupplyOrderPaymentGroup.class);
        return this;
    }
  

    public SupplyOrderRequest hasGoods() {
      return hasGoods(GoodsRequest.newInstance());
    }

    public SupplyOrderRequest hasGoods(GoodsRequest goods) {
        return hasGoods(goods, goodsList -> goodsList.stream().map(Goods::getBizOrder).map(SupplyOrder::getId).collect(Collectors.toSet()));
    }

    public SupplyOrderRequest hasGoods(GoodsRequest goods, IDRefine<Goods> idRefine) {
        goods.select(Goods.BIZ_ORDER_PROPERTY);
        return addSearchCriteria(createGoodsCriteria(goods, idRefine));
    }

    public SearchCriteria createGoodsCriteria(GoodsRequest goods, IDRefine<Goods> idRefine){
       return new RefinedIdInCriteria(goods, ID_PROPERTY, idRefine);
    }

    public SupplyOrderRequest selectGoodsList(GoodsRequest goods) {
        selectChild(Goods.BIZ_ORDER_PROPERTY, goods);
        return this;
    }

    public SupplyOrderRequest selectGoodsList() {
        return selectGoodsList(GoodsRequest.newInstance().selectAll());
    }

    public SupplyOrderRequest unselectGoodsList(){
        unselectChild(Goods.BIZ_ORDER_PROPERTY, Goods.class);
        return this;
    }
  

   public SupplyOrderRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

