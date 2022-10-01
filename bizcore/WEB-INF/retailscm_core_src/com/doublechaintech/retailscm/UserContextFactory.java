package com.doublechaintech.retailscm;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserContextFactory implements BeanNameAware, InitializingBean {
  String beanName;

  @Value("7800")
  int port;

  ThreadLocal<CustomRetailscmUserContextImpl> ctx = new ThreadLocal<>();
  Map<String, CustomRetailscmUserContextImpl> ctxMap = new ConcurrentHashMap<>();
  static UserContextFactory factory;

  public static CustomRetailscmUserContextImpl threadContext() {
    return factory.getUserContext();
  }

  public CustomRetailscmUserContextImpl getUserContext() {
    CustomRetailscmUserContextImpl userContext = ctx.get();
    if (userContext != null) {
      return userContext;
    }

    String key = IdUtil.fastSimpleUUID();
    HttpUtil.get(
        StrUtil.format("http://localhost:{}/retailscm/{}/buildContext/{}/", port, beanName, key));

    CustomRetailscmUserContextImpl newContext = ctxMap.remove(key);
    ctx.set(newContext);
    return newContext;
  }

  public void buildContext(CustomRetailscmUserContextImpl userContext, String key) {
    ctxMap.putIfAbsent(key, userContext);
  }

  @Override
  public void setBeanName(String name) {
    beanName = name;
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    factory = this;
  }
}
