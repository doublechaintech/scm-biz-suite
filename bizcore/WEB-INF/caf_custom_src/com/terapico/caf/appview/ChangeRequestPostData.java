package com.terapico.caf.appview;

import com.terapico.changerequest.BaseChangeRequestHelper;
import com.terapico.changerequest.BaseCrConst;
import com.terapico.changerequest.CRFieldSpec;
import com.terapico.utils.MapUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChangeRequestPostData {
  protected String changeRequestType;
  protected String changeRequestId;
  protected String sceneCode;
  protected String actionCode;
  protected String actionGroup;
  protected Integer actionIndex;
  protected Map<String, List<Map<String, Object>>> fieldData;
  protected List<Map<String, Object>> verifyMessage;
  protected Map<String, Integer> groupIds;

  public List<Map<String, Object>> getVerifyMessage() {
    return verifyMessage;
  }

  public void setVerifyMessage(List<Map<String, Object>> verifyMessage) {
    this.verifyMessage = verifyMessage;
  }

  public String getChangeRequestType() {
    return changeRequestType;
  }

  public void setChangeRequestType(String changeRequestType) {
    this.changeRequestType = changeRequestType;
  }

  public String getChangeRequestId() {
    return changeRequestId;
  }

  public void setChangeRequestId(String changeRequestId) {
    this.changeRequestId = changeRequestId;
  }

  public String getSceneCode() {
    return sceneCode;
  }

  public void setSceneCode(String sceneCode) {
    this.sceneCode = sceneCode;
  }

  public Map<String, List<Map<String, Object>>> getFieldData() {
    return fieldData;
  }

  public void setFieldData(Map<String, List<Map<String, Object>>> fieldData) {
    this.fieldData = fieldData;
  }

  public String getActionCode() {
    return actionCode;
  }

  public void setActionCode(String actionCode) {
    this.actionCode = actionCode;
  }

  public String getActionGroup() {
    return actionGroup;
  }

  public void setActionGroup(String actionGroup) {
    this.actionGroup = actionGroup;
  }

  public Integer getActionIndex() {
    return actionIndex;
  }

  public void setActionIndex(Integer actionIndex) {
    this.actionIndex = actionIndex;
  }

  public Map<String, Integer> getGroupIds() {
    return groupIds;
  }

  public void setGroupIds(Map<String, Integer> groupIds) {
    this.groupIds = groupIds;
  }

  public void addFieldValue(
      String groupName, CRFieldSpec fieldSpec, String recordId, Object fieldValue) {
    List<Map<String, Object>> groupData = ensureFieldData().get(groupName);
    if (groupData == null) {
      groupData = new ArrayList<Map<String, Object>>();
      fieldData.put(groupName, groupData);
    }
    Map<String, Object> fdData =
        groupData.stream()
            .filter(
                fd -> {
                  if (recordId == null) {
                    return !fd.containsKey(BaseCrConst.FIELD_EVENT_ID);
                  } else {
                    return fd.get(BaseCrConst.FIELD_EVENT_ID).equals(recordId);
                  }
                })
            .findFirst()
            .orElse(null);
    String fieldName = BaseChangeRequestHelper.FIELD_NAME(fieldSpec);
    if (fdData != null) {
      fdData.put(fieldName, fieldValue);
      return;
    }
    fdData = new HashMap<>();
    groupData.add(fdData);
    if (recordId != null) {
      fdData.put(BaseCrConst.FIELD_EVENT_ID, recordId);
    }
    fdData.put(fieldName, fieldValue);
  }

  protected Map<String, List<Map<String, Object>>> ensureFieldData() {
    if (fieldData != null) {
      return fieldData;
    }
    return fieldData = new HashMap<>();
  }

  public void addVerifyErrorMessage(String fieldName, String label, String message) {
    ensureVerifyMessage()
        .add(
            MapUtil.put("fieldName", fieldName)
                .put("label", label)
                .put("message", message)
                .into_map());
  }

  protected List<Map<String, Object>> ensureVerifyMessage() {
    if (verifyMessage != null) {
      return verifyMessage;
    }
    return verifyMessage = new ArrayList<>();
  }
}
