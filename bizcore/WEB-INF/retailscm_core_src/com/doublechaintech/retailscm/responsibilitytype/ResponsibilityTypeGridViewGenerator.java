package com.doublechaintech.retailscm.responsibilitytype;

import com.doublechaintech.retailscm.AccessKey;

import com.doublechaintech.retailscm.BaseGridViewGenerator;

public class ResponsibilityTypeGridViewGenerator extends BaseGridViewGenerator {

  private static final long serialVersionUID = 1L;

  protected void throwExceptionIfListNotFount(String listName) {
    String message = String.format("List '%s' is not found for ResponsibilityType", listName);
    throw new IllegalArgumentException(message);
  }

  protected String[] getHeaderKeys(String listName) {

    if (ResponsibilityType.EMPLOYEE_LIST.equals(listName)) {
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

    throwExceptionIfListNotFount(listName);
    return new String[] {}; // place holder, code will never go here!!!
  }

  protected String getObjectKey(String listName) {
    if (ResponsibilityType.EMPLOYEE_LIST.equals(listName)) {
      return "employee";
    }

    throwExceptionIfListNotFount(listName);
    return ""; // place holder, code will never go here!!!
  }
}
