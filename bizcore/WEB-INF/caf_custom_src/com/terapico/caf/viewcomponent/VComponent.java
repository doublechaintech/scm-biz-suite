package com.terapico.caf.viewcomponent;

public interface VComponent {
  String getId();

  String getComponentType();

  String getLinkToUrl();

  String ACTION_GROUP = "action_group";
  String CARD_IN_LIST = "card_in_list";
  String INFO_LIST_ITEM = "info_list_item";
  String SLIDE = "slide";
  String ACTION = "action";
  String CARD_IN_SECTION = "card_in_section";
  String SECTION = "section";
  String USER = "user";
}
