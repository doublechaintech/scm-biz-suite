package com.terapico.changerequest;

public class EventInfo {
    protected String eventType;
    protected String eventId;
    protected String fieldGroup;

    public EventInfo() {
        super();
    }

    public EventInfo(String eventType, String eventId, String fieldGroup) {
        this();
        this.eventType = eventType;
        this.eventId = eventId;
        this.fieldGroup = fieldGroup;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getFieldGroup() {
        return fieldGroup;
    }

    public void setFieldGroup(String fieldGroup) {
        this.fieldGroup = fieldGroup;
    }
}
