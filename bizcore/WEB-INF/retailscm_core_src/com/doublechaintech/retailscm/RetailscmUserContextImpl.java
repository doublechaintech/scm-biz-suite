package com.doublechaintech.retailscm;



import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.MissingResourceException;

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
	
	private RetailscmChecker checker;
	public void setChecker(RetailscmChecker checker) {
		this.checker = checker;
		
	}

	@Override
	public RetailscmChecker getChecker() {
		
		if(this.checker==null) {
			throw new IllegalStateException("每个实例必须配置Checker，请检查相关Spring的XML配置文件中 checker的配置");
		}
		checker.setUserContext(this);
		return checker;
	}
	
}














