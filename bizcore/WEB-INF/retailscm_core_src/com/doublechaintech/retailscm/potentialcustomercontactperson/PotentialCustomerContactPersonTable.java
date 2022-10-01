package com.doublechaintech.retailscm.potentialcustomercontactperson;

import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class PotentialCustomerContactPersonTable {

  public static AccessKey withId(Object value) {
    AccessKey accessKey = new AccessKey();
    accessKey.setColumnName(COLUMN_ID);
    accessKey.setValue(value);
    return accessKey;
  }
  // Add extra identifiers

  // only this package can use this, so the scope is default, not public, not private either nor
  // protected
  public static final String TABLE_NAME = "potential_customer_contact_person_data";
  static final String COLUMN_ID = "id";
  static final String COLUMN_NAME = "name";
  static final String COLUMN_MOBILE = "mobile";
  static final String COLUMN_POTENTIAL_CUSTOMER = "potential_customer";
  static final String COLUMN_DESCRIPTION = "description";
  static final String COLUMN_VERSION = "version";

  public static final String[] ALL_CLOUMNS = {
    COLUMN_ID,
    COLUMN_NAME,
    COLUMN_MOBILE,
    COLUMN_POTENTIAL_CUSTOMER,
    COLUMN_DESCRIPTION,
    COLUMN_VERSION
  };
  public static final String[] NORMAL_CLOUMNS = {
    COLUMN_NAME, COLUMN_MOBILE, COLUMN_POTENTIAL_CUSTOMER, COLUMN_DESCRIPTION
  };

  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result)
      throws Exception {
    RetailscmBaseUtils.ensureTable(
        userContext,
        result,
        "potential_customer_contact_person_data",
        new String[][] {
          new String[] {"id", "varchar(48)", " not null", "ID", "", ""},
          new String[] {"name", "varchar(12)", "", "名称", "", ""},
          new String[] {"mobile", "varchar(44)", "", "手机", "", ""},
          new String[] {
            "potential_customer", "varchar(48)", "", "潜在的客户", "potential_customer_data", "id"
          },
          new String[] {"description", "varchar(96)", "", "描述", "", ""},
          new String[] {"version", "int", "", "版本", "", ""}
        },
        "潜在客户联络人",
        new String[] {
          "create unique index idx4id_ver_of_potential_customer_contact_person on potential_customer_contact_person_data (id, version);",
          "create  index idx4mobile_of_potential_customer_contact_person on potential_customer_contact_person_data (mobile);",
          "create  index idx4version_of_potential_customer_contact_person on potential_customer_contact_person_data (version);"
        },
        new String[] {
          "alter table potential_customer_contact_person_data add constraint pk4id_of_potential_customer_contact_person_data primary key (id);",
          "alter table potential_customer_contact_person_data add constraint fk4potential_customer_of_potential_customer_contact_person_data foreign key (potential_customer) references potential_customer_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
          ""
        });
  }
}
