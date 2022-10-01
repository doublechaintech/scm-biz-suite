package com.doublechaintech.retailscm;

import java.util.ArrayList;
import java.util.List;

public class StatsInfo extends Object {

  public List<StatsItem> getItemList() {

    if (itemList == null) {
      itemList = new ArrayList<StatsItem>();
    }

    return itemList;
  }

  public void addItem(StatsItem item) {
    if (item == null) {
      return;
    }
    if (item.getResult() == null) {
      return;
    }
    if (item.getResult().isEmpty()) {
      return;
    }
    getItemList().add(item);
  }

  public void setItemList(List<StatsItem> itemList) {
    this.itemList = itemList;
  }

  private List<StatsItem> itemList;
}
