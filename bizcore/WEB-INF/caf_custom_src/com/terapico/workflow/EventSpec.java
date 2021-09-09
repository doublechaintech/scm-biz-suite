package com.terapico.workflow;

import java.util.*;

public class EventSpec {
    String eventName;
    String title;

    // 触发这个事件时, 触发者的角色必须符合哪些. 如果是空, 表示没有限制
    Set<String> roles;

    // 判断角色的类型, true: 在roles清单里的都不允许; false: 在roles清单里的才允许
    boolean blockingList = false;

    // 各种处理结果的规格. Key 是 resultCode 的值
    Map<String, String> resultConditionMap;

    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public boolean isBlockingList() {
        return blockingList;
    }

    public void setBlockingList(boolean blockingList) {
        this.blockingList = blockingList;
    }

    public Map<String, String> getResultConditionMap() {
        if (resultConditionMap == null){
            resultConditionMap = new HashMap<>();
        }
        return resultConditionMap;
    }

    public void setResultConditionMap(Map<String, String> resultConditionMap) {
        this.resultConditionMap = resultConditionMap;
    }

///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////

    public boolean allowRole(String role) {
        if (roles == null || roles.isEmpty()){
            return true;
        }
        if (roles.contains(role)){
            return !blockingList;
        }
        return blockingList;
    }

    public void addResult(String resultCode, String resultTitle, String reachCondition) {
        getResultConditionMap().put(resultCode, reachCondition);
    }

    public void setAllowedRoles(boolean blocking, String ... roleUsers) {
        setBlockingList(blocking);
        setRoles(new HashSet<>(Arrays.asList(roleUsers)));
    }
}
