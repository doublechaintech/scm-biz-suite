package com.doublechaintech.retailscm.utils;

import com.doublechaintech.retailscm.BaseEntity;

import java.util.HashMap;
import java.util.Map;

public class DestRefUtils {
  public static Map<String, String> destRefs = new HashMap<>();

  static {

  }

  public static <T extends BaseEntity> T extract(BaseEntity source, Class<T> target) {
    try {
      return extract(source, target.newInstance());
    } catch (Exception pE) {
      pE.printStackTrace();
    }
    return null;
  }

  public static <T extends BaseEntity> T extract(BaseEntity source, T target) {
    if (source == null) {
      return null;
    }
    String sourceName = source.getClass().getSimpleName();
    String targetName = target.getClass().getSimpleName();
    Map<String, String> mappingMeta = extractMeta(sourceName, targetName);
    if (mappingMeta.isEmpty()) {
      return null;
    }

    Map<String, Object> ctx = new HashMap<>();
    ctx.put(sourceName, source);
    ctx.put(targetName, target);

    mappingMeta.forEach(
        (from, to) -> {
          try {
            BeanUtils.setPropertyValue(ctx, to, BeanUtils.getPropertyValue(ctx, from));
          } catch (Exception e) {
            e.printStackTrace();
          }
        });
    return target;
  }

  private static Map<String, String> extractMeta(String sourcePrefix, String targetPrefix) {
    Map<String, String> mappings = new HashMap<>();
    destRefs.forEach(
        (k, v) -> {
          if (k.startsWith(sourcePrefix + ".") && v.startsWith(targetPrefix + ".")) {
            mappings.put(k, v);
          }
        });
    return mappings;
  }
}

















