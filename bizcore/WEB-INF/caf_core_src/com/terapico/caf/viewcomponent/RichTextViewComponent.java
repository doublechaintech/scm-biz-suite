package com.terapico.caf.viewcomponent;

/**
 * 富格式文本组件
 * <p>
 * componentType=richText
 * </p>
 * 
 * content为要显示的内容。
 * @author clariones
 */
public class RichTextViewComponent extends BaseViewComponent {
    protected int maxLine = -1;
    
    public int getMaxLine() {
        return maxLine;
    }

    public void setMaxLine(int maxLine) {
        this.maxLine = maxLine;
    }

    public RichTextViewComponent() {
	this(null);
    }
    
    public RichTextViewComponent(String content) {
	this(content, null);
    }
    
    public RichTextViewComponent(String content, String classes) {
	this(content, classes, null);
    }
    
    public RichTextViewComponent(String content, String classes, String tag) {
	this.setContent(content);
	this.setClasses(classes);
	this.setTag(tag);
	this.setComponentType("richText");
    }
}
