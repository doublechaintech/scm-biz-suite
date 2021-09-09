package com.terapico.uccaf;

import com.terapico.caf.baseelement.MemberMetaInfo;

import java.util.List;
import java.util.Map;

public interface CafEntity {
	String getId();
	void setId(String id);
	public Map<String, Object> getValueMap();
	public <T> void  addItemToValueMap(String key, T item);
	public Object  valueByKey(String key);
	int getVersion();
	String getInternalType();
	String viewSuffix();
	default List<MemberMetaInfo> getMemberMetaInfoList(){return null;};
}

