package com.terapico.workflow;

import java.util.HashMap;
import java.util.Map;

public class ProcessSpec {
    public static final String RESULT_CODE_SKIP = "__skip";
    public static final String RESULT_CODE_NO_EFFECT = "__no_effect";
    public static final String RESULT_CODE_FAIL = "__fail";
    public static final String RESULT_CODE_OK = "OK";
    public static final String CONDITION_OK = RESULT_CODE_OK;
    public static final String EVENT_ENTER = "ENTER";
    public static final String STATUS_START = "START";
    public static final String ROLE_SYSTEM = "__system";

    public static final String SPLIT_TO = "split_to";
    public static final String GO_TO = "go_to";
    public static final String COPY_TO = "copy_to";

    public static final String MUST_ALL = "must_all";
    public static final String MUST_ANY = "must_any";
    public static final String MUST_NO = "must_no";
    public static final String OPTION_ALL = "option_all";
    public static final String OPTION_ANY = "option_any";

    public static final String STATUS_JUST_NOT_GO_ANY_WHERE = "$GO_NO_WHERE$";


    // 各个处理节点的规格. Key 是节点的 statusCode 值
    Map<String, NodeSpec> nodesSpec;
    protected String name;
    protected String title;


    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Map<String, NodeSpec> getNodesSpec() {
        if (nodesSpec == null){
            nodesSpec = new HashMap<>();
        }
        return nodesSpec;
    }

    public void setNodesSpec(Map<String, NodeSpec> nodesSpec) {
        this.nodesSpec = nodesSpec;
    }


    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    protected NodeSpec addStatus(String statusCode, String title) {
        NodeSpec nodeSpec = new NodeSpec();
        nodeSpec.setStatusCode(statusCode);
        nodeSpec.setTitle(title);
        getNodesSpec().put(statusCode, nodeSpec);
        return nodeSpec;
    }

    public NodeSpec node(String statusCode) {
        return getNodesSpec().get(statusCode);
    }

    public EventSpec getEventSpec(String statusName, String eventName) {
        NodeSpec nSpec = this.getNodesSpec().get(statusName);
        if (nSpec == null){
            return null;
        }
        return nSpec.getEventsSpec().get(eventName);
    }
}
