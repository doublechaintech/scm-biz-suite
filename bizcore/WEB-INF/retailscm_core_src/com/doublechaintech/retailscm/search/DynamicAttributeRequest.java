package com.doublechaintech.retailscm.search;

public class DynamicAttributeRequest {
  private BaseRequest request;
  private String name;
  private String parentProperty;

  public DynamicAttributeRequest(
      String propertyName, BaseRequest request, String parentPropertyName) {
    this.request = request;
    this.name = propertyName;
    this.parentProperty = parentPropertyName;
  }

  public BaseRequest getRequest() {
    return request;
  }

  public void setRequest(BaseRequest pRequest) {
    request = pRequest;
  }

  public String getName() {
    return name;
  }

  public void setName(String pName) {
    name = pName;
  }

  public String getParentProperty() {
    return parentProperty;
  }

  public void setParentProperty(String pParentProperty) {
    parentProperty = pParentProperty;
  }
}
