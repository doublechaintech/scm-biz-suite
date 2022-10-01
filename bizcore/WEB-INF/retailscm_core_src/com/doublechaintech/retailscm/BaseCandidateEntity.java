package com.doublechaintech.retailscm;

public class BaseCandidateEntity<T extends BaseEntity> extends BaseEntity {

  protected String ownerClass;
  protected String ownerId;
  protected String filterKey;
  protected int pageNo;
  protected int totalPage;
  protected String displayFieldName;
  protected String valueFieldName;
  protected String groupByFieldName;
  protected SmartList<T> candidates;

  public String getOwnerClass() {
    return ownerClass;
  }

  public void setOwnerClass(String ownerClass) {
    this.ownerClass = ownerClass;
  }

  public String getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(String ownerId) {
    this.ownerId = ownerId;
  }

  public String getFilterKey() {
    return filterKey;
  }

  public void setFilterKey(String filterKey) {
    this.filterKey = filterKey;
  }

  public int getPageNo() {
    return pageNo;
  }

  public void setPageNo(int pageNo) {
    this.pageNo = pageNo;
  }

  public SmartList<T> getCandidates() {
    return candidates;
  }

  public void setCandidates(SmartList<T> candidates) {
    this.candidates = candidates;
  }

  public String getDisplayFieldName() {
    return displayFieldName;
  }

  public void setDisplayFieldName(String displayFieldName) {
    this.displayFieldName = displayFieldName;
  }

  public String getValueFieldName() {
    return valueFieldName;
  }

  public void setValueFieldName(String valueFieldName) {
    this.valueFieldName = valueFieldName;
  }

  public int getTotalPage() {
    return totalPage;
  }

  public void setTotalPage(int totalPage) {
    this.totalPage = totalPage;
  }

  public String getGroupByFieldName() {
    return groupByFieldName;
  }

  public void setGroupByFieldName(String groupByFieldName) {
    this.groupByFieldName = groupByFieldName;
  }
}
