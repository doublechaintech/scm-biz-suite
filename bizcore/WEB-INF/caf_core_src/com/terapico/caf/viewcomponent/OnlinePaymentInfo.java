package com.terapico.caf.viewcomponent;

import com.github.binarywang.wxpay.bean.order.WxPayMpOrderResult;

public class OnlinePaymentInfo{
    protected String className = OnlinePaymentInfo.class.getName();
    private String timeStamp;
    private String nonceStr;
    private String packageValue;
    private String signType;
    private String paySign;
    private String paymentMethod;
    private String successUrl;
    private String failedUrl;
    
    public void initWithWxOrderInfo(WxPayMpOrderResult wxOrderInfo) {
        paymentMethod = "wechat";
        timeStamp = wxOrderInfo.getTimeStamp();
        nonceStr = wxOrderInfo.getNonceStr();
        packageValue = wxOrderInfo.getPackageValue();
        signType = wxOrderInfo.getSignType();
        paySign = wxOrderInfo.getPaySign();
        
    }

    
    public String getFailedUrl() {
		return failedUrl;
	}


	public void setFailedUrl(String failedUrl) {
		this.failedUrl = failedUrl;
	}


	public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getPackageValue() {
        return packageValue;
    }

    public void setPackageValue(String packageValue) {
        this.packageValue = packageValue;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getPaySign() {
        return paySign;
    }

    public void setPaySign(String paySign) {
        this.paySign = paySign;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getClassName() {
        return className;
    }

    public String getSuccessUrl() {
        return successUrl;
    }

    public void setSuccessUrl(String successUrl) {
        this.successUrl = successUrl;
    }
    
    
}
