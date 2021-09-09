package com.doublechaintech.retailscm.supplierproduct;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;
import com.doublechaintech.retailscm.productsupplyduration.ProductSupplyDuration;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplierRequest;
import com.doublechaintech.retailscm.productsupplyduration.ProductSupplyDurationRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.supplierproduct.SupplierProduct.*;

public class SupplierProductRequest extends BaseRequest<SupplierProduct> {
    public static SupplierProductRequest newInstance() {
        return new SupplierProductRequest().selectId();
    }

    public String getInternalType() {
        return "SupplierProduct";
    }

    public SupplierProductRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public SupplierProductRequest select(String... names) {
        super.select(names);
        return this;
    }

    public SupplierProductRequest selectAll() {return this.selectId().selectProductName().selectProductDescription().selectProductUnit().selectSupplier().selectVersion();
    }

    public SupplierProductRequest selectSelf() {return this.selectId().selectProductName().selectProductDescription().selectProductUnit().selectVersion();
    }

    public SupplierProductRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public SupplierProductRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static SupplierProductRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public SupplierProductRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public SupplierProductRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SupplierProductRequest selectId(){
          return select(ID_PROPERTY);
      }

      public SupplierProductRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public SupplierProductRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public SupplierProductRequest filterByProductName(String productName) {
          
          if (productName == null) {
              return this;
          }
          
          return filterByProductName(QueryOperator.EQUAL, productName);
      }
    

      public SupplierProductRequest filterByProductName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getProductNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SupplierProductRequest selectProductName(){
          return select(PRODUCT_NAME_PROPERTY);
      }

      public SupplierProductRequest unselectProductName(){
          return unselect(PRODUCT_NAME_PROPERTY);
      }

      public SearchCriteria getProductNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(PRODUCT_NAME_PROPERTY, pQueryOperator, parameters);
      }

      public SupplierProductRequest orderByProductName(boolean asc){
          addOrderBy(PRODUCT_NAME_PROPERTY, asc);
          return this;
      }
   
      public SupplierProductRequest filterByProductDescription(String productDescription) {
          
          if (productDescription == null) {
              return this;
          }
          
          return filterByProductDescription(QueryOperator.EQUAL, productDescription);
      }
    

      public SupplierProductRequest filterByProductDescription(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getProductDescriptionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SupplierProductRequest selectProductDescription(){
          return select(PRODUCT_DESCRIPTION_PROPERTY);
      }

      public SupplierProductRequest unselectProductDescription(){
          return unselect(PRODUCT_DESCRIPTION_PROPERTY);
      }

      public SearchCriteria getProductDescriptionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(PRODUCT_DESCRIPTION_PROPERTY, pQueryOperator, parameters);
      }

      public SupplierProductRequest orderByProductDescription(boolean asc){
          addOrderBy(PRODUCT_DESCRIPTION_PROPERTY, asc);
          return this;
      }
   
      public SupplierProductRequest filterByProductUnit(String productUnit) {
          
          if (productUnit == null) {
              return this;
          }
          
          return filterByProductUnit(QueryOperator.EQUAL, productUnit);
      }
    

      public SupplierProductRequest filterByProductUnit(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getProductUnitSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SupplierProductRequest selectProductUnit(){
          return select(PRODUCT_UNIT_PROPERTY);
      }

      public SupplierProductRequest unselectProductUnit(){
          return unselect(PRODUCT_UNIT_PROPERTY);
      }

      public SearchCriteria getProductUnitSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(PRODUCT_UNIT_PROPERTY, pQueryOperator, parameters);
      }

      public SupplierProductRequest orderByProductUnit(boolean asc){
          addOrderBy(PRODUCT_UNIT_PROPERTY, asc);
          return this;
      }
   
      public SupplierProductRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public SupplierProductRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SupplierProductRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public SupplierProductRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public SupplierProductRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public SupplierProductRequest filterBySupplier(GoodsSupplierRequest supplier){
        return filterBySupplier(supplier, supplierList -> supplierList.stream().map(GoodsSupplier::getId).collect(Collectors.toSet()));
    }

    public SupplierProductRequest filterBySupplier(GoodsSupplierRequest supplier, IDRefine<GoodsSupplier> idRefine) {
        return addSearchCriteria(createSupplierCriteria(supplier, idRefine));
    }

    public SearchCriteria createSupplierCriteria(GoodsSupplierRequest supplier, IDRefine<GoodsSupplier> idRefine) {
        return new RefinedIdInCriteria(supplier, SUPPLIER_PROPERTY, idRefine);
    }
    

    
    public SupplierProductRequest selectSupplier(){
        return selectSupplier(GoodsSupplierRequest.newInstance().selectSelf());
    }

    public SupplierProductRequest selectSupplier(GoodsSupplierRequest supplier){
        selectParent(SUPPLIER_PROPERTY, supplier);
        return this;
    }
    

    public SupplierProductRequest unselectSupplier(){
        unselectParent(SUPPLIER_PROPERTY);
        return this;
    }

  


  

    public SupplierProductRequest hasProductSupplyDuration() {
      return hasProductSupplyDuration(ProductSupplyDurationRequest.newInstance());
    }

    public SupplierProductRequest hasProductSupplyDuration(ProductSupplyDurationRequest productSupplyDuration) {
        return hasProductSupplyDuration(productSupplyDuration, productSupplyDurationList -> productSupplyDurationList.stream().map(ProductSupplyDuration::getProduct).map(SupplierProduct::getId).collect(Collectors.toSet()));
    }

    public SupplierProductRequest hasProductSupplyDuration(ProductSupplyDurationRequest productSupplyDuration, IDRefine<ProductSupplyDuration> idRefine) {
        productSupplyDuration.select(ProductSupplyDuration.PRODUCT_PROPERTY);
        return addSearchCriteria(createProductSupplyDurationCriteria(productSupplyDuration, idRefine));
    }

    public SearchCriteria createProductSupplyDurationCriteria(ProductSupplyDurationRequest productSupplyDuration, IDRefine<ProductSupplyDuration> idRefine){
       return new RefinedIdInCriteria(productSupplyDuration, ID_PROPERTY, idRefine);
    }

    public SupplierProductRequest selectProductSupplyDurationList(ProductSupplyDurationRequest productSupplyDuration) {
        selectChild(ProductSupplyDuration.PRODUCT_PROPERTY, productSupplyDuration);
        return this;
    }

    public SupplierProductRequest selectProductSupplyDurationList() {
        return selectProductSupplyDurationList(ProductSupplyDurationRequest.newInstance().selectAll());
    }

    public SupplierProductRequest unselectProductSupplyDurationList(){
        unselectChild(ProductSupplyDuration.PRODUCT_PROPERTY, ProductSupplyDuration.class);
        return this;
    }
  

   public SupplierProductRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

