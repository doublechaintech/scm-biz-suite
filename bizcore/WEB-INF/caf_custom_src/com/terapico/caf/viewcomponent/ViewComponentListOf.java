package com.terapico.caf.viewcomponent;

import com.terapico.utils.DataTypeUtil;
import com.terapico.utils.MapUtil;
import com.terapico.utils.TextUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ViewComponentListOf extends BaseVC {
  protected String displayMode;
  protected String emptyMessage;
  protected List<? extends BaseVC> dataList;
  protected Map<String, Object> listMeta;
  protected boolean hasNextPage;

  @Override
  public BaseVC setAttribute(String attrName, Object value) {
    String stdAttrName = toStandardAttributeName(attrName);
    if (handledByBaseAttribute(stdAttrName, value)) {
      return this;
    }
    switch (attrName) {
      case "displayMode":
        setDisplayMode(String.valueOf(value));
        return this;
      case "emptyMessage":
        setEmptyMessage(String.valueOf(value));
        return this;
      case "hasNextPage":
        setHasNextPage(DataTypeUtil.getBoolean(value));
        return this;
      default:
        throw new RuntimeException("action 不支持设置属性 " + stdAttrName);
    }
  }

  public String getDisplayMode() {
    return displayMode;
  }

  public void setDisplayMode(String displayMode) {
    this.displayMode = displayMode;
  }

  public String getEmptyMessage() {
    if (emptyMessage == null) {
      return "目前没有数据";
    }
    return emptyMessage;
  }

  public void setEmptyMessage(String emptyMessage) {
    this.emptyMessage = emptyMessage;
  }

  public boolean isHasNextPage() {
    return hasNextPage;
  }

  public void setHasNextPage(boolean hasNextPage) {
    this.hasNextPage = hasNextPage;
  }

  public List<? extends BaseVC> getDataList() {
    return dataList;
  }

  public void setDataList(List<? extends BaseVC> dataList) {
    this.dataList = dataList;
  }

  public Map<String, Object> toUiElementMap(String name) {
    String name4listMeta = "listMeta";
    String name4list = "list";
    if (!TextUtil.isBlank(name)) {
      name4listMeta = name + "ListMeta";
      name4list = name + "List";
    }
    Map<String, Object> result = new HashMap<>();
    result.put("displayMode", getDisplayMode());
    result.put("emptyMessage", getEmptyMessage());
    result.put(
        name4listMeta,
        MapUtil.put("hasNextPage", isHasNextPage()).putIf("linkToUrl", getLinkToUrl()).into_map());
    result.put(name4list, makeListData());
    result.put("dataContainer", makeDataContainer());
    return result;
  }

  protected Map<String, Object> makeDataContainer() {
    if (getDataList() == null || getDataList().isEmpty()) {
      return new HashMap<>();
    }
    return getDataList().stream().collect(Collectors.toMap(BaseVC::getId, it -> it));
  }

  protected List<Object> makeListData() {
    if (getDataList() == null || getDataList().isEmpty()) {
      return new ArrayList<>();
    }
    return getDataList().stream()
        .map(it -> MapUtil.put("id", it.getId()).into_map())
        .collect(Collectors.toList());
  }
}
