package com.doublechaintech.retailscm;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.terapico.caf.form.ImageInfo;
import com.terapico.utils.TextUtil;


public class RetailscmBaseUtils {
	protected static final Map<String, Object> emptyOptions = new HashMap<>();
	protected static final Map<String, Object> EO = new HashMap<>();

	public static String getOssUploadFolderName(String tokenType, String token, boolean isProdEnv) {
		String folderName;
		folderName = String.format("upload%s/%s/%s", isProdEnv ? "" : "/test", tokenType, token);
		return folderName;
	}
	
	public static String hashWithSHA256(String valueToHash, String salt) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			String textToHash = valueToHash+":"+salt;
			byte[] hash = digest.digest(textToHash.getBytes(StandardCharsets.UTF_8));
			StringBuilder stringBuilder = new StringBuilder();
		    for (byte b : hash) {
		        stringBuilder.append(String.format("%02X", b));
		    }
		    return stringBuilder.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException(e);
		}
	}
	
	private static final Pattern ptnChnMobile = Pattern.compile("1[3-9]\\d{9}");
	public static String formatChinaMobile(String mobile) {
		String num = TextUtil.onlyNumber(mobile);
		if (num.startsWith("86") || num.startsWith("086") || num.startsWith("0086")) {
			int pos = num.indexOf("86");
			num = num.substring(pos+2);
		}
		Matcher m = ptnChnMobile.matcher(num);
		if (m.matches()) {
			return num;
		}
		return null;
	}
	public static String checkChinaMobile(String mobile) throws Exception {
		String cleanMobile = formatChinaMobile(mobile);
		if (cleanMobile == null) {
			throw new Exception("您输入的"+mobile+"不是有效的中国大陆手机号");
		}
		return cleanMobile;
	}
	
	public static String getCacheAccessKey(RetailscmUserContext ctx) {
		return ctx.tokenId()+":access_page_without_footprint";
	}
	public static <T> Set<Object> toSet(List<T> list, Function<T, ? extends Object> mapper) {
		return list.stream().map(mapper).collect(Collectors.toSet());
	}
	
	protected static BaseEntity loadCanCacheInLocal(RetailscmUserContext userContext, String type, String id) throws Exception {
		String key = "baseentity:"+type+":"+id;
		BaseEntity result = (BaseEntity) userContext.getFromContextLocalStorage(key);
		if (result != null) {
			return result;
		}
		result = userContext.getDAOGroup().loadBasicData(type, id);
		userContext.putIntoContextLocalStorage(key, result);
		return result;
	}
	
	public static <T extends BaseEntity> List<T> collectReferencedObjectWithType(RetailscmUserContext userContext,
			BaseEntity rootObject, Class<T> clazz) throws Exception {
		List<T> referedObject = new LinkedList<>();
		Set<Object> checkedObject = new HashSet<>();
		collectReferedObjectIdSet(userContext, referedObject, checkedObject, rootObject, clazz, "/");
		return referedObject;
	}

	public static <T extends BaseEntity> List<T> collectReferencedObjectWithType(RetailscmUserContext userContext,
			SmartList<? extends BaseEntity> rootObjectList, Class<T> clazz) throws Exception {
		return collectReferencedObjectWithType(userContext, (List<BaseEntity>) rootObjectList, clazz);
	}

	public static <T extends BaseEntity> List<T> collectReferencedObjectWithType(RetailscmUserContext userContext,
			List<? extends BaseEntity> rootObjectList, Class<T> clazz) throws Exception {
		List<T> referedObject = new LinkedList<>();
		Set<Object> checkedObject = new HashSet<>();
		if (rootObjectList == null || rootObjectList.isEmpty()) {
			return referedObject;
		}
		for (BaseEntity refObj : rootObjectList) {
			collectReferedObjectIdSet(userContext, referedObject, checkedObject, refObj, clazz, "/");
		}
		return referedObject;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static <T extends BaseEntity> void collectReferedObjectIdSet(RetailscmUserContext userContext,
			List<T> referedObject, Set<Object> checkedObject, BaseEntity rootObject, Class<T> clazz, String path)
			throws Exception {
		if (rootObject == null) {
			return;
		}
		if (checkedObject.contains(rootObject)) {
			return;
		}
		checkedObject.add(rootObject);
		String pathKey = rootObject.hashCode() + "/";
		if (path.contains("/" + pathKey)) {
			// System.out.println("skip, since already collected object " + rootObject);
			return;
		}
		path += pathKey;
		if (clazz.isAssignableFrom(rootObject.getClass())) {
			referedObject.add((T) rootObject);
		}
		Field[] fields = rootObject.getClass().getDeclaredFields();
		for (Field field : fields) {
			boolean isStatic = Modifier.isStatic(field.getModifiers());
			if (isStatic) {
				continue;
			}
			field.setAccessible(true);
			Object value = field.get(rootObject);
			if (List.class.isAssignableFrom(field.getType())) {
				field.setAccessible(true);
				List fieldList = (List) value;
				if (fieldList != null && !fieldList.isEmpty()) {
					for (int i = 0; i < fieldList.size(); i++) {
						Object objData = fieldList.get(i);
						if (objData instanceof BaseEntity) {
							collectReferedObjectIdSet(userContext, referedObject, checkedObject, (BaseEntity) objData,
									clazz, path);
						}
					}
				}
				continue;
			}
			if (value instanceof BaseEntity) {
				collectReferedObjectIdSet(userContext, referedObject, checkedObject, (BaseEntity) value, clazz, path);
				continue;
			}
		}
	}
	
	public static String getImageFromArray(List<ImageInfo> imageArray, int idx) {
		if (imageArray == null || imageArray.size() <= idx) {
			return null;
		}
		return imageArray.get(idx).getImageUrl();
	}
	
	public static boolean isDivisible(BigDecimal divisor, BigDecimal dividend) throws Exception {
		if (dividend.signum() == 0) {
			throw new Exception("请不要输入0");
		}
		BigDecimal[] quotient = divisor.divideAndRemainder(dividend);
		if (quotient.length == 1) {
			return true;
		}
		if (quotient[1].signum() == 0) {
			return true;
		}
		return false;
	}
	
	public static int getBuildVersion(String appVersionStr) {
		if (appVersionStr == null || appVersionStr.isEmpty()) {
			return 0;
		}
		int pos = appVersionStr.lastIndexOf(".");
		if (pos < 0) {
			return Integer.parseInt(appVersionStr);
		}
		return Integer.parseInt(appVersionStr.substring(pos+1));
	}
	public static int getAppBuildVersion(RetailscmUserContext ctx) {
		return getBuildVersion(getRequestAppVersion(ctx));
	}
	protected static boolean startFromVersion(RetailscmUserContext ctx, int version) {
		if (!ctx.isProductEnvironment()) {
			return true;
		}
		return getAppBuildVersion(ctx) >= version;
	}
	/*
	 * "x-app-device" : "EML-AL00",
  	 * "x-app-type" : "CommunityUser",
     * "X-Forwarded-For" : "123.121.90.15",
  	 * "X-Real-IP" : "123.121.90.15",
     * "X-Forwarded-Server" : "app.art0x.com",
     * "x-app-version" : "9"
	 */
	public static String getRequestAppVersion(RetailscmUserContext userContext) {
		return userContext.getRequestHeader("x-app-version");
	}
	public static String getRequestAppDevice(RetailscmUserContext userContext) {
		return userContext.getRequestHeader("x-app-device");
	}
	public static String getRequestAppType(RetailscmUserContext userContext) {
		return userContext.getRequestHeader("x-app-type");
	}

}







