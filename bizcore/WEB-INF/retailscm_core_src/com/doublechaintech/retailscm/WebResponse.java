package com.doublechaintech.retailscm;

import java.util.ArrayList;
import java.util.List;

public class WebResponse {
  private Integer resultCode;
  private String status;
  private String message;
  private Integer recordCount;

  public Integer getRecordCount() {
    return recordCount;
  }

  public void setRecordCount(Integer recordCount) {
    this.recordCount = recordCount;
  }

  public WebResponse() {
    data = new ArrayList<>();
  }

  public List<BaseEntity> getData() {
    if (data == null) {
      data = new ArrayList<>();
    }
    return data;
  }

  public void setData(List<BaseEntity> data) {
    this.data = data;
  }

  List<BaseEntity> data;

  public static WebResponse fromList(List<? extends BaseEntity> smartList) {
    WebResponse webResponse = success();

    if (smartList == null || smartList.isEmpty()) {
      webResponse.setRecordCount(0);
      return webResponse;
    }
    webResponse.setRecordCount(smartList.size());
    smartList.forEach(
        baseEntity -> {
          // baseEntity.addAction(WebAction.modifyWebAction());
          webResponse.getData().add(baseEntity);
        });

    return webResponse;
  }

  public static WebResponse of(BaseEntity... baseEntities) {
    WebResponse webResponse = new WebResponse();

    if (baseEntities == null || baseEntities.length == 0) {
      webResponse.setRecordCount(0);
      return webResponse;
    }
    webResponse.setRecordCount(baseEntities.length);
    for (BaseEntity baseEntity : baseEntities) {
      webResponse.getData().add(baseEntity);
    }

    return webResponse;
  }

  public static WebResponse emptyList(String message) {
    WebResponse webResponse = success();
    webResponse.setMessage(message);
    return webResponse;
  }

  public static WebResponse success() {
    WebResponse webResponse = new WebResponse();
    webResponse.setResultCode(0);
    webResponse.setStatus("YES");
    return webResponse;
  }

  public static WebResponse fail(String message) {
    WebResponse webResponse = new WebResponse();
    webResponse.setStatus("NO");
    webResponse.setResultCode(1);
    webResponse.setMessage(message);
    return webResponse;
  }

  public static WebResponse fromSmartList(SmartList<? extends BaseEntity> smartList) {
    WebResponse webResponse = success();

    if (smartList == null || smartList.isEmpty()) {

      webResponse.setRecordCount(smartList.getTotalCount());

      return webResponse;
    }
    System.out.println("setTotalCount ==> fromSmartList " + smartList.getTotalCount());
    smartList.forEach(
        baseEntity -> {
          // baseEntity.addAction(WebAction.modifyWebAction());
          // webReponse.getData().add(baseEntity);
        });
    webResponse.setRecordCount(smartList.getTotalCount());
    smartList.forEach(
        baseEntity -> {
          // baseEntity.addAction(WebAction.modifyWebAction());
          webResponse.getData().add(baseEntity);
        });

    return webResponse;
  }

  public Integer getResultCode() {
    return resultCode;
  }

  public void setResultCode(Integer resultCode) {
    this.resultCode = resultCode;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
