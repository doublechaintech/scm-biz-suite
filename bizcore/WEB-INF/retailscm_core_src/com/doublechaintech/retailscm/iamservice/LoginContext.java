package com.doublechaintech.retailscm.iamservice;

public class LoginContext {
  protected LoginChannel loginChannel;
  protected LoginMethod loginMethod;
  protected LoginData loginData;
  protected LoginTarget loginTarget;

  public LoginChannel getLoginChannel() {
    return loginChannel;
  }

  public void setLoginChannel(LoginChannel loginChannel) {
    this.loginChannel = loginChannel;
  }

  public LoginMethod getLoginMethod() {
    return loginMethod;
  }

  public void setLoginMethod(LoginMethod loginMethod) {
    this.loginMethod = loginMethod;
  }

  public LoginData getLoginData() {
    return loginData;
  }

  public void setLoginData(LoginData loginData) {
    this.loginData = loginData;
  }

  public LoginTarget getLoginTarget() {
    if (loginTarget == null) {
      loginTarget = new LoginTarget();
    }
    return loginTarget;
  }

  public void setLoginTarget(LoginTarget loginTarget) {
    this.loginTarget = loginTarget;
  }

  public String getKey() {
    return getLoginMethod().name() + "://" + getLoginChannel().getKey();
  }

  public static LoginContext of(LoginMethod method, LoginChannel channel, LoginData data) {
    LoginContext result = new LoginContext();
    result.setLoginChannel(channel);
    result.setLoginMethod(method);
    result.setLoginData(data);
    return result;
  }
}
