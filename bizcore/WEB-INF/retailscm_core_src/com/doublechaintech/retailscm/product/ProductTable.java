package com.doublechaintech.retailscm.product;

import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class ProductTable {

  public static AccessKey withId(Object value) {
    AccessKey accessKey = new AccessKey();
    accessKey.setColumnName(COLUMN_ID);
    accessKey.setValue(value);
    return accessKey;
  }
  // Add extra identifiers

  // only this package can use this, so the scope is default, not public, not private either nor
  // protected
  public static final String TABLE_NAME = "product_data";
  static final String COLUMN_ID = "id";
  static final String COLUMN_NAME = "name";
  static final String COLUMN_PARENT_CATEGORY = "parent_category";
  static final String COLUMN_ORIGIN = "origin";
  static final String COLUMN_REMARK = "remark";
  static final String COLUMN_BRAND = "brand";
  static final String COLUMN_PICTURE = "picture";
  static final String COLUMN_LAST_UPDATE_TIME = "last_update_time";
  static final String COLUMN_VERSION = "version";

  public static final String[] ALL_CLOUMNS = {
    COLUMN_ID,
    COLUMN_NAME,
    COLUMN_PARENT_CATEGORY,
    COLUMN_ORIGIN,
    COLUMN_REMARK,
    COLUMN_BRAND,
    COLUMN_PICTURE,
    COLUMN_LAST_UPDATE_TIME,
    COLUMN_VERSION
  };
  public static final String[] NORMAL_CLOUMNS = {
    COLUMN_NAME,
    COLUMN_PARENT_CATEGORY,
    COLUMN_ORIGIN,
    COLUMN_REMARK,
    COLUMN_BRAND,
    COLUMN_PICTURE,
    COLUMN_LAST_UPDATE_TIME
  };

  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result)
      throws Exception {
    RetailscmBaseUtils.ensureTable(
        userContext,
        result,
        "product_data",
        new String[][] {
          new String[] {"id", "varchar(48)", " not null", "ID", "", ""},
          new String[] {"name", "varchar(12)", "", "名称", "", ""},
          new String[] {
            "parent_category", "varchar(48)", "", "父类", "level_three_category_data", "id"
          },
          new String[] {"origin", "varchar(8)", "", "产地", "", ""},
          new String[] {"remark", "varchar(88)", "", "备注", "", ""},
          new String[] {"brand", "varchar(92)", "", "品牌", "", ""},
          new String[] {
            "picture", "varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci", "", "图片", "", ""
          },
          new String[] {"last_update_time", "datetime", "", "更新于", "", ""},
          new String[] {"version", "int", "", "版本", "", ""}
        },
        "产品",
        new String[] {
          "create unique index idx4id_ver_of_product on product_data (id, version);",
          "create  index idx4last_update_time_of_product on product_data (last_update_time);",
          "create  index idx4version_of_product on product_data (version);"
        },
        new String[] {
          "alter table product_data add constraint pk4id_of_product_data primary key (id);",
          "alter table product_data add constraint fk4parent_category_of_product_data foreign key (parent_category) references level_three_category_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
          ""
        });
  }
}
