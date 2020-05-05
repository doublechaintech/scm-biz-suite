package com.terapico.caf.viewcomponent;

import java.util.Date;
import java.util.List;

public class ViewComponentBuilder<T extends BaseVC> {
  protected T vComponet;

  public static ViewComponentBuilder<VComponentCardInList> cardInList() {
    ViewComponentBuilder<VComponentCardInList> me =
        new ViewComponentBuilder<VComponentCardInList>();
    me.vComponet = new VComponentCardInList();
    return me;
  }

  public static ViewComponentBuilder<VComponentSlide> slide() {
    ViewComponentBuilder<VComponentSlide> me = new ViewComponentBuilder<VComponentSlide>();
    me.vComponet = new VComponentSlide();
    return me;
  }

  public static ViewComponentBuilder<VComponentAction> action() {
    ViewComponentBuilder<VComponentAction> me = new ViewComponentBuilder<VComponentAction>();
    me.vComponet = new VComponentAction();
    return me;
  }

  public static ViewComponentBuilder<VComponentCardInSection> cardInSection() {
    ViewComponentBuilder<VComponentCardInSection> me =
        new ViewComponentBuilder<VComponentCardInSection>();
    me.vComponet = new VComponentCardInSection();
    return me;
  }

  public static ViewComponentBuilder<VComponentSection> section() {
    ViewComponentBuilder<VComponentSection> me = new ViewComponentBuilder<VComponentSection>();
    me.vComponet = new VComponentSection();
    return me;
  }

  public static ViewComponentBuilder<VComponentUser> user() {
    ViewComponentBuilder<VComponentUser> me = new ViewComponentBuilder<VComponentUser>();
    me.vComponet = new VComponentUser();
    return me;
  }

  public T build() {
    return vComponet;
  }

  public ViewComponentBuilder<T> withId(String id) {
    vComponet.setId(id);
    return this;
  }

  public ViewComponentBuilder<T> withLinkToUrl(String linkToUrl) {
    vComponet.setLinkToUrl(linkToUrl);
    return this;
  }

  public ViewComponentBuilder<T> withTitle(String title) {
    vComponet.setAttribute("title", title);
    return this;
  }

  public ViewComponentBuilder<T> withBrief(String brief) {
    vComponet.setAttribute("brief", brief);
    return this;
  }

  public ViewComponentBuilder<T> withImageUrl(String imageUrl) {
    vComponet.setAttribute("imageUrl", imageUrl);
    return this;
  }

  public ViewComponentBuilder<T> withStatus(String status) {
    vComponet.setAttribute("status", status);
    return this;
  }

  public ViewComponentBuilder<T> withDisplayMode(String displayMode) {
    vComponet.setAttribute("displayMode", displayMode);
    return this;
  }

  public ViewComponentBuilder<T> withDocumentUrl(String documentUrl) {
    vComponet.setAttribute("documentUrl", documentUrl);
    return this;
  }

  public ViewComponentBuilder<T> withCreateTime(Date createTime) {
    vComponet.setAttribute("createTime", createTime);
    return this;
  }

  public ViewComponentBuilder<T> withActionList(List<VComponentAction> actionList) {
    vComponet.setAttribute("actionList", actionList);
    return this;
  }

  public ViewComponentBuilder<T> withName(String name) {
    vComponet.setAttribute("name", name);
    return this;
  }

  public ViewComponentBuilder<T> withVideoUrl(String videoUrl) {
    vComponet.setAttribute("videoUrl", videoUrl);
    return this;
  }

  public ViewComponentBuilder<T> withCode(String code) {
    vComponet.setAttribute("code", code);
    return this;
  }

  public ViewComponentBuilder<T> withIcon(String icon) {
    vComponet.setAttribute("icon", icon);
    return this;
  }

  public ViewComponentBuilder<T> withDisabled(Boolean disabled) {
    vComponet.setAttribute("disabled", disabled);
    return this;
  }

  public ViewComponentBuilder<T> withGroup(String group) {
    vComponet.setAttribute("group", group);
    return this;
  }

  public ViewComponentBuilder<T> withViewGroup(String viewGroup) {
    vComponet.setAttribute("viewGroup", viewGroup);
    return this;
  }

  public ViewComponentBuilder<T> withAvatar(String avatar) {
    vComponet.setAttribute("avatar", avatar);
    return this;
  }
}
