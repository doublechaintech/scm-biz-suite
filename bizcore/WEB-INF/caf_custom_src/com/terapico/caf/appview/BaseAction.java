package com.terapico.caf.appview;

import java.util.Map;

public class BaseAction {
    protected String code;
    protected String title;
    protected String linkToUrl;
    protected Boolean ajax;
    protected Boolean reLaunch;
    protected Map<String, Object> extraData;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLinkToUrl() {
        return linkToUrl;
    }

    public void setLinkToUrl(String linkToUrl) {
        this.linkToUrl = linkToUrl;
    }

    public Boolean getAjax() {
        return ajax;
    }

    public void setAjax(Boolean ajax) {
        this.ajax = ajax;
    }

    public Boolean getReLaunch() {
        return reLaunch;
    }

    public void setReLaunch(Boolean reLaunch) {
        this.reLaunch = reLaunch;
    }

    public Map<String, Object> getExtraData() {
        return extraData;
    }

    public void setExtraData(Map<String, Object> extraData) {
        this.extraData = extraData;
    }
}
