package com.terapico.workflow;

import com.terapico.caf.DateTime;
import com.terapico.utils.DateTimeUtil;

import java.util.Date;

public class ProcessRecord {
    protected String eventId;
    protected String eventName;
    protected String statusCode;
    protected String statusName;
    protected String time;

    public ProcessRecord(){
        super();
        time = DateTimeUtil.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss.SSS Z");
    }
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

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
