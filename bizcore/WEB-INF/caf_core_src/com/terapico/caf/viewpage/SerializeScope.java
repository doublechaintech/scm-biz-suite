package com.terapico.caf.viewpage;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

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
		if (NODE_OBJECT == this.nodeType) {
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

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	
	public SerializeScope forceList() {
		if (curNode == null) {
			throw new RuntimeException("method 'forceList(String)' must be invoked only after method 'field(xxx)'");
		}
		curNode.setForceWhenEmpty("list");
		return this;
	}
	public SerializeScope forceObject() {
		if (curNode == null) {
			throw new RuntimeException("method 'forceObject(String)' must be invoked only after method 'field(xxx)'");
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
			throw new RuntimeException("method 'noListMeta(String)' must be invoked only after method 'field(xxx)'");
		}
		curNode.setNoListMeta(true);
		return this;
	}

	public boolean isNoListMeta() {
		return noListMeta;
	}

	public void setNoListMeta(boolean noListMeta) {
		this.noListMeta = noListMeta;
	}
	
}
