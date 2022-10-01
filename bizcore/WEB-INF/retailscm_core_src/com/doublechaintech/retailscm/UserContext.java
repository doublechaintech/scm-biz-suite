package com.doublechaintech.retailscm;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Date;
import java.util.concurrent.*;
import javax.servlet.http.Cookie;
import com.google.gson.Gson;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;

import com.doublechaintech.retailscm.tree.TreeServiceImpl;

public interface UserContext extends BaseUserContext {
  public DateTime now();

  public String currentUserName();

  public void log(String message);

  public void debug(String message);

  public void debug(Callable<String> debugger);

  public String reportExecution();

  public void putToCache(String key, Object value, int timeToLiveInSeconds);

  public void cacheUser(Object value);

  public Object userOf(Class<?> clazz);

  public <T> T getCachedObject(String key, Class<T> clazz);

  public void removeFromCache(String key);

  public void sendEmail(String to, String subject, String content) throws Exception;

  public String tokenId();

  public Object getBean(String beanName);

  public UserContext castTo(Class<UserContext> targetClass) throws Exception;

  public List<String[]> relationBetween(
      String sourceType, String sourceId, String targetType, String targetId);

  public void addAccessTokens(Map<String, Object> tokens);

  public Map<String, Object> getAccessTokens();

  public String getRemoteIP();

  public String getUserAgent();

  public String getRequestUrl();

  public String getPublicMediaServicePrefix();

  public void setPublicMediaServicePrefix(String publicMediaServicePrefix);

  public void sendMessage(
      String dest, String fromWho, String template, Map<String, String> parameters)
      throws Exception;

  public DAOGroup getDAOGroup();

  public ManagerGroup getManagerGroup();

  public String getOwnerBeanName();

  public void setOwnerBeanName(String ownerBeanName);

  public Map<String, Object> getRequestParameters();

  public Map<String, Object> getContextLocalStorage();

  public Object getFromContextLocalStorage(String key);

  public void putIntoContextLocalStorage(String key, Object value);

  public void setContextLocalStorage(Map<String, Object> contextLocalStorage);

  public String getRequestHeader(String name);

  public void setResponseHeader(String name, String value);

  public String getResponseHeadder(String name);

  public void forceResponseXClassHeader(String clazzName);

  public Cookie[] getRequestCookies();

  public <T> List<T> getCachedObjectsWithOneType(List<String> keys, Class<T> clazz);

  public TreeServiceImpl getTreeService();

  public String getCityByIp();

  default String getPossibleParameter(String name) {
    // header
    String requestHeader = getRequestHeader(name);
    if (requestHeader != null) {
      return requestHeader;
    }

    // cookie
    Cookie[] requestCookies = getRequestCookies();
    if (requestCookies != null) {
      for (Cookie c : requestCookies) {
        if (c.getName().equals(name)) {
          return c.getValue();
        }
      }
    }

    // parameter
    Map<String, Object> requestParameters = getRequestParameters();
    if (requestParameters != null) {
      Object o = requestParameters.get(name);
      if (o != null && o instanceof String[]) {
        String[] v = (String[]) o;
        if (v.length == 1) {
          return v[0];
        }
      }
    }

    // in the request body
    byte[] requestBody = getRequestBody();
    if (requestBody != null) {
      try {
        Gson g = new Gson();
        Map map =
            g.fromJson(new InputStreamReader(new ByteArrayInputStream(requestBody)), Map.class);
        Object o = map.get(name);
        if (o != null) {
          return String.valueOf(o);
        }
      } catch (Exception e) {

      }
    }

    // finally in the cache
    return getCachedObject(name, String.class);
  }
}
