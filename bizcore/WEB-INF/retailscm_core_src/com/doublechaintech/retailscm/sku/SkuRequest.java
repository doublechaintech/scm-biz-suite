package com.doublechaintech.retailscm.sku;

import com.doublechaintech.retailscm.search.*;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.product.Product;
import com.doublechaintech.retailscm.goods.GoodsRequest;
import com.doublechaintech.retailscm.product.ProductRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.sku.Sku.*;

public class SkuRequest extends BaseRequest<Sku> {
    public static SkuRequest newInstance() {
        return new SkuRequest().selectId();
    }

    public String getInternalType() {
        return "Sku";
    }

    public SkuRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public SkuRequest select(String... names) {
        super.select(names);
        return this;
    }

    public SkuRequest selectAll() {return this.selectId().selectName().selectSize().selectProduct().selectBarcode().selectPackageType().selectNetContent().selectPrice().selectPicture().selectVersion();
    }

    public SkuRequest selectSelf() {return this.selectId().selectName().selectSize().selectBarcode().selectPackageType().selectNetContent().selectPrice().selectPicture().selectVersion();
    }

    public SkuRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public SkuRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static SkuRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public SkuRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public SkuRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SkuRequest selectId(){
          return select(ID_PROPERTY);
      }

      public SkuRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public SkuRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public SkuRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public SkuRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SkuRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public SkuRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public SkuRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public SkuRequest filterBySize(String size) {
          
          if (size == null) {
              return this;
          }
          
          return filterBySize(QueryOperator.EQUAL, size);
      }
    

      public SkuRequest filterBySize(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getSizeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SkuRequest selectSize(){
          return select(SIZE_PROPERTY);
      }

      public SkuRequest unselectSize(){
          return unselect(SIZE_PROPERTY);
      }

      public SearchCriteria getSizeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(SIZE_PROPERTY, pQueryOperator, parameters);
      }

      public SkuRequest orderBySize(boolean asc){
          addOrderBy(SIZE_PROPERTY, asc);
          return this;
      }
   
      public SkuRequest filterByBarcode(String barcode) {
          
          if (barcode == null) {
              return this;
          }
          
          return filterByBarcode(QueryOperator.EQUAL, barcode);
      }
    

      public SkuRequest filterByBarcode(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getBarcodeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SkuRequest selectBarcode(){
          return select(BARCODE_PROPERTY);
      }

      public SkuRequest unselectBarcode(){
          return unselect(BARCODE_PROPERTY);
      }

      public SearchCriteria getBarcodeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(BARCODE_PROPERTY, pQueryOperator, parameters);
      }

      public SkuRequest orderByBarcode(boolean asc){
          addOrderBy(BARCODE_PROPERTY, asc);
          return this;
      }
   
      public SkuRequest filterByPackageType(String packageType) {
          
          if (packageType == null) {
              return this;
          }
          
          return filterByPackageType(QueryOperator.EQUAL, packageType);
      }
    

      public SkuRequest filterByPackageType(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getPackageTypeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SkuRequest selectPackageType(){
          return select(PACKAGE_TYPE_PROPERTY);
      }

      public SkuRequest unselectPackageType(){
          return unselect(PACKAGE_TYPE_PROPERTY);
      }

      public SearchCriteria getPackageTypeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(PACKAGE_TYPE_PROPERTY, pQueryOperator, parameters);
      }

      public SkuRequest orderByPackageType(boolean asc){
          addOrderBy(PACKAGE_TYPE_PROPERTY, asc);
          return this;
      }
   
      public SkuRequest filterByNetContent(String netContent) {
          
          if (netContent == null) {
              return this;
          }
          
          return filterByNetContent(QueryOperator.EQUAL, netContent);
      }
    

      public SkuRequest filterByNetContent(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNetContentSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SkuRequest selectNetContent(){
          return select(NET_CONTENT_PROPERTY);
      }

      public SkuRequest unselectNetContent(){
          return unselect(NET_CONTENT_PROPERTY);
      }

      public SearchCriteria getNetContentSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NET_CONTENT_PROPERTY, pQueryOperator, parameters);
      }

      public SkuRequest orderByNetContent(boolean asc){
          addOrderBy(NET_CONTENT_PROPERTY, asc);
          return this;
      }
   
      public SkuRequest filterByPrice(BigDecimal price) {
          
          if (price == null) {
              return this;
          }
          
          return filterByPrice(QueryOperator.EQUAL, price);
      }
    

      public SkuRequest filterByPrice(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getPriceSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SkuRequest selectPrice(){
          return select(PRICE_PROPERTY);
      }

      public SkuRequest unselectPrice(){
          return unselect(PRICE_PROPERTY);
      }

      public SearchCriteria getPriceSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(PRICE_PROPERTY, pQueryOperator, parameters);
      }

      public SkuRequest orderByPrice(boolean asc){
          addOrderBy(PRICE_PROPERTY, asc);
          return this;
      }
   
      public SkuRequest filterByPicture(String picture) {
          
          if (picture == null) {
              return this;
          }
          
          return filterByPicture(QueryOperator.EQUAL, picture);
      }
    

      public SkuRequest filterByPicture(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getPictureSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SkuRequest selectPicture(){
          return select(PICTURE_PROPERTY);
      }

      public SkuRequest unselectPicture(){
          return unselect(PICTURE_PROPERTY);
      }

      public SearchCriteria getPictureSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(PICTURE_PROPERTY, pQueryOperator, parameters);
      }

      public SkuRequest orderByPicture(boolean asc){
          addOrderBy(PICTURE_PROPERTY, asc);
          return this;
      }
   
      public SkuRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public SkuRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SkuRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public SkuRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public SkuRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public SkuRequest filterByProduct(ProductRequest product){
        return filterByProduct(product, productList -> productList.stream().map(Product::getId).collect(Collectors.toSet()));
    }

    public SkuRequest filterByProduct(ProductRequest product, IDRefine<Product> idRefine) {
        return addSearchCriteria(createProductCriteria(product, idRefine));
    }

    public SearchCriteria createProductCriteria(ProductRequest product, IDRefine<Product> idRefine) {
        return new RefinedIdInCriteria(product, PRODUCT_PROPERTY, idRefine);
    }
    

    
    public SkuRequest selectProduct(){
        return selectProduct(ProductRequest.newInstance().selectSelf());
    }

    public SkuRequest selectProduct(ProductRequest product){
        selectParent(PRODUCT_PROPERTY, product);
        return this;
    }
    

    public SkuRequest unselectProduct(){
        unselectParent(PRODUCT_PROPERTY);
        return this;
    }

  


  

    public SkuRequest hasGoods() {
      return hasGoods(GoodsRequest.newInstance());
    }

    public SkuRequest hasGoods(GoodsRequest goods) {
        return hasGoods(goods, goodsList -> goodsList.stream().map(Goods::getSku).map(Sku::getId).collect(Collectors.toSet()));
    }

    public SkuRequest hasGoods(GoodsRequest goods, IDRefine<Goods> idRefine) {
        goods.select(Goods.SKU_PROPERTY);
        return addSearchCriteria(createGoodsCriteria(goods, idRefine));
    }

    public SearchCriteria createGoodsCriteria(GoodsRequest goods, IDRefine<Goods> idRefine){
       return new RefinedIdInCriteria(goods, ID_PROPERTY, idRefine);
    }

    public SkuRequest selectGoodsList(GoodsRequest goods) {
        selectChild(Goods.SKU_PROPERTY, goods);
        return this;
    }

    public SkuRequest selectGoodsList() {
        return selectGoodsList(GoodsRequest.newInstance().selectAll());
    }

    public SkuRequest unselectGoodsList(){
        unselectChild(Goods.SKU_PROPERTY, Goods.class);
        return this;
    }
  

   public SkuRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

