package com.terapico.caf.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.util.TextUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.terapico.moyi.BaseCandidateEntity;
import com.terapico.moyi.BaseEntity;
import com.terapico.moyi.ImageInfo;
import com.terapico.utils.DebugUtil;
import com.terapico.utils.MapUtil;
import com.terapico.utils.RequestUtil;

public class BaseFormProcessor {
	protected String requestBody;
	protected Map<String, Object> params;
	protected String sceneCode;
	protected List<Map<String, Object>> actions;
	protected String tips;
	
	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips = tips;
	}
	protected void loadRequestBody(String requestBody) throws Exception {
		if (TextUtils.isBlank(requestBody)) {
			throw new Exception("请求参数为空");
		}
		this.requestBody = requestBody;
		params = new ObjectMapper().readValue(requestBody, Map.class);
		this.setSceneCode(this.pickStringParams("sceneCode"));
	}
	private Map<String, Object> basicFieldMapping(String paramName, Object defaultValue, Object candidateValues) {
		Map<String, Object> mappingResult = new HashMap<>();
		mappingResult.put("name", paramName);
		if (defaultValue != null) {
			mappingResult.put("value", defaultValue);
		}
		if (candidateValues != null) {
			if (candidateValues instanceof BaseCandidateEntity) {
				try {
					mappingResult.put("candidateValues", convertCandidateBaseEntity(candidateValues, defaultValue));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				mappingResult.put("candidateValues", candidateValues);
			}
		}
		return mappingResult;
	}

	private Object convertCandidateBaseEntity(Object candidateValues, Object defaultValue) throws Exception {
		List<Object> result = new ArrayList<>();
		BaseCandidateEntity list = (BaseCandidateEntity) candidateValues;
		String keyName = list.getDisplayFieldName();
		String valueName = list.getValueFieldName();
		for(Object item : list.getCandidates()) {
			BaseEntity obj = (BaseEntity) item;
			Map<String, Object> itemData = new HashMap<>();
			itemData.put("title", obj.propertyOf(keyName));
			itemData.put("code", obj.propertyOf(valueName));
			if (obj.propertyOf(valueName).equals(defaultValue)) {
				itemData.put("selected", true);
			}
			result.add(itemData);
		}
		return result;
	}
	protected Map<String, Object> mapBaseEntityFieldIntoUiForm(String paramName, String defaultValue, Object candidateValues) {
		return basicFieldMapping(paramName, defaultValue, candidateValues);
	}


	protected Map<String, Object> mapBooleanFieldIntoUiForm(String paramName, Boolean defaultValue) {
		return basicFieldMapping(paramName, defaultValue, null);
	}

	protected Map<String, Object> mapHiddenFieldIntoUiForm(String paramName, String defaultValue) {
		return basicFieldMapping(paramName, defaultValue, null);
	}

	protected Map<String, Object> mapImagesFieldIntoUiForm(String paramName, List<ImageInfo> defaultValue) {
		Map<String, Object> mappingResult = new HashMap<>();
		mappingResult.put("name", paramName);
		if (defaultValue != null && !defaultValue.isEmpty()) {
			mappingResult.put("value", defaultValue.get(0).getImageUrl());
		}
		return mappingResult;
	}
	
	protected Map<String, Object> mapImagesListIntoUiForm(String paramName, List<ImageInfo> defaultValue) {
		Map<String, Object> mappingResult = new HashMap<>();
		mappingResult.put("name", paramName);
		if (defaultValue == null || defaultValue.isEmpty()) {
			return mappingResult;
		}
		List<Object> resultList = new ArrayList<>();
		mappingResult.put("value", resultList);
		
		for(ImageInfo image: defaultValue) {
			Map<String, Object> item = new HashMap<>();
			if (image.getId() != null) {
				item.put("id", image.getId());
			}
			if (image.getContent() != null) {
				item.put("content", image.getContent());
			}
			if (image.getImageUrl() != null) {
				item.put("imageUrl", image.getImageUrl());
			}
			if (image.getHeight() > 0) {
				item.put("height", image.getHeight());
			}
			if (image.getWidth() > 0) {
				item.put("width", image.getWidth());
			}
			if (item.isEmpty()) {
				continue;
			}
			resultList.add(item);
		}
		return mappingResult;
	}

	protected Map<String, Object> mapStringArrayFieldIntoUiForm(String paramName, String[] defaultValue) {
		return basicFieldMapping(paramName, defaultValue, null);
	}

	protected Map<String, Object> mapStringFieldIntoUiForm(String paramName, String defaultValue) {
		return basicFieldMapping(paramName, defaultValue, null);
	}

	protected Map<String, Object> mapStringSelectionFieldIntoUiForm(String paramName, String defaultValue, Object candidateValues) {
		return basicFieldMapping(paramName, defaultValue, candidateValues);
	}

	protected Boolean pickBooleanParams(String paramName) {
		return RequestUtil.getBooleanInput(params, paramName, false);
	}

	protected List<ImageInfo> pickImagesParams(String paramName) throws Exception {
//		String imagesVal = RequestUtil.getStringInput(params, paramName, "");
//		return imagesVal.split(";");
		List<Object> list = (List<Object>) this.params.get(paramName);
		if(list == null || list.isEmpty()) {
			return new ArrayList<>();
		}
		
		List<ImageInfo> images = new ArrayList<>();
		for(Object item : list) {
			String imagesVal = DebugUtil.getObjectMapper().writeValueAsString(item);
			ImageInfo data = DebugUtil.getObjectMapper().readValue(imagesVal, ImageInfo.class);
			images.add(data);
		}
		return images;
	}

	protected String[] pickStringArrayParams(String paramName) {
//		String imagesVal = RequestUtil.getStringInput(params, paramName, "");
		Object value = params.get(paramName);
		if (value == null) {
			return null;
		}
		if (value instanceof List) {
			return ((List<String>) value).toArray(new String[] {});
		}
		if (value.getClass().isArray()) {
			return (String[]) value;
		}
		return new String[] {String.valueOf(value)};
	}

	protected String pickStringParams(String paramName) {
		return RequestUtil.getStringInput(params, paramName, null);
	}
	
	protected Double pickDoubleParams(String paramName) {
		return RequestUtil.getDoubleInput(params, paramName, null);
	}
	
	protected boolean verifyStringInput(String input, Integer minLength, Integer maxLength) {
		if (input == null) {
			return true;
		}
		if (minLength != null && input.length() < minLength) {
			return false;
		}
		if (maxLength != null && input.length() > maxLength) {
			return false;
		}
		return true;
	}
	protected boolean verifyBooleanInput(Boolean val) {
		return true;
	}
	protected boolean verifyImagesInput(List<ImageInfo> images, boolean canbeNull, Integer maxLength) {
		if (images == null && canbeNull) {
			return true;
		}
		if ((images == null || images.size() == 0) && canbeNull) {
			return true;
		}
		if (maxLength != null && images.size() > maxLength) {
			return false;
		}
		return true;
	}
	protected boolean verifyDoubleInput(Double input, double minValue, double maxValue) {
		if (input == null) {
			return true;
		}
		if (minValue > input) {
			return false;
		}
		if (maxValue < input) {
			return false;
		}
		return true;
	}
	protected Object mapDoubleFieldIntoUiForm(String paramName, Double defaultValue) {
		return basicFieldMapping(paramName, defaultValue, null);
	}
	protected Integer pickIntegerParams(String paramName) {
		return RequestUtil.getIntegerInput(params, paramName, null);
	}
	
	protected boolean verifyIntegerInput(Integer input, int minValue, int maxValue) {
		if (input == null) {
			return true;
		}
		if (minValue > input) {
			return false;
		}
		if (maxValue < input) {
			return false;
		}
		return true;
	}
	protected Object mapIntegerFieldIntoUiForm(String paramName, Integer defaultValue) {
		return basicFieldMapping(paramName, defaultValue, null);
	}
	public String getSceneCode() {
		return sceneCode;
	}
	public void setSceneCode(String sceneCode) {
		this.sceneCode = sceneCode;
	}
	
	public List<Map<String, Object>> getActions() {
		return actions;
	}
	public void setActions(List<Map<String, Object>> actions) {
		this.actions = actions;
	}
	public void addAction(String title, String code, String linkToUrl) {
		ensureActions();
		Map<String, Object> action = MapUtil.newMap( MapUtil.$("title", title), MapUtil.$("code", code),MapUtil.$("linkToUrl", linkToUrl));
		actions.add(action);
	}
	private void ensureActions() {
		if (actions == null) {
			actions = new ArrayList<>();
		}
		
	}
	protected void mappingFormActions(Map<String, Object> result) {
		if (!TextUtils.isBlank(tips)) {
			result.put("tips", tips);
		}
		result.put("actionList", this.getActions());
		result.put("actions", convertActionMap());
	}
	private Object convertActionMap() {
		Map<String, Object> result = new HashMap<>();
		for(Map<String, Object> item : actions) {
			result.put((String) item.get("code"), item);
		}
		return result;
	}
	protected boolean verifyStringArrayInput(String[] inputData, Integer minCnt, Integer maxCnt) {
		if (inputData == null) {
			return true;
		}
		if (minCnt != null && inputData.length < minCnt) {
			return false;
		}
		if (maxCnt != null && inputData.length > maxCnt) {
			return false;
		}
		return true;
	}

}
