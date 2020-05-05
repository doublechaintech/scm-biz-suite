package com.doublechaintech.retailscm;

//TODO: plan to remove this class in year of 2021.
class BaseAction {
	public static final String CHANGE_REQUEST_TYPE="changerequesttype";
	public static final String CUSTOM_ACTION="custom";
	
	public BaseAction asCustomGroup() {
		this.setActionGroup(CUSTOM_ACTION);
		return this;
	}
	public BaseAction asChangeRequestGroup() {
		this.setActionGroup(CHANGE_REQUEST_TYPE);
		return this;
	}
	
	public String[] specialActionTypes() {
		return new String[] {Action.CUSTOM_ACTION,Action.CHANGE_REQUEST_TYPE};
	}

	protected String actionName;
	protected String actionPath;
	protected String managerBeanName;
	protected String actionKey;
	protected String localeKey;
	protected String actionGroup;
	protected String actionLevel;
	protected String actionIcon;
	protected String actionId;
	
	public String getActionIcon() {
		return actionIcon;
	}

	public void setActionIcon(String actionIcon) {
		this.actionIcon = actionIcon;
	}
	
	
	public String getActionId() {
		if(actionId==null) {
			actionId = java.util.UUID.randomUUID().toString();
		}
		return actionId;
		
	}

	public String getActionGroup() {
		return actionGroup;
	}

	public void setActionGroup(String actionGroup) {
		this.actionGroup = actionGroup;
	}

	public String getActionLevel() {
		return actionLevel;
	}

	public void setActionLevel(String actionLevel) {
		this.actionLevel = actionLevel;
	}

	public String getLocaleKey() {
		return localeKey;
	}

	public void setLocaleKey(String localeKey) {
		this.localeKey = localeKey;
	}

	public String getActionKey() {
		return actionKey;
	}

	public void setActionKey(String actionKey) {
		this.actionKey = actionKey;
	}

	public String getActionPath() {
		return actionPath;
	}

	public void setActionPath(String actionPath) {
		this.actionPath = actionPath;
	}

	public String getManagerBeanName() {
		return managerBeanName;
	}

	public void setManagerBeanName(String managerBeanName) {
		this.managerBeanName = managerBeanName;
	}
	
	public String getActionName() {
		return actionName;
	}
	
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	
	
}

public class Action extends BaseAction{
	
	public Action withActionName(String name){
		super.setActionName(name);
		return this;
		
	}
	public Action withManagerBeanName(String managerBeanName){
		super.setManagerBeanName(managerBeanName);
		return this;
		
	}
	public Action withActionPath(String actionPath){
		super.setActionPath(actionPath);
		return this;
	}
	public Action withActionKey(String actionKey){
		super.setActionKey(actionKey);
		return this;
	}
	public Action withLocaleKey(String localeKey){
		super.setLocaleKey(localeKey);
		return this;
	}
	public Action withActionGroup(String actionGroup){
		super.setActionGroup(actionGroup);
		return this;
	}
	public Action withActionLevel(String actionLevel){
		super.setActionLevel(actionLevel);
		return this;
	}
	/*
	 * title
linkToURL
去掉
code
localeKey
group
level
icon
id

	 * 
	 * 
	 * */
	
	public String getTitle() {
		if(title==null) {
			return super.getActionName();
		}
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLinkToURL() {
		return linkToURL;
	}
	public void setLinkToURL(String linkToURL) {
		this.linkToURL = linkToURL;
	}
	public String getCode() {
		if(code==null) {
			return super.getActionKey();
		}
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLocaleKey() {
		if(localeKey==null) {
			return super.getLocaleKey();
		}
		return localeKey;
	}
	public void setLocaleKey(String localeKey) {
		this.localeKey = localeKey;
	}
	public String getGroup() {
		if(group==null) {
			return super.getActionGroup();
		}
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getLevel() {
		if(level==null) {
			return super.getActionLevel();
		}
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getId() {
		if(id==null) {
			return super.getActionId();
		}
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	protected String title;
	protected String linkToURL;
	protected String code;
	protected String localeKey;
	protected String group;
	protected String level;
	protected String id;

	
}



