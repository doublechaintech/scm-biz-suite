package com.terapico.caf.viewcomponent;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 表单组件。
 * <p>
 * componentType=container
 * <br>containerType=form</br>
 * </p>
 * 
 * 表单也是一种container。 用于组合若干个需要提交的表单字段，也包括布局所需的其他组件。
 * 
 * @author clariones
 */
@JsonPropertyOrder({ "componentType", "containerType", "formId", "actionUrl", "method"})
public class FormViewComponent extends ContainerViewComponent {
    protected String actionUrl;
    protected String method = "POST";
    protected String formId;
    
    
    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getActionUrl() {
        return actionUrl;
    }

    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public FormViewComponent() {
	this(null);
    }
    
    public FormViewComponent(String actionUrl) {
	this(actionUrl, "POST");
    }

    public FormViewComponent(String actionUrl, String method) {
	this(actionUrl, method, null);
    }

    public FormViewComponent(String actionUrl, String method, String tag) {
	super();
	this.setActionUrl(actionUrl);
	if (method != null) {
	    this.setMethod(method);
	}
	this.setTag(tag);
	this.setContainerType("form");
	this.setFormId(String.format("%08X_%04X", System.currentTimeMillis(), (int)(Math.random()*0xFFFF)));
    }
    
}
