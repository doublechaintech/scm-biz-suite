package com.doublechaintech.retailscm;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.function.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.form.ImageInfo;
import com.terapico.caf.viewcomponent.ButtonViewComponent;
import com.terapico.utils.*;
import com.doublechaintech.retailscm.search.Searcher;
import com.google.gson.Gson;
import com.skynet.infrastructure.ConversionService;
import com.terapico.meta.*;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import com.doublechaintech.retailscm.pagetype.PageType;

import static com.doublechaintech.retailscm.controller.ViewRender.UI_CANDIDATE_ATTRIBUTE_PREFIX;

public class RetailscmBaseUtils {
	protected static final Map<String, Object> emptyOptions = new HashMap<>();
	protected static final Map<String, Object> EO = new HashMap<>();

	public static <T> T ifNull(T input, T defaultVal) {
    return TextUtil.isBlank(input)?defaultVal:input;
  }

  public static <T> T orNull(Callable<T> call) {
    return orElse(call, null);
  }

  public static <T> T orElse(Callable<T> call, T defaultValue) {
    try {
      return call.call();
    } catch (Exception e) {
      return defaultValue;
    }
  }

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

	public static String formatChinaMobile(String mobile) {
		return TextUtil.formatChinaMobile(mobile);
	}

	public static String checkChinaMobile(String mobile) throws Exception {
		String cleanMobile = formatChinaMobile(mobile);
		if (cleanMobile == null) {
			throw new ErrorMessageException("您输入的" + ifNull(mobile, "(无)")
                          + orElse(()->"(长度"+mobile.length()+")", "")
                          + "不是有效的中国大陆手机号");
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

	static Pattern ptnVersionSegment = Pattern.compile("\\d+");
	public static int getBuildVersion(String appVersionStr) {
		if (appVersionStr == null || appVersionStr.isEmpty()) {
			return 0;
		}
		int pos = appVersionStr.lastIndexOf(".");
		if (pos < 0) {
			return Integer.parseInt(appVersionStr);
		}
		//return Integer.parseInt(appVersionStr.substring(pos+1));
		List<String> list = TextUtil.findAllMatched(appVersionStr, ptnVersionSegment);
		return Integer.parseInt(list.get(0));
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
	protected static final NumberFormat cashFormat = new DecimalFormat("#,##0.00");
	protected static final NumberFormat exRateFormat = new DecimalFormat("#,##0.00#");
	public static String formatCash(BigDecimal amount) {
		return cashFormat.format(amount)+"元";
	}
	public static String formatExchangeRate(BigDecimal amount) {
		return exRateFormat.format(amount);
	}


	public static PageType getPageType(RetailscmUserContext userContext, String code) throws Exception {
		String key = "enum:" + PageType.INTERNAL_TYPE + ":" + code;
		PageType data = (PageType) userContext.getFromContextLocalStorage(key);
		if (data != null) {
			return data;
		}
		data = userContext.getDAOGroup().getPageTypeDAO().loadByCode(code, emptyOptions);
		userContext.putIntoContextLocalStorage(key, data);
		return data;
	}

	public static <T> T loadBaseEntityById(RetailscmUserContext ctx, String type, String id) throws Exception {
		return loadBaseEntityById(ctx, type, id, null);
	}
	public static <T> T loadBaseEntityById(RetailscmUserContext ctx, String type, String id, Consumer<T> enhancer) throws Exception {
		String key = type+":"+id;
		BaseEntity cachedValue = (BaseEntity) ctx.getFromContextLocalStorage(key);
		if (cachedValue != null){
			if (cachedValue.getInternalType().equals(type) && cachedValue.getId().equals(id)) {
				return (T) cachedValue;
			}
		}
		T enObj = (T) ctx.getDAOGroup().loadBasicData(type, id);
		if (enhancer != null) {
			enhancer.accept(enObj);
		}
		ctx.putIntoContextLocalStorage(key, enObj);
		return enObj;
	}

	public static <T extends BaseEntity> void appendLinkToUrl(RetailscmUserContext ctx, List<T> list,
			Function<T, String> makeFunc) {
		if (list == null || list.isEmpty()) {
			return;
		}
		list.forEach(it -> {
			it.addItemToValueMap(RetailscmBaseConstants.X_LINK_TO_URL, makeFunc.apply(it));
		});
	}

	public static <T extends BaseEntity> void appendLinkToUrl(RetailscmUserContext ctx, T obj, String url) {
		if (obj == null) {
			return;
		}
		obj.addItemToValueMap(RetailscmBaseConstants.X_LINK_TO_URL, url);
	}

	public static ButtonViewComponent addAction(RetailscmUserContext ctx, BaseEntity obj, String title, String code,
			String linkToUrl) {
		ButtonViewComponent actionBtn = new ButtonViewComponent(title, null, code);
		actionBtn.setLinkToUrl(linkToUrl);
		List<ButtonViewComponent> actions = (List<ButtonViewComponent>) obj.valueByKey("actionList");
		if (actions == null) {
			actions = new ArrayList<>();
			obj.addItemToValueMap("actionList", actions);
		}
		actions.add(actionBtn);
		return actionBtn;
	}

	public static void setAction(RetailscmUserContext ctx, BaseEntity obj, String title, String code, String linkToUrl) {
		ButtonViewComponent actionBtn = new ButtonViewComponent(title, null, code);
		actionBtn.setLinkToUrl(linkToUrl);
		obj.addItemToValueMap("action", actionBtn);
	}

    public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result,
  				   String tableName, String[][] fieldInfo, String title, String[] indexSqls, String[] constraintSqls) throws Exception{
  		// throw new Exception("RetailscmBaseUtils::ensureTable()尚未实现");

        DBQuerier querier = (DBQuerier) userContext.getBean("dbQuerier");
        Map<String, Object> checkResult = DBChecker.verifyTable("retailscm",tableName, title, fieldInfo, indexSqls, constraintSqls, querier);

        boolean success = DataTypeUtil.getBoolean(checkResult.get("result"), null); // if null, it's bug
        List<String> report = (List<String>) result.get("ensureTableReport");
        if (report == null) {
            report = new ArrayList<>();
            result.put("ensureTableReport", report);
        }
        report.add("\r\n");
        if (success) {
            report.add("## " + tableName + " is ready");
        } else {
            report.add("## " + tableName + " is different with current model");
            report.add("## " + (String) checkResult.get("message"));
            report.add("## use below sql to update");
            report.add((String) checkResult.get("sql"));
        }
    }

    public static void ensureDataByCode(RetailscmUserContext userContext, Map<String, Object> result,
  					String tableName, String[][] rowData) throws Exception{
        // throw new Exception("RetailscmBaseUtils::ensureDataByCode()尚未实现");
        DBQuerier querier = (DBQuerier) userContext.getBean("dbQuerier");
        Map<String, Object> checkResult = DBChecker.verifyData(tableName, rowData, querier);
        List<String> report = (List<String>) result.get("ensureDataReport");
        if (report == null) {
            report = new ArrayList<>();
            result.put("ensureDataReport", report);
        }
        report.add("\r\n");
        boolean success = DataTypeUtil.getBoolean(checkResult.get("result"), null); // if null, it's bug
        if (success){
            report.add("## " + tableName + " data is ready");
        }else{
            report.add("## " + tableName + " data is different with current model");
            report.add("## use below sql to update");
            report.add((String) checkResult.get("sql"));
        }
    }

     public static BaseEntity queryItem(UserContext ctx, BaseRequest request, Class... types)
          throws Exception {
        List<BaseEntity> baseEntities = queryItems(ctx, request, types);
        if (baseEntities != null && !baseEntities.isEmpty()) {
          return baseEntities.get(0);
        }
        return null;
      }

      public static List<BaseEntity> queryItems(UserContext ctx, BaseRequest request, Class... types)
          throws Exception {
        Set<Class> typeList = new LinkedHashSet<>();
        if (types == null || types.length == 0) {
          typeList.addAll(guessTypes(request.getInternalType()));
        } else {
          for (Class type : types) {
            typeList.add(type);
          }
        }

        Map<Class, BaseRequest> typeRequests = new HashMap<>();
        typeRequests.put(internalTypeToClass(request.getInternalType()), request);
        for (Class type : typeList) {
          enhanceSubSearchForRequest(typeRequests, type);
        }
        List<BaseEntity> items = Searcher.search(ctx, request);
        return getRealItem(new ArrayList<>(items), types);
      }

      public static <T extends BaseEntity> T getType(BaseEntity entity, Class<T> type) {
        if (entity == null) {
          return null;
        }
        Class<? extends BaseEntity> aClass = entity.getClass();
        if (type.isAssignableFrom(aClass)) {
          return (T) entity;
        }

        PropertyMeta parentLinkProperty = getParentLinkProperty(aClass);
        if (parentLinkProperty == null) {
          throw new RuntimeException("类型转化失败");
        }

        return getType((BaseEntity) entity.propertyOf((String) parentLinkProperty.get("name")), type);
      }

      /**
       * entity的common view，尝试展开entity的所有属性，如果引用的是对象，则 通用的展开为id, displayName
       *
       * @param entity
       * @return
       */
      public static Map<String, Object> itemView(BaseEntity entity) {
        if (entity == null) {
          return Collections.emptyMap();
        }
        Map<String, Object> view = new HashMap<>();
        PropertyMeta parentLinkProperty = getParentLinkProperty(entity.getClass());
        if (parentLinkProperty != null) {
          // parent 只能是baseEntity
          BaseEntity parent = (BaseEntity) entity.propertyOf((String) parentLinkProperty.get("name"));
          Map<String, Object> parentView = itemView(parent);
          view.putAll(parentView);
        }
        String[] propertyNames = entity.getPropertyNames();
        for (String propertyName : propertyNames) {
          Object o = entity.propertyOf(propertyName);
          if (o instanceof BaseEntity) {
            view.put(
                propertyName,
                MapUtil.builder()
                    .put("id", ((BaseEntity) o).getId())
                    .put("displayName", ((BaseEntity) o).getDisplayName())
                    .build());
          }
          view.put(propertyName, o);
        }
        return view;
      }

      public static <T extends BaseEntity> T buildItem(CustomRetailscmUserContextImpl ctx, Class<T> type) {
          Gson gson = new Gson();
          String[] requestParameters = (String[]) ctx.getRequestParameters().get("formData");
          Map map = gson.fromJson(requestParameters[0], Map.class);
          return buildItem(ctx, (Map<String, Object>) map, type);
        }

      public static <T extends BaseEntity> T buildItem(
          CustomRetailscmUserContextImpl ctx, Map<String, Object> data, Class<T> type) {
        try {
          T t = type.newInstance();
          String[] propertyNames = t.getPropertyNames();
          for (String propertyName : propertyNames) {
            if (!data.containsKey(propertyName)) {
              continue;
            }
            Object propertyValue = data.get(propertyName);
            updatePropertyValue(ctx, data, t, propertyName, propertyValue);
          }

          PropertyMeta parentLinkProperty = getParentLinkProperty(type);
          if (parentLinkProperty != null) {
            String parentProperty = (String) parentLinkProperty.get("name");
            BaseEntity parent = (BaseEntity) t.propertyOf(parentProperty);
            if (parent == null) {
              Method updateMethod =
                  ReflectUtil.getMethodByName(type, "update" + StrUtil.upperFirst(parentProperty));
              updateMethod.invoke(t, buildItem(ctx, data, getParentClasses(type).get(0)));
            }
          }
          return t;
        } catch (Exception e) {
          e.printStackTrace();
        }
        return null;
      }

      private static <T extends BaseEntity> void updatePropertyValue(
          CustomRetailscmUserContextImpl ctx,
          Map<String, Object> data,
          T t,
          String propertyName,
          Object propertyValue)
          throws Exception {
        Method updateMethod =
            ReflectUtil.getMethodByName(t.getClass(), "update" + StrUtil.upperFirst(propertyName));
        Class<?> parameterType = updateMethod.getParameterTypes()[0];

        if (BaseEntity.class.isAssignableFrom(parameterType)) {
          propertyValue = convertToType(ctx, t.getClass(), parameterType, propertyName, propertyValue);
          updateMethod.invoke(t, propertyValue);
        } else {
          updateMethod.invoke(t, getConversionService().convert(propertyValue, parameterType));
        }
      }

      private static ConversionService getConversionService() {
        return new ConversionService();
      }

      private static Object convertToType(
          CustomRetailscmUserContextImpl ctx,
          Class<? extends BaseEntity> ownerType,
          Class<?> referType,
          String propertyName,
          Object propertyValue)
          throws Exception {
        if (propertyValue == null) {
          return null;
        }
        String value = String.valueOf(propertyValue);

        String valueProp =
            MetaProvider.entity(ownerType)
                .property(propertyName)
                .getStr(UI_CANDIDATE_ATTRIBUTE_PREFIX + "id", "id");

        // 值 是id时，使用with id
        Method withId = ReflectUtil.getMethod(referType, "withId", String.class);
        if ("id".equals(valueProp)) {
          return ReflectUtil.invokeStatic(withId, value);
        } else if ("name".equals(valueProp)) {
          // 常量时可以不查询数据库
          if (MetaProvider.entity(referType).isConstant()) {
            Method getCode = ReflectUtil.getMethod(referType, "getCode", String.class);
            String code = ReflectUtil.invokeStatic(getCode, value);
            return ReflectUtil.invokeStatic(withId, code);
          }
        }
        BaseEntity o = (BaseEntity) ReflectUtil.newInstance(referType);
        ReflectUtil.invoke(o, "setPropertyOf", valueProp, value);
        BaseEntity dbItem = reload(ctx, o);
        if (dbItem == null) {
          return o;
        }
        return dbItem;
      }

      private static void enhanceSubSearchForRequest(
          Map<Class, BaseRequest> pTypeRequests, Class pSubType) {
        if (pTypeRequests.containsKey(pSubType)) {
          return;
        }
        List<Class> parentClasses = getParentClasses(pSubType);
        if (!parentClasses.isEmpty()) {
          enhanceSubSearchForRequest(pTypeRequests, parentClasses.get(0));
        }
        BaseRequest baseRequest = pTypeRequests.get(parentClasses.get(0));
        PropertyMeta parentLinkProperty = getParentLinkProperty(pSubType);
        String linkPropertyName = (String) parentLinkProperty.get("name");
        BaseRequest subRequest = createSubRequest(pSubType);
        pTypeRequests.put(pSubType, subRequest);
        baseRequest.selectChild(linkPropertyName, subRequest);
      }

      private static BaseRequest createSimpleRequest(Class type) {
        String aPackage = ClassUtil.getPackage(type);
        Class<? extends BaseRequest> requestClass =
            ClassUtil.loadClass(aPackage + "." + type.getSimpleName() + "Request");
        Method newInstance = ClassUtil.getDeclaredMethod(requestClass, "newInstance");
        BaseRequest request = ReflectUtil.invokeStatic(newInstance);
        Method selectAll = ClassUtil.getDeclaredMethod(requestClass, "selectAll");
        ReflectUtil.invoke(request, selectAll);
        return request;
      }

      private static BaseRequest createSubRequest(Class pSubType) {
        BaseRequest simpleRequest = createSimpleRequest(pSubType);
        Method unselectParent =
            ClassUtil.getDeclaredMethod(simpleRequest.getClass(), "unselectParent", String.class);
        ReflectUtil.invoke(simpleRequest, unselectParent, getParentLinkProperty(pSubType).get("name"));
        return simpleRequest;
      }

      private static List<Class> guessTypes(String pInternalType) {
        Class internalClass = internalTypeToClass(pInternalType);
        return getSubClasses(internalClass);
      }

      private static List<BaseEntity> getRealItem(List<BaseEntity> topItems, Class... types)
          throws Exception {
        if (topItems == null) {
          return Collections.emptyList();
        }
        List<BaseEntity> allAssets = new ArrayList<>();

        for (BaseEntity topItem : topItems) {
          BaseEntity realAsset = getRealItem(topItem, types);
          allAssets.add(realAsset);
        }
        return allAssets;
      }

      private static BaseEntity getRealItem(BaseEntity pAsset, Class... types) throws Exception {
        if (types == null) {
          return pAsset;
        }
        for (Class c : types) {
          BaseEntity asset = getItem(pAsset, c);
          if (asset != null) {
            return asset;
          }
        }
        return pAsset;
      }

      public static <T extends BaseEntity> T getItem(BaseEntity pAsset, Class<T> pClass)
          throws Exception {
        List<T> assets = collectReferencedObjectWithType(null, pAsset, pClass);
        if (!assets.isEmpty()) {
          return assets.get(0);
        }
        return null;
      }

      private static Class internalTypeToClass(String internalType) {
        internalType =
            StrUtil.sub(internalType, internalType.lastIndexOf('.') + 1, internalType.length());
        String internalClass =
            ClassUtil.getPackage(BaseEntity.class)
                + "."
                + internalType.toLowerCase()
                + "."
                + internalType;
        return ClassUtil.loadClass(internalClass);
      }

      private static List<Class> getSubClasses(Class clazz) {
        List childrenTypes = (List) MetaProvider.entity(clazz).get("childrenTypes");
        if (childrenTypes == null || childrenTypes.isEmpty()) {
          return Collections.emptyList();
        }
        List<Class> rets = new ArrayList<>();
        for (Object childrenType : childrenTypes) {
          Class sub = internalTypeToClass((String) childrenType);
          List<Class> subOfSub = getSubClasses(sub);
          rets.addAll(subOfSub);
          rets.add(sub);
        }
        return rets;
      }

      public static List<Class> getParentClasses(Class clazz) {
        PropertyMeta parentLinkProperty = getParentLinkProperty(clazz);
        if (parentLinkProperty == null) {
          return Collections.emptyList();
        }
        List<Class> parents = new ArrayList<>();
        String parentType = (String) parentLinkProperty.get("parentType");
        Class aClass = internalTypeToClass(parentType);
        parents.add(aClass);
        parents.addAll(getParentClasses(aClass));
        return parents;
      }

      private static PropertyMeta getParentLinkProperty(Class clazz) {
        EntityMeta entity = MetaProvider.entity(clazz);
        Map<String, PropertyMeta> properties = entity.getProperties();
        for (PropertyMeta property : properties.values()) {
          if (Boolean.valueOf((String) property.get("parentLink"))) {
            return property;
          }
        }
        return null;
      }

      public static <T extends BaseEntity> T ensure(RetailscmUserContext ctx, T item, Consumer<T> enhancer)
          throws Exception {
        if (item == null) {
          return null;
        }
        T dbItem = reload(ctx, item);
        if (dbItem == null) {
          if(enhancer != null) {
            enhancer.accept(item);
          }
          return saveItem(ctx, item);
        }
        return dbItem;
      }

      public static <T extends BaseEntity> T saveItem(RetailscmUserContext ctx, T pItem) {
        if (pItem == null) {
          return null;
        }
        Object bean = Beans.getBean(StrUtil.lowerFirst(pItem.getInternalType()) + "Manager");
        ReflectUtil.invoke(bean, "internalSave" + pItem.getInternalType(), ctx, pItem);
        return null;
      }

      // 只处理string或引用类型的相等
      public static <T extends BaseEntity> T reload(RetailscmUserContext ctx, T pItem) throws Exception {
          BaseRequest request = createReloadRequest(pItem);
          return (T) Searcher.searchOne(ctx, request);
      }

      private static <T extends BaseEntity> BaseRequest createReloadRequest(T pItem) {
        BaseRequest request = createSimpleRequest(pItem.getClass());
        String[] propertyNames = pItem.getPropertyNames();
        for (String propertyName : propertyNames) {
          Object propertyValue = pItem.propertyOf(propertyName);
          if (propertyValue == null) {
            continue;
          }
          // 处理string
          if (propertyValue instanceof String) {
            ReflectUtil.invoke(
                request, "where", propertyName, QueryOperator.EQUAL, new Object[] {propertyValue});
          }

          // 处理引用
          if (propertyValue instanceof BaseEntity) {
            ReflectUtil.invoke(
                request,
                "filterBy" + StrUtil.upperFirst(propertyName),
                createReloadRequest((BaseEntity) propertyValue));
          }
        }
        return request;
      }

     public static Map<String, Object> collectSubInfo(BaseEntity entity) {
        if (entity == null) {
          return Collections.emptyMap();
        }
        List<SmartList<?>> allRelatedLists = entity.getAllRelatedLists();
        Map<String, Object> ret = new HashMap<>();
        allRelatedLists.stream().flatMap(l -> l.stream()).forEach(e -> ret.putAll(itemView(e)));
        return ret;
      }
}
















