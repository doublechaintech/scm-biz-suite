package com.terapico.caf.viewcomponent;

/**
 * 图像显示组件。
 * <p>
 * containerType=image
 * </p>
 * 
 * 这个是显示图像的，不包括上传、删除等。 需要编辑的，需要使用 type=image的form-field。
 * 
 * content 是 image 的URL。 clickToBiggerView 点击后是否需要显示大图。 默认true。
 * 
 * @author clariones
 *
 */
public class ImageViewComponent extends BaseViewComponent {
    public ImageViewComponent() {
        this(null);
    }

    public ImageViewComponent(String url) {
        this(url, null);
    }

    public ImageViewComponent(String url, String classes) {
        this(url, classes, true);
    }

    public ImageViewComponent(String url, String classes, boolean viewBigger) {
        this.setContent(url);
        this.setClasses(classes);
        this.setClickToBiggerView(viewBigger);
        this.setComponentType("image");
    }

    /** 点击后是否需要显示大图。 */
    boolean clickToBiggerView = false;

    public boolean isClickToBiggerView() {
        return clickToBiggerView;
    }

    public void setClickToBiggerView(boolean clickToBiggerView) {
        this.clickToBiggerView = clickToBiggerView;
    }

    @Override
    public Object getContent() {
        String srcUrl = (String) super.getContent();
        if (srcUrl == null) {
            return null;
        }
        String lowerUrl = srcUrl.toLowerCase();
        if (lowerUrl.startsWith("http://") || lowerUrl.startsWith("https://")) {
            return appendImageVersionPostFix(srcUrl);
        }
        String urlPrefix = getExtVariable("STATIC_RESOURCE_URL_PREFIX", "http://127.0.0.1:8080/naf/statics/");
        return appendImageVersionPostFix(concatUrl(urlPrefix, srcUrl));
    }

    protected static String DEBUG_VERSION="-1";
	public static String appendImageVersionPostFix(String url) {
		if (DEBUG_VERSION.equals("-1")) {
			return url;
		}
		if (url.indexOf("?") > 0) {
			return url +"&v="+DEBUG_VERSION;
		}
		return url + "?v=" + DEBUG_VERSION;
	}

    
}
