package com.terapico.caf.viewcomponent;

/**
 * 显示条码或者二维码的组件
 * <p>
 * componentType=bar-qr-code
 * </p>
 * 
 * content为要显示的内容。
 * showType可以是"qr-code" 或者 “bar-code”， 或者 "both"。 目前只支持“qr-code”
 * @author clariones
 */
public class BarOrQrCodeViewComponent extends BaseViewComponent {
    protected String showType = "qr-code";
    
    protected int size = 178;
    
    public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }

    public BarOrQrCodeViewComponent() {
	this(null);
    }
    
    public BarOrQrCodeViewComponent(String content) {
	this(content, null);
    }
    
    public BarOrQrCodeViewComponent(String content, String classes) {
	this(content, classes, null);
    }
    
    public BarOrQrCodeViewComponent(String content, String classes, String tag) {
	this.setContent(content);
	this.setClasses(classes);
	this.setTag(tag);
	this.setComponentType("bar-qr-code");
    }
}
