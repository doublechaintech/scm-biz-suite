package com.terapico.caf.viewcomponent;

import com.terapico.utils.TextUtil;

import java.util.Map;

public class VComponentAction extends BaseVC {
    protected String code;
    protected String title;
    protected String imageUrl;
    protected String icon;
    protected Boolean disabled;
    protected String group;
    protected String confirm;
    protected String brief;
    protected Boolean ajax;
    protected Boolean reLaunch;
    protected String navigationMethod;
    protected Map<String, Object> extraData;

    public VComponentAction() {
        super();
        this.setComponentType(VComponent.ACTION);
    }

    public VComponentAction id(String id) {
        this.setId(id);
        return this;
    }

    public VComponentAction linkToUrl(String linkToUrl) {
        this.setLinkToUrl(linkToUrl);
        return this;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String value) {
        this.code = value;
    }

    public VComponentAction code(String value) {
        this.code = value;
        return this;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public VComponentAction title(String value) {
        this.title = value;
        return this;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String value) {
        this.imageUrl = value;
    }

    public VComponentAction imageUrl(String value) {
        this.imageUrl = value;
        return this;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String value) {
        this.icon = value;
    }

    public VComponentAction icon(String value) {
        this.icon = value;
        return this;
    }

    public Boolean getDisabled() {
        return this.disabled;
    }

    public void setDisabled(Boolean value) {
        this.disabled = value;
    }

    public VComponentAction disabled(Boolean value) {
        this.disabled = value;
        return this;
    }

    public String getGroup() {
        return this.group;
    }

    public void setGroup(String value) {
        this.group = value;
    }

    public VComponentAction group(String value) {
        this.group = value;
        return this;
    }

    public String getConfirm() {
        return this.confirm;
    }

    public void setConfirm(String value) {
        this.confirm = value;
    }

    public VComponentAction confirm(String value) {
        this.confirm = value;
        return this;
    }

    public Map<String, Object> getExtraData() {
        return extraData;
    }

    public void setExtraData(Map<String, Object> extraData) {
        this.extraData = extraData;
    }

    public VComponentAction extraData(Map<String, Object> extraData) {
        setExtraData(extraData);
        return this;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public VComponentAction brief(String brief) {
        setBrief(brief);
        return this;
    }

    public VComponentAction setAttribute(String attrName, Object value) {
        String stdAttrName = toStandardAttributeName(attrName);
        if (handledByBaseAttribute(stdAttrName, value)) {
            return this;
        }
        switch (attrName) {
            case "code":
                if (checkAttributeValueAssignable(value, String.class, "action的code必须是String类型")) {
                    setCode((String) value);
                }
                return this;
            case "title":
                if (checkAttributeValueAssignable(value, String.class, "action的title必须是String类型")) {
                    setTitle((String) value);
                }
                return this;
            case "imageUrl":
                if (checkAttributeValueAssignable(value, String.class, "action的imageUrl必须是String类型")) {
                    setImageUrl((String) value);
                }
                return this;
            case "icon":
                if (checkAttributeValueAssignable(value, String.class, "action的icon必须是String类型")) {
                    setIcon((String) value);
                }
                return this;
            case "disabled":
                if (checkAttributeValueAssignable(value, Boolean.class, "action的disabled必须是Boolean类型")) {
                    setDisabled((Boolean) value);
                }
                return this;
            case "group":
                if (checkAttributeValueAssignable(value, String.class, "action的group必须是String类型")) {
                    setGroup((String) value);
                }
                return this;
            case "confirm":
                if (checkAttributeValueAssignable(value, String.class, "action的confirm必须是String类型")) {
                    setConfirm((String) value);
                }
                return this;
            default:
                throw new RuntimeException("action 不支持设置属性 " + stdAttrName);
        }
    }

    public boolean isAjax() {
        return ajax;
    }

    public void setAjax(boolean ajax) {
        this.ajax = ajax;
    }

    public VComponentAction ajax(boolean ajax) {
        this.ajax = ajax;
        return this;
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

    public String getNavigationMethod() {
        return navigationMethod;
    }

    public void setNavigationMethod(String navigationMethod) {
        this.navigationMethod = navigationMethod;
    }

    public VComponentAction reLaunch(boolean reLaunch) {
        this.reLaunch = reLaunch;
        if (reLaunch) {
            this.navigationMethod = "replace";
        } else {
            this.navigationMethod = null;
        }
        return this;
    }

    public VComponentAction icon_default(String icon) {
        if (TextUtil.isBlank(getIcon())) {
            setIcon(icon);
        }
        return this;
    }
}
