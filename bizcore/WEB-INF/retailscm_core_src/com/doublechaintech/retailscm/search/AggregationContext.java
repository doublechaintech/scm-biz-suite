package com.doublechaintech.retailscm.search;

import java.util.Map;

public class AggregationContext {
  private BaseRequest request;
  private String preCondition;
  private Map<String, Object> parameters;

  public BaseRequest getRequest() {
    return request;
  }

  public void setRequest(BaseRequest pRequest) {
    request = pRequest;
  }

  public String getPreCondition() {
    return preCondition;
  }

  public void setPreCondition(String pPreCondition) {
    preCondition = pPreCondition;
  }

  public Map<String, Object> getParameters() {
    return parameters;
  }

  public void setParameters(Map<String, Object> pParameters) {
    parameters = pParameters;
  }
}
