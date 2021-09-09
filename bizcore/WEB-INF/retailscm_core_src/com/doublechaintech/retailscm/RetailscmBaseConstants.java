package com.doublechaintech.retailscm;

import java.util.*;

public class RetailscmBaseConstants {
	public static final String X_LINK_TO_URL = "linkToUrl";
	public static final String TAB_ALL = "all";
	public static final Map<String, Object> EO = Collections.unmodifiableMap(new HashMap<>());
	public static final int DEFAULT_CACHE_TIME_FOR_STATUS = 60;
	public static final int DEFAULT_CACHE_TIME_FOR_USER = 30*24*60*60; // 用户保留一个月
	public static final int DEFAULT_CACHE_TIME_FOR_VCODE = 10*60; // 校验码保留10分钟
	// public static final String CLASS_FOR_H5_VIEW = "com.terapico.moyi.appview.H5Page";
	public static final String CACHE_KEY_ACCESS_METHOD = "$ACCESS_KEY";
	public static final String CACHE_KEY_ACCESS_PARAMS = "$ACCESS_PARAMS";
	public static final String KEY_RE_SUBMIT = "lck_resubmit";
}
















