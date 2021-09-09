package com.doublechaintech.retailscm.productsupplyduration;

import com.doublechaintech.retailscm.search.*;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.supplierproduct.SupplierProduct;
import com.doublechaintech.retailscm.supplierproduct.SupplierProductRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.productsupplyduration.ProductSupplyDuration.*;

public class ProductSupplyDurationRequest extends BaseRequest<ProductSupplyDuration> {
    public static ProductSupplyDurationRequest newInstance() {
        return new ProductSupplyDurationRequest().selectId();
    }

    public String getInternalType() {
        return "ProductSupplyDuration";
    }

    public ProductSupplyDurationRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public ProductSupplyDurationRequest select(String... names) {
        super.select(names);
        return this;
    }

    public ProductSupplyDurationRequest selectAll() {return this.selectId().selectQuantity().selectDuration().selectPrice().selectProduct().selectVersion();
    }

    public ProductSupplyDurationRequest selectSelf() {return this.selectId().selectQuantity().selectDuration().selectPrice().selectVersion();
    }

    public ProductSupplyDurationRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public ProductSupplyDurationRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static ProductSupplyDurationRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public ProductSupplyDurationRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public ProductSupplyDurationRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ProductSupplyDurationRequest selectId(){
          return select(ID_PROPERTY);
      }

      public ProductSupplyDurationRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public ProductSupplyDurationRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public ProductSupplyDurationRequest filterByQuantity(int quantity) {
          
          return filterByQuantity(QueryOperator.EQUAL, quantity);
      }
    

      public ProductSupplyDurationRequest filterByQuantity(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getQuantitySearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ProductSupplyDurationRequest selectQuantity(){
          return select(QUANTITY_PROPERTY);
      }

      public ProductSupplyDurationRequest unselectQuantity(){
          return unselect(QUANTITY_PROPERTY);
      }

      public SearchCriteria getQuantitySearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(QUANTITY_PROPERTY, pQueryOperator, parameters);
      }

      public ProductSupplyDurationRequest orderByQuantity(boolean asc){
          addOrderBy(QUANTITY_PROPERTY, asc);
          return this;
      }
   
      public ProductSupplyDurationRequest filterByDuration(String duration) {
          
          if (duration == null) {
              return this;
          }
          
          return filterByDuration(QueryOperator.EQUAL, duration);
      }
    

      public ProductSupplyDurationRequest filterByDuration(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getDurationSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ProductSupplyDurationRequest selectDuration(){
          return select(DURATION_PROPERTY);
      }

      public ProductSupplyDurationRequest unselectDuration(){
          return unselect(DURATION_PROPERTY);
      }

      public SearchCriteria getDurationSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(DURATION_PROPERTY, pQueryOperator, parameters);
      }

      public ProductSupplyDurationRequest orderByDuration(boolean asc){
          addOrderBy(DURATION_PROPERTY, asc);
          return this;
      }
   
      public ProductSupplyDurationRequest filterByPrice(BigDecimal price) {
          
          if (price == null) {
              return this;
          }
          
          return filterByPrice(QueryOperator.EQUAL, price);
      }
    

      public ProductSupplyDurationRequest filterByPrice(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getPriceSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ProductSupplyDurationRequest selectPrice(){
          return select(PRICE_PROPERTY);
      }

      public ProductSupplyDurationRequest unselectPrice(){
          return unselect(PRICE_PROPERTY);
      }

      public SearchCriteria getPriceSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(PRICE_PROPERTY, pQueryOperator, parameters);
      }

      public ProductSupplyDurationRequest orderByPrice(boolean asc){
          addOrderBy(PRICE_PROPERTY, asc);
          return this;
      }
   
      public ProductSupplyDurationRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public ProductSupplyDurationRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ProductSupplyDurationRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public ProductSupplyDurationRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public ProductSupplyDurationRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public ProductSupplyDurationRequest filterByProduct(SupplierProductRequest product){
        return filterByProduct(product, productList -> productList.stream().map(SupplierProduct::getId).collect(Collectors.toSet()));
    }

    public ProductSupplyDurationRequest filterByProduct(SupplierProductRequest product, IDRefine<SupplierProduct> idRefine) {
        return addSearchCriteria(createProductCriteria(product, idRefine));
    }

    public SearchCriteria createProductCriteria(SupplierProductRequest product, IDRefine<SupplierProduct> idRefine) {
        return new RefinedIdInCriteria(product, PRODUCT_PROPERTY, idRefine);
    }
    

    
    public ProductSupplyDurationRequest selectProduct(){
        return selectProduct(SupplierProductRequest.newInstance().selectSelf());
    }

    public ProductSupplyDurationRequest selectProduct(SupplierProductRequest product){
        selectParent(PRODUCT_PROPERTY, product);
        return this;
    }
    

    public ProductSupplyDurationRequest unselectProduct(){
        unselectParent(PRODUCT_PROPERTY);
        return this;
    }

  


  

   public ProductSupplyDurationRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

