package com.doublechaintech.retailscm.leveltwocategory;

import com.doublechaintech.retailscm.AccessKey;

import com.doublechaintech.retailscm.BaseGridViewGenerator;

public class LevelTwoCategoryGridViewGenerator extends BaseGridViewGenerator {

  private static final long serialVersionUID = 1L;

  protected void throwExceptionIfListNotFount(String listName) {
    String message = String.format("List '%s' is not found for LevelTwoCategory", listName);
    throw new IllegalArgumentException(message);
  }

  protected String[] getHeaderKeys(String listName) {

    if (LevelTwoCategory.LEVEL_THREE_CATEGORY_LIST.equals(listName)) {
      return new String[] {"id", "parent_category", "name", "version"};
    }

    throwExceptionIfListNotFount(listName);
    return new String[] {}; // place holder, code will never go here!!!
  }

  protected String getObjectKey(String listName) {
    if (LevelTwoCategory.LEVEL_THREE_CATEGORY_LIST.equals(listName)) {
      return "level_three_category";
    }

    throwExceptionIfListNotFount(listName);
    return ""; // place holder, code will never go here!!!
  }
}
