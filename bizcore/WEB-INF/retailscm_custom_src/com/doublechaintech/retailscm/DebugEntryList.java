package com.doublechaintech.retailscm;

import java.util.*;

public class DebugEntryList {
  protected static List<List<String>> links = new ArrayList<>();

  static {
    // add("荐宝联盟", "appService/viewAffiliateAlliance/");
    add("提交注册申请", "resellerService/testSubmitRegistry/");
  }

  public List<List<String>> getLinks() {
    return links;
  }

  public void setLinks(List<List<String>> links) {
    this.links = links;
  }

  private static void add(String title, String url) {
    List<String> data = new ArrayList<>(2);
    data.add(title);
    data.add(url);
    links.add(data);
  }
}


