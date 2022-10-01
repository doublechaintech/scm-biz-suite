package com.doublechaintech.retailscm.retailstorecountrycenter;

import com.doublechaintech.retailscm.AccessKey;

import com.doublechaintech.retailscm.BaseGridViewGenerator;

public class RetailStoreCountryCenterGridViewGenerator extends BaseGridViewGenerator {

  private static final long serialVersionUID = 1L;

  protected void throwExceptionIfListNotFount(String listName) {
    String message = String.format("List '%s' is not found for RetailStoreCountryCenter", listName);
    throw new IllegalArgumentException(message);
  }

  protected String[] getHeaderKeys(String listName) {

    if (RetailStoreCountryCenter.CATALOG_LIST.equals(listName)) {
      return new String[] {"id", "name", "owner", "sub_count", "amount", "version"};
    }
    if (RetailStoreCountryCenter.RETAIL_STORE_PROVINCE_CENTER_LIST.equals(listName)) {
      return new String[] {"id", "name", "founded", "country", "last_update_time", "version"};
    }
    if (RetailStoreCountryCenter.RETAIL_STORE_LIST.equals(listName)) {
      return new String[] {
        "id",
        "name",
        "telephone",
        "owner",
        "retail_store_country_center",
        "city_service_center",
        "creation",
        "investment_invitation",
        "franchising",
        "decoration",
        "opening",
        "closing",
        "founded",
        "latitude",
        "longitude",
        "description",
        "last_update_time",
        "version"
      };
    }
    if (RetailStoreCountryCenter.RETAIL_STORE_MEMBER_LIST.equals(listName)) {
      return new String[] {"id", "name", "mobile_phone", "owner", "version"};
    }
    if (RetailStoreCountryCenter.GOODS_SUPPLIER_LIST.equals(listName)) {
      return new String[] {
        "id",
        "name",
        "supply_product",
        "belong_to",
        "contact_number",
        "description",
        "last_update_time",
        "version"
      };
    }
    if (RetailStoreCountryCenter.SUPPLY_ORDER_LIST.equals(listName)) {
      return new String[] {
        "id", "buyer", "seller", "title", "contract", "total_amount", "last_update_time", "version"
      };
    }
    if (RetailStoreCountryCenter.RETAIL_STORE_ORDER_LIST.equals(listName)) {
      return new String[] {
        "id", "buyer", "seller", "title", "total_amount", "contract", "last_update_time", "version"
      };
    }
    if (RetailStoreCountryCenter.WAREHOUSE_LIST.equals(listName)) {
      return new String[] {
        "id",
        "location",
        "contact_number",
        "total_area",
        "owner",
        "latitude",
        "longitude",
        "contract",
        "last_update_time",
        "version"
      };
    }
    if (RetailStoreCountryCenter.TRANSPORT_FLEET_LIST.equals(listName)) {
      return new String[] {
        "id", "name", "contact_number", "owner", "contract", "last_update_time", "version"
      };
    }
    if (RetailStoreCountryCenter.ACCOUNT_SET_LIST.equals(listName)) {
      return new String[] {
        "id",
        "name",
        "year_set",
        "effective_date",
        "accounting_system",
        "domestic_currency_code",
        "domestic_currency_name",
        "opening_bank",
        "account_number",
        "country_center",
        "retail_store",
        "goods_supplier",
        "last_update_time",
        "version"
      };
    }
    if (RetailStoreCountryCenter.LEVEL_ONE_DEPARTMENT_LIST.equals(listName)) {
      return new String[] {
        "id", "belongs_to", "name", "description", "manager", "founded", "version"
      };
    }
    if (RetailStoreCountryCenter.SKILL_TYPE_LIST.equals(listName)) {
      return new String[] {"id", "code", "company", "description", "version"};
    }
    if (RetailStoreCountryCenter.RESPONSIBILITY_TYPE_LIST.equals(listName)) {
      return new String[] {
        "id", "code", "company", "base_description", "detail_description", "version"
      };
    }
    if (RetailStoreCountryCenter.TERMINATION_REASON_LIST.equals(listName)) {
      return new String[] {"id", "code", "company", "description", "version"};
    }
    if (RetailStoreCountryCenter.TERMINATION_TYPE_LIST.equals(listName)) {
      return new String[] {
        "id", "code", "company", "base_description", "detail_description", "version"
      };
    }
    if (RetailStoreCountryCenter.OCCUPATION_TYPE_LIST.equals(listName)) {
      return new String[] {"id", "code", "company", "description", "detail_description", "version"};
    }
    if (RetailStoreCountryCenter.LEAVE_TYPE_LIST.equals(listName)) {
      return new String[] {"id", "code", "company", "description", "detail_description", "version"};
    }
    if (RetailStoreCountryCenter.SALARY_GRADE_LIST.equals(listName)) {
      return new String[] {"id", "code", "company", "name", "detail_description", "version"};
    }
    if (RetailStoreCountryCenter.INTERVIEW_TYPE_LIST.equals(listName)) {
      return new String[] {"id", "code", "company", "description", "detail_description", "version"};
    }
    if (RetailStoreCountryCenter.TRAINING_COURSE_TYPE_LIST.equals(listName)) {
      return new String[] {"id", "code", "company", "name", "description", "version"};
    }
    if (RetailStoreCountryCenter.PUBLIC_HOLIDAY_LIST.equals(listName)) {
      return new String[] {"id", "code", "company", "name", "description", "version"};
    }
    if (RetailStoreCountryCenter.EMPLOYEE_LIST.equals(listName)) {
      return new String[] {
        "id",
        "company",
        "title",
        "department",
        "family_name",
        "given_name",
        "email",
        "city",
        "address",
        "cell_phone",
        "occupation",
        "responsible_for",
        "current_salary_grade",
        "salary_account",
        "last_update_time",
        "version"
      };
    }
    if (RetailStoreCountryCenter.INSTRUCTOR_LIST.equals(listName)) {
      return new String[] {
        "id",
        "title",
        "family_name",
        "given_name",
        "cell_phone",
        "email",
        "company",
        "introduction",
        "last_update_time",
        "version"
      };
    }
    if (RetailStoreCountryCenter.COMPANY_TRAINING_LIST.equals(listName)) {
      return new String[] {
        "id",
        "title",
        "company",
        "instructor",
        "training_course_type",
        "time_start",
        "duration_hours",
        "last_update_time",
        "version"
      };
    }

    throwExceptionIfListNotFount(listName);
    return new String[] {}; // place holder, code will never go here!!!
  }

  protected String getObjectKey(String listName) {
    if (RetailStoreCountryCenter.CATALOG_LIST.equals(listName)) {
      return "catalog";
    }
    if (RetailStoreCountryCenter.RETAIL_STORE_PROVINCE_CENTER_LIST.equals(listName)) {
      return "retail_store_province_center";
    }
    if (RetailStoreCountryCenter.RETAIL_STORE_LIST.equals(listName)) {
      return "retail_store";
    }
    if (RetailStoreCountryCenter.RETAIL_STORE_MEMBER_LIST.equals(listName)) {
      return "retail_store_member";
    }
    if (RetailStoreCountryCenter.GOODS_SUPPLIER_LIST.equals(listName)) {
      return "goods_supplier";
    }
    if (RetailStoreCountryCenter.SUPPLY_ORDER_LIST.equals(listName)) {
      return "supply_order";
    }
    if (RetailStoreCountryCenter.RETAIL_STORE_ORDER_LIST.equals(listName)) {
      return "retail_store_order";
    }
    if (RetailStoreCountryCenter.WAREHOUSE_LIST.equals(listName)) {
      return "warehouse";
    }
    if (RetailStoreCountryCenter.TRANSPORT_FLEET_LIST.equals(listName)) {
      return "transport_fleet";
    }
    if (RetailStoreCountryCenter.ACCOUNT_SET_LIST.equals(listName)) {
      return "account_set";
    }
    if (RetailStoreCountryCenter.LEVEL_ONE_DEPARTMENT_LIST.equals(listName)) {
      return "level_one_department";
    }
    if (RetailStoreCountryCenter.SKILL_TYPE_LIST.equals(listName)) {
      return "skill_type";
    }
    if (RetailStoreCountryCenter.RESPONSIBILITY_TYPE_LIST.equals(listName)) {
      return "responsibility_type";
    }
    if (RetailStoreCountryCenter.TERMINATION_REASON_LIST.equals(listName)) {
      return "termination_reason";
    }
    if (RetailStoreCountryCenter.TERMINATION_TYPE_LIST.equals(listName)) {
      return "termination_type";
    }
    if (RetailStoreCountryCenter.OCCUPATION_TYPE_LIST.equals(listName)) {
      return "occupation_type";
    }
    if (RetailStoreCountryCenter.LEAVE_TYPE_LIST.equals(listName)) {
      return "leave_type";
    }
    if (RetailStoreCountryCenter.SALARY_GRADE_LIST.equals(listName)) {
      return "salary_grade";
    }
    if (RetailStoreCountryCenter.INTERVIEW_TYPE_LIST.equals(listName)) {
      return "interview_type";
    }
    if (RetailStoreCountryCenter.TRAINING_COURSE_TYPE_LIST.equals(listName)) {
      return "training_course_type";
    }
    if (RetailStoreCountryCenter.PUBLIC_HOLIDAY_LIST.equals(listName)) {
      return "public_holiday";
    }
    if (RetailStoreCountryCenter.EMPLOYEE_LIST.equals(listName)) {
      return "employee";
    }
    if (RetailStoreCountryCenter.INSTRUCTOR_LIST.equals(listName)) {
      return "instructor";
    }
    if (RetailStoreCountryCenter.COMPANY_TRAINING_LIST.equals(listName)) {
      return "company_training";
    }

    throwExceptionIfListNotFount(listName);
    return ""; // place holder, code will never go here!!!
  }
}
