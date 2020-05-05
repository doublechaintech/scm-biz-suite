
package com.doublechaintech.retailscm;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.terapico.caf.viewcomponent.BaseViewComponent;
import com.terapico.caf.viewcomponent.ButtonViewComponent;
import com.terapico.caf.viewcomponent.FilterTabsViewComponent;
import com.terapico.caf.viewcomponent.PopupViewComponent;
import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.utils.MapUtil;
import com.terapico.utils.TextUtil;

@SuppressWarnings({ "rawtypes", "unchecked" })
public abstract class BaseViewPage extends HashMap<String, Object> {
	public static final String X_EMPTY_MESSAGE = "emptyMessage";
	public static final String X_NEXT_PAGE_URL = "nextPageUrl";
	private static final boolean OBJECT_HASHCODE = false;
	
	public static Map<String, Object> makeToast(String content, int duration, String type) {
		return MapUtil.put("text", content)
				.put("duration", duration * 1000)
				.put("icon", type)
				.put("position", "center").into_map();
	}
	
	public void addHashCode(Map<String, Object> resultMap) {
		if (resultMap == null || resultMap.isEmpty()) {
			return;
		}
		String hashCode = calcResultMapHashCode(resultMap);
		resultMap.put("hashCode", hashCode);
	}
	
	protected String calcResultMapHashCode(Map<String, Object> resultMap) {
		String str = "";
		try {
			str = getObjectMapper().writeValueAsString(resultMap);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "HC"+str.hashCode();
	}
	protected ObjectMapper getObjectMapper() {
		ObjectMapper _mapper = new ObjectMapper();
        _mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        _mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        _mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        return _mapper;
	}
	public interface CustomSerializer {
		Object serialize(SerializeScope serializeScope, Object value, String path);
	}


	protected static final long serialVersionUID = 1L;
	@JsonIgnore
	protected RetailscmUserContext userContext;
	@JsonIgnore
	protected HashMap<String, Object> dataPool;
	@JsonIgnore
	protected String pageTitle;
	@JsonIgnore
	protected String linkToUrl;
	@JsonIgnore
	protected HashMap<String, Object> dataContainer;
	
	public String getLinkToUrl() {
		return linkToUrl;
	}
	public void setLinkToUrl(String linkToUrl) {
		this.linkToUrl = linkToUrl;
	}
	public String getPageTitle() {
		return pageTitle;
	}
	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}
	
	public void set(String name, Object value) {
		ensureDataPool();
		dataPool.put(name, value);
	}
	public void assemblerContent(RetailscmUserContext userContext, String requestName) throws Exception {
		setPageTitle("尚未实现");
	}
	public Map<String, Object> doRender(RetailscmUserContext userContext) {
		this.userContext = userContext;
		beforeDoRendering();
		doRendering();
		this.userContext.forceResponseXClassHeader(this.getClass().getName());
		afterDoRendering();
		return this;
	}

	protected void beforeDoRendering() {
		userContext.setResponseHeader("x-actor-class", this.getClass().getName());
		addFieldToOwner(this, null, "pageTitle", this.getPageTitle());
		addFieldToOwner(this, null, "linkToUrl", this.getLinkToUrl());
	}

	protected void afterDoRendering() {
		this.addHashCode(this);
	}

	protected abstract SerializeScope getSerializeScope();

	protected void ensureDataPool() {
		if (dataPool == null) {
			dataPool = new HashMap<>();
		}
	}

	protected void addFieldToOwner(Map<String, Object> owner, SerializeScope scope, String fieldName,
			Object fieldValue) {
		if (isEmptyValue(fieldValue)) {
			if (scope == null) {
				return;
			}
			if ("list".equals(scope.getForceWhenEmpty())) {
				owner.put(fieldName, new ArrayList<Object>());
			}
			if ("object".equals(scope.getForceWhenEmpty())) {
				owner.put(fieldName, new HashMap<String, Object>());
			}
			if ("string".equals(scope.getForceWhenEmpty())) {
				owner.put(fieldName, "");
			}
			return;
		}

		if (shouldMoveUp(scope, fieldValue)) {
			owner.putAll((Map) fieldValue);
		}else {
			Object finalValue = fieldValue;
			if (scope != null && scope.getPrefix() != null) {
				finalValue = scope.getPrefix() + finalValue;
			}
			if (scope != null && scope.getPostfix() != null) {
				finalValue = finalValue + scope.getPostfix();
			}
			owner.put(fieldName, finalValue);
		}
	}
	protected boolean shouldMoveUp(SerializeScope scope, Object fieldValue) {
		return scope != null && scope.isMoveUp() && fieldValue instanceof Map;
	}

	protected boolean isEmptyValue(Object fieldValue) {
		if (fieldValue == null) {
			return true;
		}
		if (fieldValue instanceof Collection && ((Collection<?>) fieldValue).isEmpty()) {
			return true;
		}
		if (fieldValue instanceof Map && ((Map<?, ?>) fieldValue).isEmpty()) {
			return true;
		}
		if (fieldValue.getClass().isArray() && ((Object[]) fieldValue).length == 0) {
			return true;
		}
		return false;
	}
	protected boolean isZeroValue(Object value) {
		if (value instanceof Boolean) {
			return !((Boolean) value).booleanValue();
		}
		if (value instanceof BigDecimal) {
			return ((BigDecimal) value).signum() == 0;
		}
		if (value instanceof BigInteger) {
			return ((BigInteger) value).signum() == 0;
		}
		if (value instanceof Number) {
			return ((Number) value).doubleValue() == 0;
		}
		if (value instanceof String) {
			return TextUtil.isBlank((String) value);
		}
		return false;
	}
	
	
	protected void doRendering() {
		SerializeScope srlScope = getSerializeScope();
		ensureDataPool();
		addFieldToOwner(this, null, "pageTitle", this.getPageTitle());
		doRenderingMap(this, srlScope, dataPool, "/");
	}

	protected void doRenderingMap(Map<String, Object> resultMap, SerializeScope srlScope, Map<String, Object> dataMap,
			String path) {
		if (dataMap == null || dataMap.isEmpty()) {
			return;
		}
		dataMap.forEach((key, value) -> {
			handleOneData(resultMap, srlScope, path, key, value);
		});
		if (OBJECT_HASHCODE) {
			addHashCode(resultMap);
		}
	}

	protected void handleOneData(Map<String, Object> resultMap, SerializeScope srlScope, String path, String key,
			Object value) {
		if (value == null) {
			return;
		}
		if (!srlScope.visible(key)) {
			return;
		}

		String hashCode = "/"+value.hashCode() + "/";
		if (path.contains(hashCode)) {
			return;
		}
		String newPath = path + hashCode;

		SerializeScope fieldScope = srlScope.getFieldScope(key);
		if (fieldScope.isShowWhenNotEmpty() && (isEmptyValue(value) || isZeroValue(value))) {
			return;
		}
		String outputName = fieldScope.getAliasName() == null ? key : fieldScope.getAliasName();
		CustomSerializer cSerializer = getCustomSerializerByObject(value);
		// 如果有自定义的序列化方法，优先使用自定义的
		if (cSerializer != null) {
			Object convertResult = cSerializer.serialize(fieldScope, value, newPath);
			addFieldToOwner(resultMap, fieldScope, outputName, convertResult);
			return;
		}

		// 没有的话，就使用约定的方法
		Object convertResult = doRenderingObject(fieldScope, value, newPath, resultMap, outputName);
		addFieldToOwner(resultMap, fieldScope, outputName, convertResult);
	}

	protected Object doRenderingObject(SerializeScope fieldScope, Object value, String path,
			Map<String, Object> resultMap, String key) {
		if (value instanceof SmartList) {
			return doRenderingSmartList(fieldScope, (SmartList) value, path, resultMap, key);

		}
		if (value.getClass().isArray()) {
			return doRenderingList(fieldScope, Arrays.asList((Object[])value), path, resultMap, key);
		}
		if (value instanceof List) {
			return doRenderingList(fieldScope, (List) value, path, resultMap, key);
		}
		if (value instanceof Map) {
			Map<String, Object> convertResult = new HashMap<>();
			doRenderingMap(convertResult, fieldScope, (Map) value, path);
			return convertResult;
		}
		if (value instanceof BaseEntity) {
			return doRenderingBaseEntity(fieldScope, (BaseEntity) value, path);
		}
		if (value instanceof BaseViewComponent) {
			return ((BaseViewComponent) value).toMap();
		}
		// 最后了，没办法了
		if (fieldScope.isRevers()) {
			if (value instanceof BigDecimal) {
				return ((BigDecimal) value).negate();
			}
			if (value instanceof Double) {
				return -((Double)value);
			}
			if (value instanceof Float) {
				return -((Float)value);
			}
			if (value instanceof Integer) {
				return -((Integer)value);
			}
			if (value instanceof BigInteger) {
				return ((BigInteger)value).negate();
			}
			if (value instanceof String) {
				return new StringBuffer((String) value).reverse().toString();
			}
			// 其他数据类型忽略 reverse()
		}
		return value;
	}

	protected Map<String, Object> doRenderingBaseEntity(SerializeScope scope, BaseEntity value, String path) {
		if (value == null) {
			return null;
		}
		List<KeyValuePair> dataList = value.keyValuePairOf();
		Map<String, Object> resultMap = new HashMap<>();
		// 先序列化字段
		for (KeyValuePair dataItem : dataList) {
			String fieldName = dataItem.getKey();
			Object fieldValue = dataItem.getValue();
			handleOneData(resultMap, scope, path, fieldName, fieldValue);
		}
		// 再序列化附加字段
		doRenderingMap(resultMap, scope, value.getValueMap(), path);
		if (OBJECT_HASHCODE) {
			addHashCode(resultMap);
		}
		return resultMap;
	}

	protected Object doRenderingList(SerializeScope fieldScope, List<? extends Object> asList, String path,
			Map<String, Object> resultMap, String key) {
		if (asList == null || asList.isEmpty()) {
			if ("list".equals(fieldScope.getForceWhenEmpty())) {
				return new ArrayList<Object>();
			}
			if ("object".equals(fieldScope.getForceWhenEmpty())) {
				return new HashMap<String, Object>();
			}
			return null;
		}
		List<Object> resultList = new ArrayList<>(asList.size());
		for (Object item : asList) {
			if (item == null) {
				continue;
			}
			String outputName = fieldScope.getAliasName() == null ? key : fieldScope.getAliasName();
			CustomSerializer cSerializer = getCustomSerializerByObject(item);
			// 如果有自定义的序列化方法，优先使用自定义的
			if (cSerializer != null) {
				Object convertResult = cSerializer.serialize(fieldScope, item, path);
				saveListItemConvertResult(fieldScope, resultList, item, convertResult);
				continue;
			}
			Object convertResult = doRenderingObject(fieldScope, item, path, resultMap, key);
			saveListItemConvertResult(fieldScope, resultList, item, convertResult);
		}
		if (fieldScope.isRevers()) {
			Collections.reverse(resultList);
		}
		return resultList;
	}
	protected void saveListItemConvertResult(SerializeScope fieldScope, List<Object> resultList, Object item,
			Object convertResult) {
		if (convertResult != null) {
			if (fieldScope.isPutInDataContainer()) {
				if (item instanceof BaseEntity) {
					String skey = ((BaseEntity) item).getInternalType()+"_"+((BaseEntity) item).getId();
					resultList.add(MapUtil.put("id", skey).into_map());
					addToDataContainer(skey, convertResult);
				} else {
					String skey = item.getClass().getSimpleName()+"_"+item.hashCode();
					resultList.add(MapUtil.put("id", skey).into_map());
					addToDataContainer(skey, convertResult);
				}
			}else {
				resultList.add(convertResult);
			}
		}
	}

	protected void addToDataContainer(String skey, Object convertResult) {
		ensureDataContainer();
		dataContainer.put(skey, convertResult);
	}
	protected void ensureDataContainer() {
		if (this.dataContainer == null) {
			this.dataContainer = new HashMap<>();
			this.put("dataContainer", dataContainer);
		}
	}
	protected Object doRenderingSmartList(SerializeScope fieldScope, SmartList<?> value, String path,
			Map<String, Object> resultMap, String key) {
		Object resultList = doRenderingList(fieldScope, (List) value, path, resultMap, key);
		if (value != null && !fieldScope.isNoListMeta()) {
			SmartList<?> dataList = value;
			Map<String, Object> metaData = new HashMap<String, Object>();
			if (dataList.getRowsPerPage() < dataList.size()) {
				addFieldToOwner(metaData, fieldScope, "hasNextPage", true);
				dataList.remove(dataList.size() - 1);
				addFieldToOwner(metaData, fieldScope, X_NEXT_PAGE_URL,
						dataList.valueByKey(X_NEXT_PAGE_URL));
				if (resultList instanceof List) {
					Map skey = (Map) ((List) resultList).remove(((List) resultList).size() - 1);
					if (fieldScope.isPutInDataContainer()) {
						dataContainer.remove(skey.get("id"));
					}
				}
			} else {
				metaData.put("hasNextPage", false);
			}
			if (dataList.isEmpty()) {
				String emptyMessage = (String) dataList.valueByKey(X_EMPTY_MESSAGE);
				if (emptyMessage == null) {
					emptyMessage = "暂时没有内容";
				}
				metaData.put(X_EMPTY_MESSAGE, emptyMessage);
			}
			resultMap.put(key + "Meta", metaData);
		}
		return resultList;
	}

	protected CustomSerializer getCustomSerializerByObject(Object object) {
		if (object instanceof FilterTabsViewComponent) {
			return new FilterTabsSerializer();
		}
		if (object instanceof BaseRetailscmFormProcessor) {
			return new FormProcessorSerializer();
		}
		if (object instanceof ButtonViewComponent) {
			// action 是特别定制的序列化
			return new ButtonViewComponentSerializer();
		}
		if (object instanceof PopupViewComponent) {
			// popup 也是特别定制的的
			return new PopupViewComponentSerializer();
		}
		return null;
	}

	protected void markAsAjaxResponse() {
		this.userContext.setResponseHeader("x-redirect", "false");
	}
	
	protected class FilterTabsSerializer implements CustomSerializer {
		@Override
		public Object serialize(SerializeScope serializeScope, Object value, String path) {
			FilterTabsViewComponent tabViewCmpt = (FilterTabsViewComponent) value;
			if (tabViewCmpt == null) {
				return null;
			}
			List<Map<String, Object>> contentList = (List<Map<String, Object>>) tabViewCmpt.getContent();
			if (contentList == null || contentList.isEmpty()) {
				return null;
			}
			List<Object> result = new ArrayList<>();
			SerializeScope fieldScope = SerializeScope.EXCLUDE();
			for (Map<String, Object> content : contentList) {
				Map<String, Object> resultData = new HashMap<>();
				addFieldToOwner(resultData, fieldScope, "title", content.get("text"));
				addFieldToOwner(resultData, fieldScope, "brief", content.get("tips"));
				addFieldToOwner(resultData, fieldScope, "code", content.get("code"));
				addFieldToOwner(resultData, fieldScope, "summary", content.get("tips"));
				addFieldToOwner(resultData, fieldScope, "linkToUrl", content.get("linkToUrl"));
				addFieldToOwner(resultData, fieldScope, "selected", content.get("selected"));
				result.add(resultData);
			}
			return result;
		}
	}

	protected class FormProcessorSerializer implements CustomSerializer {
		@Override
		public Object serialize(SerializeScope serializeScope, Object value, String path) {
			BaseRetailscmFormProcessor form = (BaseRetailscmFormProcessor) value;
			if (form == null) {
				return null;
			}
			return form.mapToUiForm(userContext);
		}
	}
	
	protected class ButtonViewComponentSerializer implements CustomSerializer {
		@Override
		public Object serialize(SerializeScope serializeScope, Object value, String path) {
			ButtonViewComponent btn = (ButtonViewComponent) value;
			SerializeScope fieldScope = SerializeScope.EXCLUDE();
			Map<String, Object> resultData = new HashMap<>();
			addFieldToOwner(resultData, fieldScope, "callbackUrl", btn.getCallbackUrl());
			addFieldToOwner(resultData, fieldScope, "shareRouter", btn.getShareRouter());
			if (btn.getShareTitle() != null) {
				addFieldToOwner(resultData, fieldScope, "title", btn.getShareTitle());
				addFieldToOwner(resultData, fieldScope, "content", btn.getContent());
			}else {
				addFieldToOwner(resultData, fieldScope, "title", btn.getContent());
			}
			addFieldToOwner(resultData, fieldScope, "imageUrl", btn.getImageUrl());
			addFieldToOwner(resultData, fieldScope, "enabled", btn.isActive());
			addFieldToOwner(resultData, fieldScope, "linkToUrl", btn.getLinkToUrl());
			addFieldToOwner(resultData, fieldScope, "code", btn.getTag());
			addFieldToOwner(resultData, fieldScope, "type", btn.getType());
			addFieldToOwner(resultData, fieldScope, "ajax", btn.isAjax());
			return resultData;
		}
	}
	
	protected class PopupViewComponentSerializer implements CustomSerializer {
		@Override
		public Object serialize(SerializeScope serializeScope, Object value, String path) {
			PopupViewComponent popup = (PopupViewComponent) value;
			SerializeScope fieldScope = SerializeScope.EXCLUDE();
			Map<String, Object> resultData = new HashMap<>();
			addFieldToOwner(resultData, fieldScope, "title", popup.getTitle());
			addFieldToOwner(resultData, fieldScope, "text", popup.getText());
			addFieldToOwner(resultData, fieldScope, "closeActionText", popup.getCloseActionText());
			List<ButtonViewComponent> actionList = popup.getActionList();
			if (actionList == null || actionList.isEmpty()) {
				return resultData;
			}
			List<Object> actionsSrst = new ArrayList<>();
			ButtonViewComponentSerializer btnSer = new ButtonViewComponentSerializer();
			for(ButtonViewComponent action: actionList) {
				actionsSrst.add(btnSer.serialize(serializeScope, action, path+action.hashCode()+"/"));
			}
			addFieldToOwner(resultData, fieldScope, "actionList", actionsSrst);
			return resultData;
		}
	}
	
	public Map<String, Object> serializeObject(Object object, SerializeScope serializeScope) {
		Map<String, Object> resultMap = new HashMap<>();
		SerializeScope ssWrapper = SerializeScope.INCLUDE().field("data", serializeScope).noListMeta();
		handleOneData(resultMap, ssWrapper, "/", "data", object);
		addFieldToOwner(resultMap, null, "dataContainer", this.dataContainer);
		if (object instanceof Collection) {
			return resultMap;
		}
		if (object != null && object.getClass().isArray()) {
			return resultMap;
		}
		return (Map<String, Object>) resultMap.get("data");
	}
	
	public static Map<String, Object> serialize(Object object, SerializeScope serializeScope) {
		BaseViewPage tmpPage = new BaseViewPage() {	protected SerializeScope getSerializeScope() { return null;	} };
		return tmpPage.serializeObject(object, serializeScope);
	}
	
	public static Map<String, Object> serializeObjectNow(Object object, SerializeScope serializeScope) {
        return serialize(object, serializeScope);
    }


    public static Map<String, Object> serializeObject(Object object, String... fields) {
        SerializeScope scope = SerializeScope.INCLUDE();

        if (fields != null) {
            for (String field : fields) {
                scope.field(field);
            }
        }
        return serializeObjectNow(object, scope);
    }
    
	protected void forceResponseAsListOfPage() {
		userContext.forceResponseXClassHeader("com.terapico.appview.ListOfPage");
	}
}
















