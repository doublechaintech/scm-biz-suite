package com.terapico.caf.appview;

import com.terapico.caf.RemoteInitiable;
import com.terapico.changerequest.CRSpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChangeRequestData implements RemoteInitiable {
  protected static final CRGroupData GROUP_NOT_FOUND =
      new CRGroupData() {

        @Override
        public CRFieldSelector ensureField(String fieldId, String fieldName) {
          throw new RuntimeException("找不到指定的组");
        }

        @Override
        public CRFieldSelector tryField(String fieldId, String fieldName) {
          throw new RuntimeException("找不到指定的组");
        }
      };
  protected String id; // ：CR000001
  protected String type; // ：REGISTER
  protected String title; // ：婚姻注册申请
  protected String brief; // : 个人信息
  protected String sceneCode; // : person_info
  protected List<CRGroupData> groupList;
  protected List<CRSceneData> sceneList;

  protected List<CRAction> actionList;
  protected Map<String, CRAction> actions;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBrief() {
    return brief;
  }

  public void setBrief(String brief) {
    this.brief = brief;
  }
  //	public String getSceneCode() {
  //		return sceneCode;
  //	}
  //	public void setSceneCode(String sceneCode) {
  //		this.sceneCode = sceneCode;
  //	}
  public List<CRGroupData> getGroupList() {
    return groupList;
  }

  public void setGroupList(List<CRGroupData> groupList) {
    this.groupList = groupList;
  }

  public List<CRAction> getActionList() {
    return actionList;
  }

  public void setActionList(List<CRAction> actionList) {
    this.actionList = actionList;
  }

  public Map<String, CRAction> getActions() {
    return actions;
  }

  public void setActions(Map<String, CRAction> actions) {
    this.actions = actions;
  }

  public List<CRSceneData> getSceneList() {
    return sceneList;
  }

  public void setSceneList(List<CRSceneData> sceneList) {
    this.sceneList = sceneList;
  }

  public void addAction(CRSpec crSpec, String code, String title, String url) {
    CRAction action = new CRAction();
    action.setCode(code);
    action.setTitle(title);
    action.setLinkToUrl(url);

    ensureActionList().add(action);
    ensureActions().put(code, action);
  }

  protected List<CRAction> ensureActionList() {
    if (actionList == null) {
      actionList = new ArrayList<>();
    }
    return actionList;
  }

  protected Map<String, CRAction> ensureActions() {
    if (actions == null) {
      actions = new HashMap<>();
    }
    return actions;
  }

  public CRGroupData group(String groupName) {
    return this.getGroupList().stream()
        .filter(it -> it.getName().equals(groupName))
        .findFirst()
        .orElse(GROUP_NOT_FOUND);
  }
}
