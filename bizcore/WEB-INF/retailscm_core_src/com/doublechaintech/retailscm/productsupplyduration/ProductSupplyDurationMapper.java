package com.doublechaintech.retailscm.productsupplyduration;

import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.supplierproduct.SupplierProduct;

public class ProductSupplyDurationMapper extends BaseRowMapper<ProductSupplyDuration> {

  public static ProductSupplyDurationMapper mapperForClass(Class<?> clazz) {

    ProductSupplyDurationMapper mapperForOverride = new ProductSupplyDurationMapper();
    mapperForOverride.setClazz(clazz);
    return mapperForOverride;
  }

  protected ProductSupplyDuration internalMapRow(ResultSet rs, int rowNumber) throws SQLException {
    ProductSupplyDuration productSupplyDuration = getProductSupplyDuration();

    setId(productSupplyDuration, rs, rowNumber);
    setQuantity(productSupplyDuration, rs, rowNumber);
    setDuration(productSupplyDuration, rs, rowNumber);
    setPrice(productSupplyDuration, rs, rowNumber);
    setProduct(productSupplyDuration, rs, rowNumber);
    setVersion(productSupplyDuration, rs, rowNumber);

    return productSupplyDuration;
  }

  protected ProductSupplyDuration getProductSupplyDuration() {
    if (null == clazz) {

      ProductSupplyDuration entity = new ProductSupplyDuration();

      Beans.dbUtil().markEnhanced(entity);
      return entity;
    }
    return super.constructFromClass();
  }

  protected void setId(ProductSupplyDuration productSupplyDuration, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String id = rs.getString(ProductSupplyDurationTable.COLUMN_ID);

      if (id == null) {
        // do nothing when nothing found in database
        return;
      }

      productSupplyDuration.setId(id);
    } catch (SQLException e) {

    }
  }

  protected void setQuantity(
      ProductSupplyDuration productSupplyDuration, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer quantity = rs.getInt(ProductSupplyDurationTable.COLUMN_QUANTITY);

      if (quantity == null) {
        // do nothing when nothing found in database
        return;
      }

      productSupplyDuration.setQuantity(quantity);
    } catch (SQLException e) {

    }
  }

  protected void setDuration(
      ProductSupplyDuration productSupplyDuration, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String duration = rs.getString(ProductSupplyDurationTable.COLUMN_DURATION);

      if (duration == null) {
        // do nothing when nothing found in database
        return;
      }

      productSupplyDuration.setDuration(duration);
    } catch (SQLException e) {

    }
  }

  protected void setPrice(ProductSupplyDuration productSupplyDuration, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      BigDecimal price = rs.getBigDecimal(ProductSupplyDurationTable.COLUMN_PRICE);

      if (price == null) {
        // do nothing when nothing found in database
        return;
      }

      productSupplyDuration.setPrice(price);
    } catch (SQLException e) {

    }
  }

  protected void setProduct(
      ProductSupplyDuration productSupplyDuration, ResultSet rs, int rowNumber)
      throws SQLException {
    String supplierProductId;
    try {
      supplierProductId = rs.getString(ProductSupplyDurationTable.COLUMN_PRODUCT);
    } catch (SQLException e) {
      return;
    }
    if (supplierProductId == null) {
      return;
    }
    if (supplierProductId.isEmpty()) {
      return;
    }
    SupplierProduct supplierProduct = productSupplyDuration.getProduct();
    if (supplierProduct != null) {
      // if the root object 'productSupplyDuration' already have the property, just set the id for
      // it;
      supplierProduct.setId(supplierProductId);

      return;
    }
    productSupplyDuration.setProduct(createEmptyProduct(supplierProductId));
  }

  protected void setVersion(
      ProductSupplyDuration productSupplyDuration, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer version = rs.getInt(ProductSupplyDurationTable.COLUMN_VERSION);

      if (version == null) {
        // do nothing when nothing found in database
        return;
      }

      productSupplyDuration.setVersion(version);
    } catch (SQLException e) {

    }
  }

  protected SupplierProduct createEmptyProduct(String supplierProductId) {

    SupplierProduct supplierProduct = new SupplierProduct();

    supplierProduct.setId(supplierProductId);
    supplierProduct.setVersion(Integer.MAX_VALUE);
    return supplierProduct;
  }
}
