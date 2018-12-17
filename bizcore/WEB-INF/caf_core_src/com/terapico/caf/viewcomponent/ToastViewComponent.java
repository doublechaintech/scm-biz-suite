package com.terapico.caf.viewcomponent;

/**
 * toast文本组件
 * <p>
 * componentType=toast
 * </p>
 * 
 * content为要显示的内容。<p/>
 * level为显示的消息级别。 目前暂不使用。<p/>
 * 这个组件必须放在Page组件的第一层。最好是第一个。
 * 
 * @author clariones
 */
public class ToastViewComponent extends BaseViewComponent {
    protected String level;
    protected String img;
    
    
    public String getImg() {
		String srcUrl = img;
        if (srcUrl == null) {
            return null;
        }
        String lowerUrl = srcUrl.toLowerCase();
        if (lowerUrl.startsWith("http://") || lowerUrl.startsWith("https://")) {
            return ImageViewComponent.appendImageVersionPostFix(srcUrl);
        }
        String urlPrefix = getExtVariable("STATIC_RESOURCE_URL_PREFIX", "http://127.0.0.1:8080/naf/statics/");
        return ImageViewComponent.appendImageVersionPostFix(concatUrl(urlPrefix, srcUrl));
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public ToastViewComponent() {
        this(null);
    }

    public ToastViewComponent(String content) {
        this(content, null);
    }

    public ToastViewComponent(String content, String classes) {
        this(content, classes, null);
    }

    public ToastViewComponent(String content, String classes, String tag) {
        this.setContent(content);
        this.setClasses(classes);
        this.setTag(tag);
        this.setComponentType("toast");
    }
    
}
