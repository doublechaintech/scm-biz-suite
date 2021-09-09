package com.terapico.workflow;

import java.io.Serializable;
import java.util.Map;

public class Node {
    // 标识字段. 通常不需要,仅用于同一个工作流中同一个状态下有多个实例的场景
    protected String id;
    // 状态名称
    protected String statusName;
    // 摘要
    protected String brief;
    // 附加信息. 需要持久化的额外信息
    protected Map<String, Serializable> extraData;
    // 处理的result的结果
    protected String resultCode;
    // 是否被处理了
    protected transient boolean wasHandled = false;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Map<String, Serializable> getExtraData() {
        return extraData;
    }

    public void setExtraData(Map<String, Serializable> extraData) {
        this.extraData = extraData;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public boolean isWasHandled() {
        return wasHandled;
    }

    public void setWasHandled(boolean wasHandled) {
        this.wasHandled = wasHandled;
    }
}
