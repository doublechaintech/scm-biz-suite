package com.terapico.caf.viewpage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.terapico.utils.TextUtil;

@JsonIgnoreType
public class SerializeScope {
	public static final int NODE_SIMPLE = 0;
	public static final int NODE_OBJECT = 1;
	
	protected Map<String, SerializeScope> fields;
	protected boolean excludeMode = false;
	protected int nodeType;
	protected String fieldName;
	protected String aliasName;
	protected String forceWhenEmpty;
	protected boolean noListMeta = false;
	protected boolean revers = false;
	protected boolean showWhenNotEmpty = false;
	protected boolean putInDataContainer = false;
	
	
	public boolean isPutInDataContainer() {
		return putInDataContainer;
	}

	public void setPutInDataContainer(boolean putInDataContainer) {
		this.putInDataContainer = putInDataContainer;
	}

	public boolean isShowWhenNotEmpty() {
		return showWhenNotEmpty;
	}

	public void setShowWhenNotEmpty(boolean showWhenNotEmpty) {
		this.showWhenNotEmpty = showWhenNotEmpty;
	}

	public boolean isRevers() {
		return revers;
	}

	public void setRevers(boolean revers) {
		this.revers = revers;
	}

	protected SerializeScope curNode = null;
	
	private SerializeScope() {
		this(false);
	}
	
	private SerializeScope(boolean inExcludeMode) {
		super();
		excludeMode = inExcludeMode;
	}

	private void ensureFields() {
		if (fields != null) {
			return;
		}
		fields = new HashMap<>();
	}
	private SerializeScope findNodeByName(String fieldName) {
		if (fields == null) {
			return null;
		}
		return fields.get(fieldName);
	}
	
	public static SerializeScope INCLUDE() {
		return new SerializeScope(false);
	}
	public static SerializeScope EXCLUDE() {
		return new SerializeScope(true);
	}
	public SerializeScope field(String fieldName) {
		ensureFields();
		SerializeScope node = new SerializeScope();
		node.nodeType = NODE_SIMPLE;
		node.excludeMode = this.excludeMode;
		fields.put(fieldName, node);
		curNode = node;
		return this;
	}
	public SerializeScope field(String fieldName, SerializeScope node) {
		ensureFields();
		node.nodeType = NODE_OBJECT;
		fields.put(fieldName, node);
		curNode = node;
		return this;
	}

	public boolean visible(String fieldName) {
		SerializeScope node = findNodeByName(fieldName);
		if (node == null) {
			return excludeMode?true:false;
		}
		if (NODE_OBJECT == node.nodeType) {
			return true;
		}
		return excludeMode?false:true;
	}
	public SerializeScope getFieldScope(String key) {
		SerializeScope node = findNodeByName(key);
		if (node != null) {
			return node;
		}
		if (excludeMode) {
			// 如果当前是 除xxx以外 的模式，而当前字段未定义，说明是要输出这个字段对应对象的所有字段
			// 所以返回一个字段列表为空，模式为 除xxx以外 的，表示没有字段被排除
			return new SerializeScope(true);
		}
		// 如果当前是 输出指定字段 的模式，而当前未定义该字段的数据，那么表示我没想输出
		// 所以返回一个 指定字段为空 的，表示没有字段要输出
		return new SerializeScope();
	}

	public SerializeScope as(String alias) {
		if (curNode == null) {
			throw new RuntimeException("method 'as(String)' must be invoked only after method 'field(xxx)'");
		}
		curNode.setAliasName(alias);
		return this;
	}
	public SerializeScope not_empty() {
		if (curNode == null) {
			throw new RuntimeException("method 'not_zero()' must be invoked only after method 'field(xxx)'");
		}
		curNode.setShowWhenNotEmpty(true);
		return this;
	}
	
	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	
	public SerializeScope forceList() {
		if (curNode == null) {
			throw new RuntimeException("method 'forceList()' must be invoked only after method 'field(xxx)'");
		}
		curNode.setForceWhenEmpty("list");
		return this;
	}
	public SerializeScope forceObject() {
		if (curNode == null) {
			throw new RuntimeException("method 'forceObject()' must be invoked only after method 'field(xxx)'");
		}
		curNode.setForceWhenEmpty("object");
		return this;
	}

	public String getForceWhenEmpty() {
		return forceWhenEmpty;
	}

	public void setForceWhenEmpty(String forceWhenEmpty) {
		this.forceWhenEmpty = forceWhenEmpty;
	}

	public SerializeScope noListMeta() {
		if (curNode == null) {
			throw new RuntimeException("method 'noListMeta()' must be invoked only after method 'field(xxx)'");
		}
		curNode.setNoListMeta(true);
		return this;
	}
	public SerializeScope in_data_container() {
		if (curNode == null) {
			throw new RuntimeException("method 'in_data_container()' must be invoked only after method 'field(xxx)'");
		}
		curNode.setPutInDataContainer(true);
		return this;
	}
	
	public SerializeScope revers() {
		if (curNode == null) {
			throw new RuntimeException("method 'revers()' must be invoked only after method 'field(xxx)'");
		}
		curNode.setRevers(true);
		return this;
	}
	public boolean isNoListMeta() {
		return noListMeta;
	}

	public void setNoListMeta(boolean noListMeta) {
		this.noListMeta = noListMeta;
	}
	
	public SerializeScope clone() {
		SerializeScope newScope = new SerializeScope();
		newScope.setAliasName(this.getAliasName());
		newScope.setForceWhenEmpty(this.getForceWhenEmpty());
		newScope.setNoListMeta(this.noListMeta);
		newScope.setPutInDataContainer(this.putInDataContainer);
		newScope.setRevers(this.isRevers());
		newScope.setShowWhenNotEmpty(this.showWhenNotEmpty);
		newScope.nodeType = this.nodeType;
		newScope.fieldName = this.fieldName;
		newScope.excludeMode = this.excludeMode;
		if (this.fields != null) {
			Map<String, SerializeScope> newFields = new HashMap<>();
			this.fields.forEach((key, node)->{
				newFields.put(key, node.clone());
			});
			newScope.fields = newFields;
		}
		return newScope;
	}

	public Map<String, Object> showScope() {
		Map<String, Object> result = new HashMap<>();
		if (this.fields != null) {
			Iterator<Entry<String, SerializeScope>> it = fields.entrySet().iterator();
			while(it.hasNext()) {
				Entry<String, SerializeScope> ent = it.next();
				String key =ent.getKey();
				String fName = key;
				SerializeScope node = ent.getValue();
				if (node.getAliasName() != null) {
					fName = node.getAliasName();
				}
				Map<String, Object> subScope = node.showScope();
				if (subScope != null && subScope.size() > 0) {
					result.put(fName, subScope);
				}else {
					result.put(fName, !node.excludeMode);
				}
//				System.out.println(result);
			}
		}
		
		return result;
	}
	
	@Override
	public String toString() {
		return "SerializeScope [fields=" + fields + ", excludeMode=" + excludeMode + ", nodeType=" + nodeType
				+ ", fieldName=" + fieldName + ", aliasName=" + aliasName + ", forceWhenEmpty=" + forceWhenEmpty
				+ ", noListMeta=" + noListMeta + ", revers=" + revers + ", showWhenNotEmpty=" + showWhenNotEmpty
				+ ", putInDataContainer=" + putInDataContainer + ", curNode=" + curNode + "]";
	}

	public SerializeScope remove_field(String propertyName) {
		if (this.fields == null) {
			return this;
		}
		this.fields.remove(propertyName);
		return this;
	}
	public SerializeScope for_field(String propertyName) {
		if (this.fields == null) {
			return null;
		}
		curNode = fields.get(propertyName);
		return this;
	}
	
}
