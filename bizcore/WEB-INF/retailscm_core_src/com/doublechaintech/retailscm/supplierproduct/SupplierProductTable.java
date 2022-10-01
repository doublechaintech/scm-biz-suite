package com.doublechaintech.retailscm.supplierproduct;

import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class SupplierProductTable {

  public static AccessKey withId(Object value) {
    AccessKey accessKey = new AccessKey();
    accessKey.setColumnName(COLUMN_ID);
    accessKey.setValue(value);
    return accessKey;
  }
  // Add extra identifiers

  // only this package can use this, so the scope is default, not public, not private either nor
  // protected
  public static final String TABLE_NAME = "supplier_product_data";
  static final String COLUMN_ID = "id";
  static final String COLUMN_PRODUCT_NAME = "product_name";
  static final String COLUMN_PRODUCT_DESCRIPTION = "product_description";
  static final String COLUMN_PRODUCT_UNIT = "product_unit";
  static final String COLUMN_SUPPLIER = "supplier";
  static final String COLUMN_VERSION = "version";

  public static final String[] ALL_CLOUMNS = {
    COLUMN_ID,
    COLUMN_PRODUCT_NAME,
    COLUMN_PRODUCT_DESCRIPTION,
    COLUMN_PRODUCT_UNIT,
    COLUMN_SUPPLIER,
    COLUMN_VERSION
  };
  public static final String[] NORMAL_CLOUMNS = {
    COLUMN_PRODUCT_NAME, COLUMN_PRODUCT_DESCRIPTION, COLUMN_PRODUCT_UNIT, COLUMN_SUPPLIER
  };

  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result)
      throws Exception {
    RetailscmBaseUtils.ensureTable(
        userContext,
        result,
        "supplier_product_data",
        new String[][] {
          new String[] {"id", "varchar(48)", " not null", "ID", "", ""},
          new String[] {"product_name", "varchar(16)", "", "品名", "", ""},
          new String[] {"product_description", "varchar(52)", "", "产品描述", "", ""},
          new String[] {"product_unit", "varchar(8)", "", "产品单元", "", ""},
          new String[] {"supplier", "varchar(48)", "", "供应商", "goods_supplier_data", "id"},
          new String[] {"version", "int", "", "版本", "", ""}
        },
        "供应商的产品",
        new String[] {
          "create unique index idx4id_ver_of_supplier_product on supplier_product_data (id, version);",
          "create  index idx4version_of_supplier_product on supplier_product_data (version);"
        },
        new String[] {
          "alter table supplier_product_data add constraint pk4id_of_supplier_product_data primary key (id);",
          "alter table supplier_product_data add constraint fk4supplier_of_supplier_product_data foreign key (supplier) references goods_supplier_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
          ""
        });
  }
}
