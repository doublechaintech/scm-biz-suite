package com.doublechaintech.retailscm;

import cn.hutool.core.collection.CollStreamUtil;
import cn.hutool.core.util.ObjectUtil;
import com.terapico.utils.TaskUtil;
import org.springframework.beans.factory.InitializingBean;

import java.util.*;

public class AsyncSaver implements InitializingBean {
  private List<SaveContext> tasks = new ArrayList<>();
  public static AsyncSaver INSTANCE;

  @Override
  public void afterPropertiesSet() throws Exception {
    TaskUtil.addScheduleTask(AsyncSaver.class.getName(), 200, this::save);
    INSTANCE = this;
  }

  private void save() {
    SaveContext saveContext = null;
    synchronized (tasks) {
      if (tasks.isEmpty()) {
        return;
      }
      saveContext = tasks.remove(0);
    }

    com.doublechaintech.retailscm.secuser.CustomSecUserManagerImpl.GLOBAL_CONTEXT.set(
        (UserContextImpl) saveContext.getCtx());
    List<BaseEntity> entities = saveContext.getEntities();
    Map<String, List<BaseEntity>> entitiesByType =
        CollStreamUtil.groupByKey(entities, BaseEntity::getInternalType);

    for (List<BaseEntity> toBeSave : entitiesByType.values()) {
      SmartList l = new SmartList();
      l.addAll(toBeSave);
      l.save(saveContext.getCtx());
    }
  }

  class SaveContext {
    RetailscmUserContext ctx;
    List<BaseEntity> entities = new Vector<>();

    public RetailscmUserContext getCtx() {
      return ctx;
    }

    public void setCtx(RetailscmUserContext pCtx) {
      ctx = pCtx;
    }

    public List<BaseEntity> getEntities() {
      return entities;
    }

    public void setEntities(List<BaseEntity> pEntities) {
      entities = pEntities;
    }

    public void save(BaseEntity entity) {
      entities.add(entity);
    }
  }

  public static void send(UserContext ctx, Collection<? extends BaseEntity> entities) {
    if (ObjectUtil.isEmpty(entities)) {
      return;
    }
    for (BaseEntity entity : entities) {
      send(ctx, entity);
    }
  }

  public static void send(UserContext ctx, BaseEntity... entities) {
    if (ObjectUtil.isEmpty(entities)) {
      return;
    }
    for (BaseEntity entity : entities) {
      INSTANCE.saveInTask(ctx, entity);
    }
  }

  private void saveInTask(UserContext ctx, BaseEntity entity) {
    synchronized (tasks) {
      for (SaveContext task : tasks) {
        if (task.ctx == ctx) {
          task.save(entity);
        }
      }
      SaveContext saveContext = new SaveContext();
      tasks.add(saveContext);
      saveContext.setCtx((RetailscmUserContext) ctx);
      saveContext.save(entity);
    }
  }
}
