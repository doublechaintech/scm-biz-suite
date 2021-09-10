package com.terapico.meta;

import java.util.HashMap;
import java.util.Map;

public class MetaProvider {
  public static Map<String, EntityMeta> entities = new HashMap<>();

  public static EntityMeta entity(Class entity) {
    return entity(entity.getName());
  }

  public static EntityMeta entity(String entity) {
     entities.putIfAbsent(entity, new EntityMeta(entity));
     return entities.get(entity);
  }

}
