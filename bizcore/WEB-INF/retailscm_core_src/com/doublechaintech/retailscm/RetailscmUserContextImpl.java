package com.doublechaintech.retailscm;



import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.MissingResourceException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.secuser.SecUserCustomManagerImpl;
import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.userapp.UserAppTokens;
import com.terapico.utils.CollectionUtils;

public class RetailscmUserContextImpl extends UserContextImpl implements RetailscmUserContext{
    //implements the domain specific user model

	//默认支持中文和英文
	protected static Map<String,String> chineseMap;

	protected static Map<String,String> englishMap;

	protected double longitude;
	protected double latitude;


	static final String RESOURCE_PATH="com.doublechaintech.retailscm.RetailscmResources";
	static final String CUSTOM_RESOURCE_PATH="com.doublechaintech.retailscm.RetailscmCustomResources";

	public Map<String,String> ensureLocaleMaps(Locale locale ){

		String [] resources = {RESOURCE_PATH, CUSTOM_RESOURCE_PATH};
		return ensureResourceAddResourceMaps(resources, locale);

	}

	protected Map<String,String> ensureResourceAddResourceMaps(String[] paths, Locale locale){
		Map<String,String> localeMap= new HashMap<String,String>();
		for(String path: paths){
			try{
				ResourceBundle resourceBundle = ResourceBundle.getBundle(path,locale);
				addResourceToMap(localeMap, resourceBundle);
			}catch(MissingResourceException e){
				//the resource can be missed and it is fine
			}

		}
		return localeMap;
	}

	protected void addResourceToMap(Map<String,String> localeMap, ResourceBundle resourceBundle){
		Enumeration<String> bundleKeys = resourceBundle.getKeys();

		while (bundleKeys.hasMoreElements()) {
		    String key = (String)bundleKeys.nextElement();
		    String value = resourceBundle.getString(key);
		    //System.out.println("key = " + key + ", " + "value = " + value);
		    localeMap.put(key, value);
		}


	}
	public void init(){
		if(chineseMap==null){
			chineseMap = ensureLocaleMaps(Locale.SIMPLIFIED_CHINESE);
		}
		if(englishMap==null){
			englishMap = ensureLocaleMaps(Locale.US);
		}


	}
	public Map<String,String> getLocaleMap(){

		init();

		return chineseMap;


	}

	protected Locale getLocale(){
		return Locale.US;
	}
	public String getLocaleKey(String subject) {
		return getLocaleMap().get(subject);
	}

	public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    /*
    public static SecUser getSecUser(RetailscmUserContext userContext) {
		SecUserCustomManagerImpl secUserManager = (SecUserCustomManagerImpl) userContext.getManagerGroup()
				.getSecUserManager();
		SecUser secUser = secUserManager.getCachedSecUser(userContext);
		return secUser;
	}

	public static UserApp getSingleUserAppByObjectName(RetailscmUserContext userContext, String objectName)
			throws Exception {
		SecUserCustomManagerImpl secUserManager = (SecUserCustomManagerImpl) userContext.getManagerGroup()
				.getSecUserManager();
		SecUser secUser = secUserManager.getCachedSecUser(userContext);
		if (secUser == null) {
			return null;
		}
		SmartList<UserApp> appList = getUserAppByName(userContext, secUser, objectName);
		if (appList == null) {
			return null;
		}
		if (appList.size() == 1) {
			return appList.get(0);
		}
		String appId = secUserManager.getCurrentAppKey(userContext);
		for (UserApp app : appList) {
			if (app.getId().equals(appId)) {
				return app;
			}
		}
		return null;
	}
	*/
	public static SmartList<UserApp> getUserAppByName(RetailscmUserContext userContext, SecUser secUser, String objectName) {
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserApp.SEC_USER_PROPERTY, secUser.getId());
		key.put(UserApp.OBJECT_TYPE_PROPERTY, objectName);
		SmartList<UserApp> appList = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key,
				UserAppTokens.all());
		filterInvalidApps(appList);
		if (CollectionUtils.isEmpty(appList)) {
			return null;
		}
		return appList;
	}

	private static void filterInvalidApps(SmartList<UserApp> appList) {
		if (CollectionUtils.isEmpty(appList)) {
			return;
		}
		Iterator<UserApp> it = appList.iterator();
		while (it.hasNext()) {
			UserApp app = it.next();
			if (app.getSecUser() == null) {
				it.remove();
				continue;
			}
		}
	}

	public static UserApp getUserAppByBindedEntity(RetailscmUserContext userContext, BaseEntity userAppBindedObject) {
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserApp.OBJECT_TYPE_PROPERTY, userAppBindedObject.getInternalType());
		key.put(UserApp.OBJECT_ID_PROPERTY, userAppBindedObject.getId());
		SmartList<UserApp> apps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key,
				UserAppTokens.all());
		if (apps == null) {
			return null;
		}
		Iterator<UserApp> it = apps.iterator();
		while (it.hasNext()) {
			// 过滤掉无效的app
			UserApp app = it.next();
			if (app.getSecUser() == null) {
				it.remove();
				continue;
			}
		}
		if (apps.isEmpty()) {
			return null;
		}
		return apps.get(0);
	}

	private RetailscmObjectChecker checker;
	public void setChecker(RetailscmObjectChecker checker) {
		this.checker = checker;

	}

	@Override
	public RetailscmObjectChecker getChecker() {

		if(this.checker==null) {
			throw new IllegalStateException("每个实例必须配置Checker，请检查相关Spring的XML配置文件中 checker的配置");
		}
		checker.setUserContext(this);
		return checker;
	}

	protected static final String ACCESS_PARAMETERS_KEY = "$access_parameters";
	protected static final String ACCESS_METHOD_NAME_KEY = "$access_method_name";
	protected static final String ACCESS_BEAN_NAME_KEY = "$access_bean_name";

	public void saveAccessInfo(String beanName, String methodName, Object[] parameters) {
		putIntoContextLocalStorage(ACCESS_BEAN_NAME_KEY, beanName);
		putIntoContextLocalStorage(ACCESS_METHOD_NAME_KEY, methodName);
		putIntoContextLocalStorage(ACCESS_PARAMETERS_KEY, parameters);
		putToCache(getFootprintMarkKey(), true, 1*60*60);
	}

	protected String getFootprintMarkKey() {
		return tokenId()+":$acces_page_without_foorprint";
	}

	public void addFootprint(FootprintProducer helper) throws Exception {
		String beanName = (String) this.getFromContextLocalStorage(ACCESS_BEAN_NAME_KEY);
		String methodName =  (String) this.getFromContextLocalStorage(ACCESS_METHOD_NAME_KEY);
		Object[] parameters =  (Object[]) this.getFromContextLocalStorage(ACCESS_PARAMETERS_KEY);
		if (beanName == null) {
			throw new Exception("Please make sure you had invoke user-context saveAccessInfo() inside your onAccess().");
		}
		if (!beanName.equals(helper.getBeanName())) {
			throw new Exception("This request was from " + beanName+", not from " + helper.getBeanName()+".");
		}
		if (methodName == null) {
			return;// 没保存过，就不用处理了。
		}
		this.removeFromCache(getFootprintMarkKey());
		// 核心问题是怎么处理堆栈。 是持续累加，还是‘短路’算法（clear_top)，或者‘提升’（brought—to-front）
		Footprint fp = new Footprint();
		fp.setBeanName(helper.getBeanName());
		fp.setMethodName(methodName);
		fp.setParameters(parameters);
		// 先从缓存中拿到历史记录
		List<Footprint> history = getFootprintListFromCache();
		if (history == null || history.isEmpty()) {
			// 历史是空的，直接追加
			history = new ArrayList<>();
			history.add(fp);
			this.log("add footprint " + beanName+"."+methodName+"("+Arrays.asList(fp.getParameters())+")");
			putFootprintIntoCache(history);
			return;
		}

		Footprint replacedFp = null;
		for(Footprint item : history) {
			if (helper.canReplaceFootPrint(fp, item)) {
				replacedFp = item;
				break;
			}
		}

		if (replacedFp == null) {
			// 没找到可替换的目标，追加到队列最后
			history.add(fp);
			this.log("add new footprint " + beanName+"."+methodName+"("+Arrays.asList(fp.getParameters())+")");
			putFootprintIntoCache(history);
			return;
		}

		// 找到可替换的目标以后，还要决定怎么做
		if (helper.clearTop()) {
			Iterator<Footprint> it = history.iterator();
			boolean found = false;
			while(it.hasNext()) {
				Footprint item = it.next();
				if (item == replacedFp) {
					found = true;
				}
				if (found) {
					it.remove();
				}
			}
		}else {
			int idx = history.indexOf(replacedFp);
			history.remove(idx);
		}
		history.add(fp);
		this.log("replace footprint " + beanName+"."+methodName+"("+Arrays.asList(fp.getParameters())+")");
		putFootprintIntoCache(history);
	}

	public int getFootprintDeepth() throws Exception {
		List<Footprint> history = getFootprintListFromCache();
		if (history == null || history.isEmpty()) {
			return 0;
		}
		return history.size();
	}
	protected void putFootprintIntoCache(List<Footprint> history) throws Exception {
		String historyJson = new ObjectMapper().writeValueAsString(history);
		this.putToCache(getFootprintKey(), historyJson, 1*60*60); // 1个小时
	}

	protected List<Footprint> getFootprintListFromCache() throws Exception {
		String historyJson = (String) this.getCachedObject(getFootprintKey(), String.class);
		if (historyJson == null || historyJson.isEmpty()) {
			return null;
		}
		return new ObjectMapper().readValue(historyJson, new TypeReference<List<Footprint>>() {
		});
	}

	protected String getFootprintKey() {
		return this.tokenId+":footprint";
	}

	public Object getLastViewPage() throws Exception {
		List<Footprint> history = getFootprintListFromCache();
		if (history == null || history.isEmpty()) {
			return null;
		}

		Footprint fp = history.remove(history.size()-1);
		putFootprintIntoCache(history);

		Object service = this.getBean(fp.getBeanName());
		fp.getParameters()[0] = this;
		Method[] methods = service.getClass().getMethods();
		for(Method m: methods) {
			if (m.getName().equals(fp.getMethodName()) && m.getParameterTypes().length == fp.getParameters().length) {
				return m.invoke(service, fp.getParameters());
			}
		}
		return null;
	}

	public Object getPreviousViewPage() throws Exception {
		List<Footprint> history = getFootprintListFromCache();
		if (history == null || history.isEmpty()) {
			return null;
		}

		Footprint fp = history.remove(history.size()-1);
		if (history.isEmpty()) {
			putFootprintIntoCache(history);
			return null;
		}
		fp = history.remove(history.size()-1);
		putFootprintIntoCache(history);

		Object service = this.getBean(fp.getBeanName());
		fp.getParameters()[0] = this;
		Method[] methods = service.getClass().getMethods();
		for(Method m: methods) {
			if (m.getName().equals(fp.getMethodName()) && m.getParameterTypes().length == fp.getParameters().length) {
				return m.invoke(service, fp.getParameters());
			}
		}
		return null;
	}

	public Object goback() throws Exception {
		Object mark = getCachedObject(getFootprintMarkKey(), Boolean.class);
		if (mark instanceof Boolean && ((Boolean) mark).booleanValue()) {
			// 没压栈
			return getLastViewPage();
		}
		return getPreviousViewPage();
	}

}

