package com.doublechaintech.retailscm.search;

import cn.hutool.core.util.ReflectUtil;
import com.doublechaintech.retailscm.BaseEntity;

import com.doublechaintech.retailscm.Beans;
import com.terapico.utils.TextUtil;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Searcher {
    public static <T extends BaseEntity> List<T> search(Object userContext, BaseRequest<T> pRequest) {
        String internalType = pRequest.getInternalType();
        Object manager = Beans.getBean(TextUtil.uncapFirstChar(internalType) + "Manager");

        Method searchMethod =
                ReflectionUtils.findMethod(manager.getClass(), "search" + internalType + "List", (Class<?>[]) null);
        try {
            return (List<T>) searchMethod.invoke(manager, userContext, pRequest);
        } catch (Exception pE) {
            pE.printStackTrace();
            return null;
        }
    }

     public static <T extends BaseEntity> T searchOne(Object userContext, BaseRequest<T> pRequest) {
        String internalType = pRequest.getInternalType();
        Object manager = Beans.getBean(TextUtil.uncapFirstChar(internalType) + "Manager");
        try {
          return (T) ReflectUtil.invoke(manager, "search" + internalType, userContext, pRequest);
        } catch (Exception pE) {
          pE.printStackTrace();
          return null;
        }
      }

    public static <T extends BaseEntity> void enhance(List<T> list, BaseRequest<T> pRequest) {
         if (list == null || list.isEmpty()) {
            return;
          }
        Map<String, BaseRequest> parentSelects = pRequest.getParentSelects();
        parentSelects.forEach((k, v) -> {
            List<BaseEntity> parentsIdOnly = list.stream().map(item -> (BaseEntity) item.propertyOf(k))
                    .filter(n -> n != null)
                    .collect(Collectors.toList());
            if (parentsIdOnly.isEmpty()) {
              return;
            }
            v.doAddSearchCriteria(new SimplePropertyCriteria("id", QueryOperator.IN, parentsIdOnly));
            Map<String, BaseEntity> parentFull = (Map<String, BaseEntity>) search(pRequest.getUserContext(), v).stream()
                    .collect(Collectors.toMap(item -> ((BaseEntity) item).getId(), p -> p, (v1, v2) -> v1));
            parentsIdOnly.forEach(parent -> {
                parentFull.get(parent.getId()).copyTo(parent);
            });
        });
        Map<String, BaseRequest> childrenSelects = pRequest.getChildrenSelects();
        Map<String, T> map = list.stream().collect(Collectors.toMap(BaseEntity::getId, n -> n, (v1, v2) -> v1));
        childrenSelects.forEach((k, v) -> {
            k = k.substring(v.getInternalType().length());
            v.select(k);
            v.doAddSearchCriteria(new SimplePropertyCriteria(k, QueryOperator.IN, list));
            List<BaseEntity> children = search(pRequest.getUserContext(), v);
            for (BaseEntity child : children) {
                BaseEntity baseEntity = (BaseEntity) child.propertyOf(k);
                T t = map.get(baseEntity.getId());
                Method addChildMethod = findAddChildMethod(t.getClass(), child.getClass(), k);
                try {
                    addChildMethod.invoke(t, child);
                } catch (Exception pE) {
                    pE.printStackTrace();
                }
            }
        });
    }

    public static Method findAddChildMethod(Class parent, Class child, String property) {
        Method method = ReflectionUtils.findMethod(parent, "add" + child.getSimpleName(), child);
        if (method == null) {
            method =
                    ReflectionUtils.findMethod(
                            parent,
                            "add" + child.getSimpleName() + "As" + TextUtil.capFirstChar(property),
                            child);
        }
        return method;
    }
}

