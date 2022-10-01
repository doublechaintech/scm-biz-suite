package com.doublechaintech.retailscm.potentialcustomercontact;

import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class PotentialCustomerContactTable {

  public static AccessKey withId(Object value) {
    AccessKey accessKey = new AccessKey();
    accessKey.setColumnName(COLUMN_ID);
    accessKey.setValue(value);
    return accessKey;
  }
  // Add extra identifiers

  // only this package can use this, so the scope is default, not public, not private either nor
  // protected
  public static final String TABLE_NAME = "potential_customer_contact_data";
  static final String COLUMN_ID = "id";
  static final String COLUMN_NAME = "name";
  static final String COLUMN_CONTACT_DATE = "contact_date";
  static final String COLUMN_CONTACT_METHOD = "contact_method";
  static final String COLUMN_POTENTIAL_CUSTOMER = "potential_customer";
  static final String COLUMN_CITY_PARTNER = "city_partner";
  static final String COLUMN_CONTACT_TO = "contact_to";
  static final String COLUMN_DESCRIPTION = "description";
  static final String COLUMN_LAST_UPDATE_TIME = "last_update_time";
  static final String COLUMN_VERSION = "version";

  public static final String[] ALL_CLOUMNS = {
    COLUMN_ID,
    COLUMN_NAME,
    COLUMN_CONTACT_DATE,
    COLUMN_CONTACT_METHOD,
    COLUMN_POTENTIAL_CUSTOMER,
    COLUMN_CITY_PARTNER,
    COLUMN_CONTACT_TO,
    COLUMN_DESCRIPTION,
    COLUMN_LAST_UPDATE_TIME,
    COLUMN_VERSION
  };
  public static final String[] NORMAL_CLOUMNS = {
    COLUMN_NAME,
    COLUMN_CONTACT_DATE,
    COLUMN_CONTACT_METHOD,
    COLUMN_POTENTIAL_CUSTOMER,
    COLUMN_CITY_PARTNER,
    COLUMN_CONTACT_TO,
    COLUMN_DESCRIPTION,
    COLUMN_LAST_UPDATE_TIME
  };

  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result)
      throws Exception {
    RetailscmBaseUtils.ensureTable(
        userContext,
        result,
        "potential_customer_contact_data",
        new String[][] {
          new String[] {"id", "varchar(48)", " not null", "ID", "", ""},
          new String[] {"name", "varchar(40)", "", "名称", "", ""},
          new String[] {"contact_date", "date", "", "接触日期", "", ""},
          new String[] {"contact_method", "varchar(16)", "", "接触法", "", ""},
          new String[] {
            "potential_customer", "varchar(48)", "", "潜在的客户", "potential_customer_data", "id"
          },
          new String[] {"city_partner", "varchar(48)", "", "城市合伙人", "city_partner_data", "id"},
          new String[] {
            "contact_to", "varchar(48)", "", "接触", "potential_customer_contact_person_data", "id"
          },
          new String[] {"description", "varchar(24)", "", "描述", "", ""},
          new String[] {"last_update_time", "datetime", "", "更新于", "", ""},
          new String[] {"version", "int", "", "版本", "", ""}
        },
        "潜在客户联系",
        new String[] {
          "create unique index idx4id_ver_of_potential_customer_contact on potential_customer_contact_data (id, version);",
          "create  index idx4contact_date_of_potential_customer_contact on potential_customer_contact_data (contact_date);",
          "create  index idx4last_update_time_of_potential_customer_contact on potential_customer_contact_data (last_update_time);",
          "create  index idx4version_of_potential_customer_contact on potential_customer_contact_data (version);"
        },
        new String[] {
          "alter table potential_customer_contact_data add constraint pk4id_of_potential_customer_contact_data primary key (id);",
          "alter table potential_customer_contact_data add constraint fk4potential_customer_of_potential_customer_contact_data foreign key (potential_customer) references potential_customer_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
          "alter table potential_customer_contact_data add constraint fk4city_partner_of_potential_customer_contact_data foreign key (city_partner) references city_partner_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
          "alter table potential_customer_contact_data add constraint fk4contact_to_of_potential_customer_contact_data foreign key (contact_to) references potential_customer_contact_person_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
          ""
        });
  }
}
