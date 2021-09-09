package com.terapico.workflow;

import com.terapico.utils.CollectionUtils;

import java.util.*;

public class NodeSpec {
    // 状态码
    String statusCode;
    String title;

    // 各种event对应的处理规则. Key 是事件名称
    Map<String, EventSpec> eventsSpec;

    // 各种condition对应的目标节点
    Map<String, TargetConditionSpec> targetConditionSpecMap;

    // 进入检查条件: 这些node都需要. Key 是节点类型, Value 是校验规则, 见下例.
    // 这里的规则组合只是很简单的定义, 复杂的进入条件判断需要重载判断函数.
    Map<String, String> enterCheckingNodes;
    /**
     * {
     *     "wait_user_confirm":"must_all", : 至少需要1个wait_user_confirm, 如果有多个,每个都要 result=me
     *     "wait_supplier_confirm":"must_any",  :至少需要1个wait_supplier_confirm, 其中有一个是 result=me 就可以
     *     "wait_user_addition_proof":"option_all"  :如果存在wait_user_addition_proof, 全部都要满足 result=me
     *     "wait_supplier_addition_proof":"option_any"  :wait_supplier_addition_proof, 全部都要满足 result=me
     * }
     */

    Map<String, List<String>> roleActions;

    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Map<String, EventSpec> getEventsSpec() {
        if (eventsSpec == null){
            eventsSpec = new HashMap<>();
        }
        return eventsSpec;
    }

    public void setEventsSpec(Map<String, EventSpec> eventsSpec) {
        this.eventsSpec = eventsSpec;
    }

    public Map<String, String> getEnterCheckingNodes() {
        if (enterCheckingNodes == null){
            enterCheckingNodes = new HashMap<>();
        }
        return enterCheckingNodes;
    }

    public void setEnterCheckingNodes(Map<String, String> enterCheckingNodes) {
        this.enterCheckingNodes = enterCheckingNodes;
    }

    public Map<String, List<String>> getRoleActions() {
        if(roleActions == null) {
            roleActions = new HashMap<>();
        }
        return roleActions;
    }

    public void setRoleActions(Map<String, List<String>> roleActions) {
        this.roleActions = roleActions;
    }

    public Map<String, TargetConditionSpec> getTargetConditionSpecMap() {
        if (targetConditionSpecMap == null){
            targetConditionSpecMap = new HashMap<>();
        }
        return targetConditionSpecMap;
    }

    public void setTargetConditionSpecMap(Map<String, TargetConditionSpec> targetConditionSpecMap) {
        this.targetConditionSpecMap = targetConditionSpecMap;
    }

    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    public EventSpec addEvent(String eventName, String title) {
        EventSpec eventSpec = new EventSpec();
        eventSpec.setEventName(eventName);
        eventSpec.setTitle(title);
        getEventsSpec().put(eventName, eventSpec);
        return eventSpec;
    }

    public void addActions(String roleName, String ... actions) {
        getRoleActions().put(roleName, new ArrayList<>(Arrays.asList(actions)));
    }

    // 当事件 eventName 的 结果是 resultCode 时, 将会去向哪个node. 没有就是自己
    public Set<String> willGoto(String eventName, String resultCode) {
        Collection<String> conds = getResultConditions(eventName, resultCode);
        Set<String> result = new HashSet<>();
        if (conds == null || conds.isEmpty()){
            return result;
        }
        for (String cond : conds) {
            TargetConditionSpec spec = getTargetConditionSpecMap().get(cond);
            if (spec == null){
                continue;
            }
            result.addAll(spec.getTargetStatusCode());
        }
        return result;
    }

    protected Collection<String> getResultConditions(String eventName, String resultCode) {
        EventSpec evtSpec = getEventsSpec().get(eventName);
        return evtSpec.getResultConditionMap().values();
    }

    public void addConditionTarget(String condition, String type, String[] target) {
        TargetConditionSpec spec = new TargetConditionSpec();
        spec.setCode(condition);
        spec.setTransferType(type);
        spec.setTargetStatusCode(new ArrayList<>(Arrays.asList(target)));
        getTargetConditionSpecMap().put(condition, spec);
    }
}
