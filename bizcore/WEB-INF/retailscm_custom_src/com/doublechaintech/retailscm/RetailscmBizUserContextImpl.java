package com.doublechaintech.retailscm;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;
import java.util.concurrent.*;
import javax.servlet.http.Cookie;


import com.terapico.caf.BlobObject;
import com.terapico.caf.baseelement.LoginParam;
import com.terapico.caf.viewcomponent.ButtonViewComponent;
import com.terapico.caf.viewcomponent.FilterTabsViewComponent;
import com.terapico.caf.viewcomponent.PopupViewComponent;
import com.terapico.utils.*;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterJDBCTemplateDAO;

public class RetailscmBizUserContextImpl extends RetailscmUserContextImpl{

    protected static final String DEFAULT_ACTION_GROUP = "default";
    protected Map<String, List<ButtonViewComponent>> actionGroups;
    protected String accessUrl;
    protected Object resultObject;
    protected String mobile;
    protected String userId;
    protected String lastRecordId;
    protected String verifyCode;
    protected String filter;
    protected String orderId;
    protected String formKey;
    protected String wechatEncryptedData;
    protected String wechatOpenId;
    protected String wechatIv;
    protected String message;
    protected PopupViewComponent popup;
    protected Map<String, Object> toast;
    protected String accessToken;
    protected String jwtKeyId;
    protected FilterTabsViewComponent tabs;
    protected String inputJwtToken;
    protected String assignmentId;
    protected String tabName;

    protected Map<String, Object> formData;
    protected String formDataStr;
    protected LoginParam loginParam;
    protected BaseEntity currentUserInfo;

    protected BlockingQueue<Map<String, Object>> serviceEventQueue;



    public void clearFormResubmitFlag() {
        removeFromCache(getPostMd5Key(this));
    }

    public String getPostMd5Key(RetailscmBizUserContextImpl ctx) {
        return ctx.tokenId()+":postMd5Key";
    }

    public void checkOnlyCalledByLocalhost() throws Exception {
        String ip = getRemoteIP();
        if (!ip.equals("127.0.0.1") && isProductEnvironment()) {
            throw new Exception("本接口只能在本地调用");
        }
    }

public RetailStoreCountryCenterJDBCTemplateDAO dao() {
  return (RetailStoreCountryCenterJDBCTemplateDAO) this.getDAOGroup().getRetailStoreCountryCenterDAO();
}


    public BaseEntity getCurrentUserInfo() {
        return currentUserInfo;
    }

    public void setCurrentUserInfo(BaseEntity currentUserInfo) {
        this.currentUserInfo = currentUserInfo;
    }

    public void setEventResult(String eventName, int processResult) {
        this.putIntoContextLocalStorage("event_" + eventName + "_result", processResult);
    }

    public Integer getEventResult(String eventName) {
        return (Integer) this.getFromContextLocalStorage("event_" + eventName + "_result");
    }

    public void addAction(String title, String code, String linkToUrl) {
        addAction(DEFAULT_ACTION_GROUP, title, code, linkToUrl);
    }

    public void addAction(ButtonViewComponent actionButton) {
        addAction(DEFAULT_ACTION_GROUP, actionButton);
    }

    public List<ButtonViewComponent> getActionList() {
        return getActionList(DEFAULT_ACTION_GROUP);
    }

    public List<ButtonViewComponent> getActionList(String groupName) {
        return ensureActionGroups(groupName);
    }

    public Map<String, ButtonViewComponent> getActions() {
        return getActions(DEFAULT_ACTION_GROUP);
    }

    public Map<String, ButtonViewComponent> getActions(String groupName) {
        List<ButtonViewComponent> actions = ensureActionGroups(groupName);
        Map<String, ButtonViewComponent> resultMap = new HashMap<>();
        for (ButtonViewComponent action : actions) {
            resultMap.put(action.getTag(), action);
        }
        return resultMap;
    }

    public ButtonViewComponent addAction(String groupName, String title, String code, String linkToUrl) {
        List<ButtonViewComponent> actionList = ensureActionGroups(groupName);
        ButtonViewComponent btn = new ButtonViewComponent(title);
        btn.setTag(code);
        btn.setLinkToUrl(linkToUrl);
        actionList.add(btn);
        return btn;
    }

    public ButtonViewComponent addAction(String groupName, ButtonViewComponent actionButton) {
        ensureActionGroups(groupName).add(actionButton);
        return actionButton;
    }

    private List<ButtonViewComponent> ensureActionGroups(String groupName) {
        if (actionGroups == null) {
            actionGroups = new HashMap<>();
        }
        if (TextUtil.isBlank(groupName)) {
            return null;
        }
        List<ButtonViewComponent> actionList = actionGroups.get(groupName);
        if (actionList == null) {
            actionList = new ArrayList<>();
            actionGroups.put(groupName, actionList);
        }
        return actionList;
    }

    public Map<String, List<ButtonViewComponent>> getActionGroups() {
        return actionGroups;
    }

    public void setActionGroups(Map<String, List<ButtonViewComponent>> actionGroups) {
        this.actionGroups = actionGroups;
    }

    public String getAccessUrl() {
        return accessUrl;
    }

    public void setAccessUrl(String accessUrl) {
        this.accessUrl = accessUrl;
    }

    public Object getResultObject() {
        return resultObject;
    }

    public void setResultObject(Object resultObject) {
        this.resultObject = resultObject;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLastRecordId() {
        return lastRecordId;
    }

    public void setLastRecordId(String lastRecordId) {
        this.lastRecordId = lastRecordId;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getFilter() {
        return filter;
    }

    public String getFilter(String defaulValue) {
        if (TextUtil.isBlank(filter)) {
            setFilter(defaulValue);
            return defaulValue;
        }
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getFormKey() {
        return formKey;
    }

    public void setFormKey(String formKey) {
        this.formKey = formKey;
    }

    public String getWechatEncryptedData() {
        return wechatEncryptedData;
    }

    public void setWechatEncryptedData(String wechatEncryptedData) {
        this.wechatEncryptedData = wechatEncryptedData;
    }

    public String getWechatOpenId() {
        return wechatOpenId;
    }

    public void setWechatOpenId(String wechatOpenId) {
        this.wechatOpenId = wechatOpenId;
    }

    public String getWechatIv() {
        return wechatIv;
    }

    public void setWechatIv(String wechatIv) {
        this.wechatIv = wechatIv;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PopupViewComponent getPopup() {
        return popup;
    }

    public void setPopup(PopupViewComponent popup) {
        this.popup = popup;
    }

    public Map<String, Object> getToast() {
        return toast;
    }

    public void setToast(Map<String, Object> toast) {
        this.toast = toast;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getJwtKeyId() {
        return jwtKeyId;
    }

    public void setJwtKeyId(String jwtKeyId) {
        this.jwtKeyId = jwtKeyId;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    public String getTabName(String defaultValue) {
        if (TextUtil.isBlank(tabName)) {
            tabName = defaultValue;
        }
        return tabName;
    }

    public FilterTabsViewComponent getTabs() {
        return tabs;
    }

    public void setTabs(FilterTabsViewComponent tabs) {
        this.tabs = tabs;
    }

    public String getInputJwtToken() {
        return inputJwtToken;
    }

    public void setInputJwtToken(String inputJwtToken) {
        this.inputJwtToken = inputJwtToken;
    }

    public String getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(String assignmentId) {
        this.assignmentId = assignmentId;
    }

    public LoginParam getLoginParam() {
        return loginParam;
    }

    public void setLoginParam(LoginParam loginParam) {
        this.loginParam = loginParam;
    }

    public Map<String, Object> getFormData() {
      return formData;
    }

    public void setFormData(Map<String, Object> formData) {
      this.formData = formData;
    }
    public void setFormData(String formData) {
      if (TextUtil.isBlank(formData) || formData.equals("formData")) {
        this.formDataStr = null;
        this.formData = null;
        return;
      }
      this.formDataStr = formData;
      try {
        this.formData = DebugUtil.getObjectMapper().readValue(formData, Map.class);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    @Override
    public void sendEmail(String to, String subject, String content) throws Exception {
        if (!isProductEnvironment()) {
            to = EnvUtil.getEnvVariable("EXCEPTION_MONITOR", "wangyudong@doublechaintech.com");
        }
        String finalTo = to;
        TaskUtil.runAsync(()->{
          super.sendEmail(finalTo, subject, content);
          return null;
        });
    }

    @Override
    public void sendEmailWithAttachment(String to, String subject, String content, List<BlobObject> attachments)
            throws Exception {
        if (!isProductEnvironment()) {
            to = EnvUtil.getEnvVariable("EXCEPTION_MONITOR", "wangyudong@doublechaintech.com");
        }
        super.sendEmailWithAttachment(to, subject, content, attachments);
    }

    @Override
      public void sendMessage(
          String dest, String fromWho, String template, Map<String, String> parameters)
          throws Exception {
        if (!isProductEnvironment()) {
          System.out.printf("send to %s: %s:%s\n", dest, template, String.valueOf(parameters));
          sendEmail(TextUtil.getExtVariable("SMS_EMAIL_IN_TEST", "wangyudong@doublechaintech.com,liyaqing@doublechaintech.com"),
                        getEnvironmentName()+" RETAILSCM: 模拟短信发送 to " + dest,
                        String.format("短信模板:%s\r\n短信参数:%s\r\n", template, String.valueOf(parameters)));
          return; // 短信直接不发
        }
        try {
          super.sendMessage(dest, fromWho, template, parameters);
        }catch (Exception e){
          e.printStackTrace();
          sendMonitorEmail(e);
          throw new RuntimeException(e);
        }
      }

      protected void sendMonitorEmail(Exception exception) {
        String to = EnvUtil.getEnvVariable("EXCEPTION_MONITOR", "wangyudong@doublechaintech.com");
        String subject = this.getEnvironmentName() + "异常:" + exception.getMessage();
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(bout);
        DebugUtil.dumpFullStackTrace(exception, out);
        try {
          this.sendEmail(to, subject, bout.toString("UTF-8"));
        } catch (Exception e) {
          e.printStackTrace();
          throw new RuntimeException(e);
        }
      }

    // 这个对象仅用于在开发环境中, 用cookie来模拟react-client的 JWT header. 因为开发环境使用的是普通的浏览器,不能在A
    // href的header中设置值.
    protected Cookie[] cookies;

    public Cookie[] getCookies() {
        return cookies;
    }

    public void setCookies(Cookie[] cookies) {
        this.cookies = cookies;
    }

    public String makeMessage(String key, Map<String, Object> data) throws Exception {
        if (allTerms == null) {
          throw new Exception("请先注入 allTerms");
        }
        List<String> candidateTemplates = allTerms.get(key);
        if (candidateTemplates == null || candidateTemplates.isEmpty()) {
            throw new Exception("没有定义 " + key +" 对应的消息模板");
        }
        String template = candidateTemplates.get((int) (candidateTemplates.size()*Math.random()));
        return FreemarkerUtil.stringRender(template, data);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
//  6种标准调用模式
  protected BlockingQueue<Map<String, Object>> ensureServiceEventQueue() {
    if (serviceEventQueue != null) {
      return serviceEventQueue;
    }
    return serviceEventQueue = new LinkedBlockingDeque<>();
  }

  /**
   * 立即触发一个调用,并且同步等待处理结果. <p/>
   * 等价于立即调用.
   */
  public <T> T processNow(Callable<T> callable) throws Exception {
    return callable.call();
  }

  /**
   * 立即触发一个异步调用,然后不再关心任何后续. <p/>
   * 此时要求一个 runnable, 即异常需要自己处理
   */
  public void processAsync(Runnable runnable) {
    TaskUtil.runAsync(runnable);
  }
  /**
   * 立即触发一个异步调用,然后不再关心任何后续. <p/>
   * 此时要求一个 Callable, 异常会被统一处理: 发送邮件
   */
  public <T> void processAsync(Callable<T> callable) {
    TaskUtil.runAsync(callWithDefaultExceptionHandling(callable, "异步调用异常"));
  }


  protected String getExceptionMonitorEmails() {
    return "env:RETAILSCM_EXCEPTION_MONITOR";
  }

  /**
   * 立即触发一个调用,返回一个Future,等到需要的时候get结果.
   */
  public <T> Future<T> processNowAndCheckLater(Callable<T> callable) {
    return TaskUtil.runAsync(callable);
  }

  /**
   * 计划一个任务,直到后置处理时,开始此任务, 并且同步等待此任务结束. 异常需要自己处理.
   */
  public String processLater(Runnable runnable) throws Exception {
    return addPostTask(true, true, runnable);
  }
  /**
   * 计划一个任务,直到后置处理时,开始此任务, 并且同步等待此任务结束. 异常将会通过邮件发送
   */
  public String processLater(Callable<?> callable) throws Exception {
    return addPostTask(true, true, callWithDefaultExceptionHandling(callable, "后置处理调用异常"));
  }

  /**
   * 计划一个任务,直到后置处理时,开始此任务, 并且不再关心后续. 异常需要自己处理.
   */
  public String processLaterAsync(Runnable runnable) throws Exception {
    return addPostTask(false, true, runnable);
  }
  /**
   * 计划一个任务,直到后置处理时,开始此任务, 并且不再关心后续. 异常会通过邮件发送.
   */
  public String processLaterAsync(Callable<?> callable) throws Exception {
    return addPostTask(false, true, callWithDefaultExceptionHandling(callable, "后置处理调用异常"));
  }

  /**
   * 计划一个任务,直到后置处理时,开始此任务, 并且直到处理完成,才结束后置处理. 异常需要自己处理.
   */
  public String processLaterAndCheckFinally(Runnable runnable) throws Exception {
    return addPostTask(true, false, runnable);
  }
  /**
   * 计划一个任务,直到后置处理时,开始此任务, 并且直到处理完成,才结束后置处理. 异常需要自己处理.
   */
  public String processLaterAndCheckFinally(Callable<?> callable) throws Exception {
    return addPostTask(true, false, callable);
  }

  protected boolean hasPostTask() {
    if (serviceEventQueue == null) {
      return false;
    }
    return serviceEventQueue.peek() != null;
  }
  protected Map<String, Object> getPostTask() {
    if (serviceEventQueue == null) {
      return null;
    }
    return serviceEventQueue.poll();
  }

  public void postProcessing(){
    while(true){
      if (!hasPostTask()){
        return;
      }
      List<Future<?>> needWaits = new ArrayList<>();
      while(hasPostTask()){
        Map<String, Object> task = getPostTask();
        Object runnable = task.get("runnable");
        boolean needResponse = (boolean) task.get("needResponse");
        boolean waitResponseNow = (boolean) task.get("waitResponseNow");

        if (needResponse && waitResponseNow){
          if (runnable instanceof Runnable) {
            ((Runnable) runnable).run();
          }else{
            log("post task is not a Runnable");
          }
          continue;
        }

        if (!needResponse){
          if (runnable instanceof Runnable) {
            TaskUtil.runAsync((Runnable) runnable);
          }else{
            log("post task is not a Runnable");
          }
          continue;
        }

        if (runnable instanceof Runnable) {
          TaskUtil.runAsync((Runnable) runnable);
        }else if (runnable instanceof Callable) {
          needWaits.add(TaskUtil.runAsync((Callable) runnable));
        }else{
          log("post task is neither a Runnable nor a Callable");
        }
      }

      for (Future<?> needWait : needWaits) {
        try {
          needWait.get();
        } catch (Exception e) {
          emailException("后置调用等待结果异常", e);
        }
      }
    }
  }
  protected String addPostTask(boolean needResponse, boolean waitResponseNow, Object runnable) throws Exception {
    String ticketId = Thread.currentThread().getName()+"_"+System.currentTimeMillis();
    ensureServiceEventQueue().put(MapUtil.put("taskType", "runnable")
            .put("runnable", runnable)
            .put("ticketId", ticketId)
            .put("needResponse", needResponse)
            .put("waitResponseNow", waitResponseNow)
            .into_map());
    return ticketId;
  }

  protected Runnable callWithDefaultExceptionHandling(Callable<?> callable, String errorMessage){
    return ()->{
      try {
        callable.call();
      } catch (Exception e) {
        emailException(errorMessage, e);
      }
    };
  }

  protected void emailException(String errorMessage, Exception e) {
    e.printStackTrace();
    String to = EnvUtil.getValueFromEnv(getExceptionMonitorEmails(), "EXCEPTION_MONITOR", "wangyudong@doublechaintech.com");
    ByteArrayOutputStream bs = new ByteArrayOutputStream();
    PrintStream s = new PrintStream(bs);
    DebugUtil.dumpFullStackTrace(e,s);
    try {
      sendEmail(to, this.getEnvironmentName() + ":" + errorMessage, bs.toString());
    } catch (Exception exception) {
      exception.printStackTrace();
    }
  }

  public <T extends BaseEntity> List<T> enhanceUpStream(Object data, Class<T> clazz) throws Exception {
    if (data == null){
      return new ArrayList<>();
    }
    if (data instanceof SmartList){
      List list = RetailscmBaseUtils.collectReferencedObjectWithType(this, (SmartList) data, clazz);
      this.getDAOGroup().enhanceList(list, clazz);
      return list;
    }
    if (data instanceof List){
      List list = RetailscmBaseUtils.collectReferencedObjectWithType(this, (List) data, clazz);
      this.getDAOGroup().enhanceList(list, clazz);
      return list;
    }
    if (data instanceof BaseEntity){
      List<T> list = RetailscmBaseUtils.collectReferencedObjectWithType(this, (BaseEntity) data, clazz);
      this.getDAOGroup().enhanceList(list, clazz);
      return list;
    }
    throw new Exception("不能处理"+data.getClass().getSimpleName()+"的enhance");
  }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
}

















