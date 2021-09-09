package com.terapico.caf.wxappviewcomponent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.terapico.utils.MapUtil;

public class WxappListOf extends BaseWxappViewComponent<WxappListOf>{
	protected String displayMode;
	protected List<Map<String, Object>> list;
	protected Map<String, Object> dataContainer;
	
	public String getDisplayMode() {
		return displayMode;
	}

	public void setDisplayMode(String displayMode) {
		this.displayMode = displayMode;
	}

	public List<Map<String, Object>> getList() {
		return list;
	}

	public void setList(List<Map<String, Object>> list) {
		this.list = list;
	}

	public Map<String, Object> getDataContainer() {
		return dataContainer;
	}

	public void setDataContainer(Map<String, Object> dataContainer) {
		this.dataContainer = dataContainer;
	}

	public WxappListOf withDisplayMode(String dmode) {
		this.setDisplayMode(dmode);
		return this;
	}
	public WxappListOf item(Map<String, Object> itemValue) {
		ensureList();
		String id = (String) itemValue.get("id");
		list.add(MapUtil.put("id", id).into_map());
		dataContainer.put(id, itemValue);
		return this;
	}
	private void ensureList() {
		if (list != null) {
			return;
		}
		dataContainer = new HashMap<>();
		list = new ArrayList<>();
	}

	@Override
	protected void mapFieldsToMap(Map<String, Object> resultMap) {
		putInMap(resultMap, "displayMode", getDisplayMode());
		putInMap(resultMap, "list", getList());
		putInMap(resultMap, "dataContainer", getDataContainer());
	}

	@Override
	public String getType() {
		return "listof";
	}

}
