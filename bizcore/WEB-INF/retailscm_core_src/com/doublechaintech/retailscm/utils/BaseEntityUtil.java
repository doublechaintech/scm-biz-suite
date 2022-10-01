package com.doublechaintech.retailscm.utils;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.*;
import cn.hutool.log.StaticLog;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.CustomRetailscmUserContextImpl;
import com.doublechaintech.retailscm.ErrorMessageException;
import com.doublechaintech.retailscm.search.BaseRequest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** 基于parentLink的继承结构的工具 */
public class BaseEntityUtil {

  public static BaseEntity createEntity(
      Class<? extends BaseEntity> targetType, Map<String, Object> props) {
    BaseEntity entity = createEntity(targetType);
    props.forEach(
        (k, v) -> {
          setFieldValue(entity, k, v);
        });
    return entity;
  }

  public boolean checkIfEligibleForDelete(Object ctx, BaseEntity entity) {
    if (entity == null) {
      return false;
    }

    if (entity.getId() == null) {
      return false;
    }

    BaseRequest reloadRequest = RetailscmBaseUtils.createReloadRequest(entity);
    RetailscmBaseUtils.enhanceRequest(reloadRequest);

    BaseEntity dbItem = reloadRequest.execute(ctx);

    List<Class> possibleTypes = getTypes(entity.getClass());
    for (Class possibleType : possibleTypes) {
      BaseEntity t = RetailscmBaseUtils.getType(dbItem, possibleType);
      if (t == null) {
        continue;
      }
      boolean canBeDeleted = ReflectUtil.invoke(t, "checkIfEligibleForDelete", ctx);
      if (!canBeDeleted) {
        return false;
      }
    }
    return true;
  }

  public static boolean safeDelete(Object ctx, BaseEntity entity) {
    if (entity == null) {
      return false;
    }
    if (entity.getId() == null) {
      return false;
    }
    BaseRequest reloadRequest = RetailscmBaseUtils.createReloadRequest(entity);
    RetailscmBaseUtils.enhanceRequest(reloadRequest);

    BaseEntity dbItem = reloadRequest.execute(ctx);
    List<Class> possibleTypes = getTypes(entity.getClass());
    for (Class possibleType : possibleTypes) {
      BaseEntity t = RetailscmBaseUtils.getType(dbItem, possibleType);
      if (t == null) {
        continue;
      }
      boolean canBeDeleted = ReflectUtil.invoke(t, "checkIfEligibleForDelete", ctx);
      if (!canBeDeleted) {
        StaticLog.debug("不能删除{}({})", t.getInternalType(), t.getId());
        return false;
      }
    }
    for (Class possibleType : possibleTypes) {
      BaseEntity t = RetailscmBaseUtils.getType(dbItem, possibleType);
      if (t == null) {
        continue;
      }
      t.markToRemove();
    }
    ReflectUtil.invoke(dbItem, "save", ctx);
    return true;
  }

  public static <T extends BaseEntity> T createEntity(Class<T> clazz) {
    List<Class> possibleTypes = RetailscmBaseUtils.getParentClasses(clazz);
    try {
      clazz = ClassUtil.loadClass(clazz.getName() + "View");
    } catch (Exception e) {
    }
    T t = ReflectUtil.newInstance(clazz);
    BaseEntity current = t;
    for (Class possibleType : possibleTypes) {
      Class subType;
      try {
        subType = ClassUtil.loadClass(possibleType.getName() + "View");
      } catch (Exception e) {
        subType = possibleType;
      }
      BaseEntity parent = (BaseEntity) ReflectUtil.newInstance(subType);
      ReflectUtil.invoke(parent, "add" + current.getInternalType(), current);
      current = parent;
    }
    return t;
  }

  public static <T> T getFieldValue(BaseEntity entity, String fieldName) {
    List<Class> types = getTypes(entity.getClass());
    for (Class type : types) {
      BaseEntity t = RetailscmBaseUtils.getType(entity, type);
      if (t == null) {
        continue;
      }
      if (ArrayUtil.contains(t.getPropertyNames(), fieldName)) {
        return (T) t.propertyOf(fieldName);
      }
    }
    return null;
  }

  public static void setFieldValues(BaseEntity entity, Map<String, Object> props) {
    if (ObjectUtil.isEmpty(entity) || ObjectUtil.isEmpty(props)) {
      return;
    }
    props.forEach(
        (k, v) -> {
          setFieldValue(entity, k, v);
        });
  }

  public static void setFieldValue(BaseEntity entity, String fieldName, Object value) {
    List<Class> types = getTypes(entity.getClass());
    for (Class type : types) {
      BaseEntity t = RetailscmBaseUtils.getType(entity, type);
      if (t == null) {
        continue;
      }
      if (ArrayUtil.contains(t.getPropertyNames(), fieldName)) {
        Method method =
            ReflectUtil.getMethodByName(t.getClass(), "update" + StrUtil.upperFirst(fieldName));
        ReflectUtil.invoke(t, method, new Object[] {value});
      }
    }
  }

  // 查找自已， 以及自己的parent link的某个属性
  public static Class getFieldType(Class<? extends BaseEntity> entityType, String propertyName) {
    Field field = getField(entityType, propertyName);
    if (field == null) {
      throw new ErrorMessageException("没有找到属性:" + propertyName);
    }
    return field.getType();
  }

  private static Field getField(Class<? extends BaseEntity> entityType, String propertyName) {
    if (entityType == null) {
      return null;
    }
    Field field = ReflectUtil.getField(entityType, propertyName);
    if (field != null) {
      return field;
    } else {
      return getField(RetailscmBaseUtils.getDirectParent(entityType), propertyName);
    }
  }

  private static List<Class> getTypes(Class<? extends BaseEntity> aClass) {
    List<Class> parentClasses = RetailscmBaseUtils.getParentClasses(aClass);
    List<Class> subClasses = RetailscmBaseUtils.getSubClasses(aClass);
    List<Class> all = new ArrayList<>();
    all.addAll(CollectionUtil.reverse(parentClasses));
    all.add(aClass);
    all.addAll(CollectionUtil.reverse(subClasses));
    return all;
  }

  public static void save(CustomRetailscmUserContextImpl ctx, BaseEntity... items)
      throws Exception {
    save(ctx, ListUtil.of(items));
  }

  public static void save(CustomRetailscmUserContextImpl ctx, List<BaseEntity> items)
      throws Exception {
    if (ObjectUtil.isEmpty(items)) {
      return;
    }
    Class type = CollectionUtil.getElementType(items);
    List<Class> types = getTypes(type);
    for (Class aClass : types) {
      List<BaseEntity> l = new ArrayList();
      for (BaseEntity item : items) {
        BaseEntity t = RetailscmBaseUtils.getType(item, aClass);
        if (t == null) {
          continue;
        }
        if (t.isChanged()) {
          l.add(t);
        }
      }
      RetailscmBaseUtils.saveItemSelf(ctx, l);
    }
  }
}
