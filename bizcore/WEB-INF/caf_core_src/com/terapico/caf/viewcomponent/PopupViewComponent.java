package com.terapico.caf.viewcomponent;

import java.util.ArrayList;
import java.util.List;

/**
 * popup: {
    title: '起拍价太高',
              text: '起拍价超过店铺保证金许可范围',
              closeActionText: '调价',
              actionList:[]
}
 * @author clariones
 *
 */
public class PopupViewComponent extends BaseViewComponent{
	protected String title;
	protected String text;
	protected String closeActionText;
	protected List<ButtonViewComponent> actionList;
	
	public PopupViewComponent(String title) {
		this(title, "关闭");
	}
	
	public PopupViewComponent(String title, String closeText) {
		this(title, null, "关闭");
	}
	
	public PopupViewComponent(String title, String text, String closeText) {
		this.title = title;
		this.text = text;
		this.closeActionText = closeText;
	}
	
	public PopupViewComponent addAction(String title, String code, String linkToUrl) {
		ButtonViewComponent btn = new ButtonViewComponent(title);
		btn.setTag(code);
		btn.setLinkToUrl(linkToUrl);
		addToActionList(btn);
		return this;
	}

	public PopupViewComponent addAction(ButtonViewComponent action) {
		addToActionList(action);
		return this;
	}
		
	private void addToActionList(ButtonViewComponent btn) {
		if (actionList == null) {
			actionList = new ArrayList<>();
		}
		actionList.add(btn);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCloseActionText() {
		return closeActionText;
	}

	public void setCloseActionText(String closeActionText) {
		this.closeActionText = closeActionText;
	}

	public List<ButtonViewComponent> getActionList() {
		return actionList;
	}

	public void setActionList(List<ButtonViewComponent> actionList) {
		this.actionList = actionList;
	}
	
	
}
