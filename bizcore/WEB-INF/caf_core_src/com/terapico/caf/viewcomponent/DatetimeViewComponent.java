package com.terapico.caf.viewcomponent;

import java.util.Date;

/**
 * 日期时间组件。
 * <p>
 * componentType=datetime
 * </p>
 * 
 * content 是 Date 类型的数据
 * format 是格式化日期的格式。默认是"yyyy-MM-dd'T'HH:mm:ss"
 * 
 * @author clariones
 *
 */
public class DatetimeViewComponent extends BaseViewComponent {
    protected String format = "yyyy-MM-dd'T'HH:mm:ss";

    
    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public DatetimeViewComponent() {
	this(null);
    }

    public DatetimeViewComponent(Date content) {
	this(content, null);
    }

    public DatetimeViewComponent(Date content, String classes) {
	this(content, classes, null);
    }

    public DatetimeViewComponent(Date content, String classes, String format) {
	this(content, classes, format, null);
    }

    public DatetimeViewComponent(Date content, String classes, String format, String tag) {
	super();
	this.setContent(content);
	this.setClasses(classes);
	if (format != null) {
	    this.setFormat(format);
	}
	this.setTag(tag);
	this.setComponentType("datetime");
	
    }
    
}
