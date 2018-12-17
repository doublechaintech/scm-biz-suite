package com.terapico.caf.viewcomponent;

/**
 * 货币组件。
 * <p>
 * componentType=money
 * </p>
 * 
 * content是 “number”类型的金额。 format是格式化金额的格式。 默认是 "¥#,##0.##"
 * 
 * @author clariones
 *
 */
public class MoneyViewComponent extends BaseViewComponent {
    protected String format = "¥#,##0.##";

    public String getFormat() {
	return format;
    }

    public void setFormat(String format) {
	this.format = format;
    }

    public MoneyViewComponent() {
	this(null);
    }

    public MoneyViewComponent(Number content) {
	this(content, null);
    }

    public MoneyViewComponent(Number content, String classes) {
	this(content, classes, null);
    }

    public MoneyViewComponent(Number content, String classes, String format) {
	this(content, classes, format, null);
    }

    public MoneyViewComponent(Number content, String classes, String format, String tag) {
	super();
	this.setContent(content);
	this.setClasses(classes);
	if (format != null) {
	    this.setFormat(format);
	}
	this.setTag(tag);
	this.setComponentType("money");

    }

}
