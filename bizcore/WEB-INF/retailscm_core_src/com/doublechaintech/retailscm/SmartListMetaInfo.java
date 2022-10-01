package com.doublechaintech.retailscm;

import java.util.List;

public class SmartListMetaInfo extends BaseEntity {

  public void setAccessInfo(AccessInfo accessInfo) {
    this.accessInfo = accessInfo;
  }

  private AccessInfo accessInfo;
  static final String ACCESS_INFO = "accessInfo";

  public List<KeyValuePair> keyValuePairOf() {
    List<KeyValuePair> result = super.keyValuePairOf();
    appendKeyValuePair(result, ACCESS_INFO, this.getAccessInfo());
    appendKeyValuePair(result, "elementCount", getElementCount());
    appendKeyValuePair(result, "listInternalName", getListInternalName());

    return result;
  }

  public AccessInfo getAccessInfo() {

    if (accessInfo != null) {
      return accessInfo;
    }
    AccessInfo defaultAccessInfo = new AccessInfo();

    defaultAccessInfo.setCreatePermission(true);
    defaultAccessInfo.setInternalName("defaultAccess");
    defaultAccessInfo.setReadPermission(true);
    defaultAccessInfo.setCreatePermission(true);
    defaultAccessInfo.setDeletePermission(true);
    defaultAccessInfo.setUpdatePermission(true);
    defaultAccessInfo.setExecutionPermission(true);

    return defaultAccessInfo;
  }

  private static final long serialVersionUID = 1L;

  public String getListInternalName() {
    return listInternalName;
  }

  public void setListInternalName(String listInternalName) {
    this.listInternalName = listInternalName;
  }

  public int getElementCount() {
    return elementCount;
  }

  public void setElementCount(int elementCount) {
    this.elementCount = elementCount;
  }

  private String listInternalName;
  private int elementCount;
}
