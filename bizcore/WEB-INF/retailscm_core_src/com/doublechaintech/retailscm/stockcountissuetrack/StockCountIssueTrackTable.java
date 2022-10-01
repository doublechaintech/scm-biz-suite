package com.doublechaintech.retailscm.stockcountissuetrack;

import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class StockCountIssueTrackTable {

  public static AccessKey withId(Object value) {
    AccessKey accessKey = new AccessKey();
    accessKey.setColumnName(COLUMN_ID);
    accessKey.setValue(value);
    return accessKey;
  }
  // Add extra identifiers

  // only this package can use this, so the scope is default, not public, not private either nor
  // protected
  public static final String TABLE_NAME = "stock_count_issue_track_data";
  static final String COLUMN_ID = "id";
  static final String COLUMN_TITLE = "title";
  static final String COLUMN_COUNT_TIME = "count_time";
  static final String COLUMN_SUMMARY = "summary";
  static final String COLUMN_STOCK_COUNT = "stock_count";
  static final String COLUMN_VERSION = "version";

  public static final String[] ALL_CLOUMNS = {
    COLUMN_ID, COLUMN_TITLE, COLUMN_COUNT_TIME, COLUMN_SUMMARY, COLUMN_STOCK_COUNT, COLUMN_VERSION
  };
  public static final String[] NORMAL_CLOUMNS = {
    COLUMN_TITLE, COLUMN_COUNT_TIME, COLUMN_SUMMARY, COLUMN_STOCK_COUNT
  };

  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result)
      throws Exception {
    RetailscmBaseUtils.ensureTable(
        userContext,
        result,
        "stock_count_issue_track_data",
        new String[][] {
          new String[] {"id", "varchar(48)", " not null", "ID", "", ""},
          new String[] {"title", "varchar(16)", "", "头衔", "", ""},
          new String[] {"count_time", "date", "", "计数时间", "", ""},
          new String[] {"summary", "varchar(40)", "", "概览", "", ""},
          new String[] {
            "stock_count", "varchar(48)", "", "盘点", "goods_shelf_stock_count_data", "id"
          },
          new String[] {"version", "int", "", "版本", "", ""}
        },
        "库存计数问题跟踪",
        new String[] {
          "create unique index idx4id_ver_of_stock_count_issue_track on stock_count_issue_track_data (id, version);",
          "create  index idx4count_time_of_stock_count_issue_track on stock_count_issue_track_data (count_time);",
          "create  index idx4version_of_stock_count_issue_track on stock_count_issue_track_data (version);"
        },
        new String[] {
          "alter table stock_count_issue_track_data add constraint pk4id_of_stock_count_issue_track_data primary key (id);",
          "alter table stock_count_issue_track_data add constraint fk4stock_count_of_stock_count_issue_track_data foreign key (stock_count) references goods_shelf_stock_count_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
          ""
        });
  }
}
