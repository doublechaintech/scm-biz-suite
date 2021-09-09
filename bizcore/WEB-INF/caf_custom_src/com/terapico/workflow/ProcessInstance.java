package com.terapico.workflow;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 整个工作流称为一个 Process
 */
public class ProcessInstance {


    // 类别: 大的工作流类型, 例如"请假审批工作流","提现工作流"
    protected String category;
    // 实例标识 通常格式为 <internal_type>_<instance_id>
    protected String id;
    // 当前工作流上存活的 '状态机实例'. key是节点类型,通常也就是状态机的'状态'
    protected Map<String, Node> nodes;
    // 附加信息. 需要持久化的额外信息
    protected Map<String, Serializable> extraData;
    // 摘要, 用于给人看的信息. 辅助调试,和实际业务无关.
    protected String brief;
    // 状态
    protected String statusName;
    protected String statusCode;
    // 记录
    protected List<ProcessRecord> log;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, Node> getNodes() {
        if (nodes == null) {
            nodes = new HashMap<>();
        }
        return nodes;
    }

    public void setNodes(Map<String, Node> nodes) {
        this.nodes = nodes;
    }

    public Map<String, Serializable> getExtraData() {
        return extraData;
    }

    public void setExtraData(Map<String, Serializable> extraData) {
        this.extraData = extraData;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public List<ProcessRecord> getLog() {
        if (log == null){
            log = new ArrayList<>();
        }
        return log;
    }

    public void setLog(List<ProcessRecord> log) {
        this.log = log;
    }

    public void addNode(Node node) {
        getNodes().put(node.getStatusName()+"_"+node.getId(), node);
    }

    public List<Node> getNodesByStatus(String status){
        return getNodes().values().stream().filter(n->n.getStatusName().equals(status))
                .collect(Collectors.toList());
    }

    public void log(String message) {
        log("AUTO_"+this.getLog().size()+1, message);
    }
    public void log(String eventId, String message) {
        ProcessRecord evetLog = new ProcessRecord();
        evetLog.setEventId(eventId);
        evetLog.setEventName(message);
        evetLog.setStatusName(this.getStatusName());
        evetLog.setStatusCode(this.getStatusCode());
        this.getLog().add(evetLog);
    }
}
