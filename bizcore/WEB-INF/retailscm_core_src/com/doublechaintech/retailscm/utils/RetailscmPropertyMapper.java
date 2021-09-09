package com.doublechaintech.retailscm.utils;

import com.doublechaintech.retailscm.*;
import com.terapico.utils.*;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class RetailscmPropertyMapper {
    protected static Map<String, RetailscmBeanCreator> customCreators = new HashMap<>();
    protected RetailscmUserContext userContext;

    public RetailscmUserContext getUserContext() {
      return userContext;
    }
    public void setUserContext(RetailscmUserContext userContext) {
      this.userContext = userContext;
    }

    public static void registerCreator(Class beanClass, RetailscmBeanCreator creator) {
      registerCreator(beanClass, null, creator);
    }
    public static void registerCreator(Class beanClass, CreationScene scene, RetailscmBeanCreator creator) {
      registerCreator(beanClass, null, null, creator);
    }
    public static void registerCreator(Class beanClass, CreationScene scene, String propertyName, RetailscmBeanCreator creator) {
      String key = calcCreatorKey(beanClass, scene, propertyName);
      customCreators.put(key, creator);
    }

    public static String calcCreatorKey(Class beanClass, CreationScene scene, String propertyName) {
      String key = beanClass.getName();
      if (scene == null){
        key += "/$ALL";
      }else{
        key += scene.getName();
      }

      if (propertyName != null){
        key += "/" + propertyName;
      }
      return key;
    }

    public <T> RetailscmBeanCreator<T> findCustomCreator(Class<T> beanClass) {
      return findCustomCreator(beanClass, null);
    }

    public <T> RetailscmBeanCreator<T> findCustomCreator(Class<T> beanClass, CreationScene scene) {
      return findCustomCreator(beanClass, scene, null);
    }

    public <T> RetailscmBeanCreator<T> findCustomCreator(Class<T> beanClass, CreationScene scene, String propertyName) {
      String key = calcCreatorKey(beanClass, scene, propertyName);
      RetailscmBeanCreator<T> creator = customCreators.get(key);
      if (creator != null || scene == null){
        return creator;
      }
      key = calcCreatorKey(beanClass, null, propertyName);
      return customCreators.get(key);
    }

    public static <C> C findParamByClass(List<Object> params, Class<C> clazz){
      if (params == null || params.isEmpty()){
        return null;
      }
      return (C) params.stream().filter(it->it !=null && it.getClass().equals(clazz)).findFirst().orElse(null);
    }

    public <T,B> T tryToGet(Class beanClass, String propertyName, Class<T> propertyType, int indexInType, boolean onlyOneInType, T defaultValue, List<Object> inputs) {
        T result = tryToGetFrom(beanClass, propertyName, propertyType, indexInType, onlyOneInType, defaultValue, inputs);
        getUserContext().debug(()->String.format("try to set %s.%s = %s", beanClass.getSimpleName(), propertyName, result));
        return result;
    }

    protected <T,B> T tryToGetFrom(Class beanClass, String propertyName, Class<T> propertyType, int indexInType, boolean onlyOneInType, T defaultValue, List<Object> inputs) {
        CreationScene scene = findParamByClass(inputs, CreationScene.class);
        RetailscmBeanCreator<B> customCreator = findCustomCreator(beanClass, scene, propertyName);
        if (customCreator != null) {
          return customCreator.tryToGet(scene, beanClass, propertyName, propertyType, indexInType, onlyOneInType, defaultValue, inputs);
        }

        if (inputs == null || inputs.isEmpty()){
            return defaultValue;
        }

        if (onlyOneInType) {
            // 如果这个类型只有一个, 直接按类型就可以找了
            T value = findByType(propertyType, inputs);
            if (value == null){
                value = findByChildType(propertyType, inputs);
            }
            if (value == null){
                value = findFromMembers(propertyName, propertyType, inputs);
            }
            if (value != null){
                return value;
            }
            return defaultValue;
        }

        // 这个类型的数据不止一个, 那么我们就要看名字了
        // 如果本身是元类型,那么先按顺序来, 再按名字找
        List<Object> list = inputs.stream()
                .filter(it -> (it != null && it.getClass().equals(propertyType)))
                .collect(Collectors.toList());
        if (list != null && list.size() > indexInType){
            return (T) list.get(indexInType);
        }
        T value = findFromMembers(propertyName, propertyType, inputs);
        if (value != null){
            return value;
        }
        return defaultValue;
    }

    protected  <T> T findFromMembers(String propertyName, Class propertyType, List<Object> inputs) {
        for (Object input : inputs) {
            if (input == null || input.getClass().isPrimitive()){
                continue;
            }
            Object objVal = getPropertyValue(input, propertyName, propertyType);
            if (objVal == null){
                continue;
            }
            if (DataTypeUtil.isSameClass(propertyType, objVal.getClass())) {
                return (T) objVal;
            }
            if (propertyType.isAssignableFrom(objVal.getClass())){
                return (T) objVal;
            }
        }
        return null;
    }

    protected Object getPropertyValue(Object input, String propertyName, Class propertyType) {
        if (input == null){
          return null;
        }
        if (input instanceof Map){
          return ((Map) input).get(propertyName);
        }

        propertyName = TextUtil.capFirstChar(propertyName);
        String getterName = "get"+ propertyName;
        try {
          Method method = input.getClass().getMethod(getterName);
          Object val = method.invoke(input);
          if (val != null){
            return val;
          }
        } catch (Exception e) {
        }

        if (propertyType.equals(Boolean.TYPE) || propertyType.equals(Boolean.class)){
          getterName = "is"+ propertyName;
          try {
            Method method = input.getClass().getMethod(getterName);
            Object val = method.invoke(input);
            if (val != null){
              return val;
            }
          } catch (Exception e) {
          }
        }
        return null;
      }

    protected <T> T findByChildType(Class propertyType, List<Object> inputs) {
        List<Object> list = inputs.stream()
                .filter(it -> (it != null && propertyType.isAssignableFrom(it.getClass())))
                .collect(Collectors.toList());
        if (list.size() == 1){
            return (T) list.get(0);
        }
        return null;
    }

    protected  <T> T findByType(Class propertyType, List<Object> inputs) {
        List<Object> list =
                inputs.stream()
                    .filter(it -> (it != null && ( DataTypeUtil.isSameClass(propertyType, it.getClass()) ||  propertyType.isAssignableFrom(it.getClass()))))
                    .collect(Collectors.toList());
        if (list.size() == 1){
            return (T) list.get(0);
        }
        return null;
    }
}
















