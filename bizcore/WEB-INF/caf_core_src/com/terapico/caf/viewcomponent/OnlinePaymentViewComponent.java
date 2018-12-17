package com.terapico.caf.viewcomponent;

/**
 * 在线支付组件
 * <p>
 * componentType=online-payment
 * </p>
 * 
 * content为按钮的内容。 link-to-url 是提交form的对应URL。
 * 
 * 这个组件的前半段和form-action一样，区别在于对response的处理。
 * form-action的结果要么是exception，要么是BaseViewComponent。
 * 这个的response可能是exception，也可以是BaseViewComponent，但是 大多数时候返回的是
 * “OnlinePaymentInfo” 这个class。 对这个class，要分析其内容，从而调用对应的平台API，启动支付流程。
 * 
 * 这个组件理论上支持各种支付模式，第一个版本仅要求微信支付。
 * 
 * @author clariones
 */
public class OnlinePaymentViewComponent extends BaseViewComponent {
    protected boolean statInPage = true;
    
    public boolean isStatInPage() {
        return statInPage;
    }

    public void setStatInPage(boolean statInPage) {
        this.statInPage = statInPage;
    }

    public OnlinePaymentViewComponent() {
        this(null);
    }

    public OnlinePaymentViewComponent(String content) {
        this(content, null);
    }

    public OnlinePaymentViewComponent(String content, String classes) {
        this(content, classes, null);
    }

    public OnlinePaymentViewComponent(String content, String classes, String tag) {
        this.setContent(content);
        this.setClasses(classes);
        this.setTag(tag);
        this.setComponentType("online-payment");
    }
}
