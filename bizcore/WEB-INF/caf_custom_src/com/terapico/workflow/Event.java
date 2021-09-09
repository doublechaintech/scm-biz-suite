package com.terapico.workflow;

import java.util.Map;

public class Event {
    protected String eventId;
    protected String eventName;
    protected Map<String, Object> params;
    protected Event rootEvent;
    protected String targetNode;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public Event getRootEvent() {
        return rootEvent;
    }

    public void setRootEvent(Event rootEvent) {
        this.rootEvent = rootEvent;
    }

    public String getTargetNode() {
        return targetNode;
    }

    public void setTargetNode(String targetNode) {
        this.targetNode = targetNode;
    }

    public Event root() {
        if (rootEvent == null){
            return this;
        }
        return rootEvent.root();
    }
}
