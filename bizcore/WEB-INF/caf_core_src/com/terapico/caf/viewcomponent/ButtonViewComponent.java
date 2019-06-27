package com.terapico.caf.viewcomponent;

/**
 * 按钮组件
 * <p>
 * componentType=button
 * </p>
 * 
 * content为按钮文字的内容。 type 为按钮类型。
 * 
 * @author clariones
 */
public class ButtonViewComponent extends BaseViewComponent {
    /**
     * 按钮类型。
     * 
     * 如果是普通按钮（type=link）才有效。 目前有：default，primary，info，warning，error。
     */
    protected String level;
    /**
     * 图片URL
     * 
     * 仅用于分享按钮 (type=share).
     */
    protected String imageUrl;
    /**
     * 按钮类型
     * <ul>
     * <li>link: 点击后跳转URL</li>
     * <li>getPhoneNumber: 引导小程序客户授权获取手机号</li>
     * <li>getUserInfo: 引导小程序客户授权获取用户信息</li>
     * <li>share: 分享页面</li>
     * </ul>
     */
    protected String type = "link";
    /**
     * 分享标题。 仅用于分享按钮 (type=share).
     */
    protected String shareTitle;
    /**
     * 对特别类型的button，getPhoneNumber和getUserInfo 需要回调后台接口，处理用户授权的数据。此URL为对应的接口URL
     */
    protected String callbackUrl;

    protected String shareRouter;
    
    public String getShareRouter() {
		return shareRouter;
	}

	public void setShareRouter(String shareRouter) {
		this.shareRouter = shareRouter;
	}

	public String getShareTitle() {
        return shareTitle;
    }

    public void setShareTitle(String shareTitle) {
        this.shareTitle = shareTitle;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ButtonViewComponent() {
        this(null);
    }

    public ButtonViewComponent(String content) {
        this(content, null);
    }

    public ButtonViewComponent(String content, String classes) {
        this(content, classes, null);
    }

    
    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callBackUrl) {
        this.callbackUrl = callBackUrl;
    }

    public ButtonViewComponent(String content, String classes, String tag) {
        this.setContent(content);
        this.setClasses(classes);
        this.setTag(tag);
        this.setComponentType("button");
    }

	@Override
	protected String getNodeHashcodeStr() {
		return super.getNodeHashcodeStr()+this.getType()+";";
	}
    
    
}
