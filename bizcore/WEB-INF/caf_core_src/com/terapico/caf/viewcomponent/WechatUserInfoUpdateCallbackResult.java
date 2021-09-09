package com.terapico.caf.viewcomponent;

/**
 * 微信用户信息更新的回调结果
 * @author clariones
 *
 */
public class WechatUserInfoUpdateCallbackResult{
    protected String className = WechatUserInfoUpdateCallbackResult.class.getName();
    protected String message;
    protected boolean success = true;
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
    
    
}
