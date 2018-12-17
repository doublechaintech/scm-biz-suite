package com.terapico.caf.viewcomponent;

/**
 * 字体图标组件。
 * <p>
 * componentType=font-icon
 * </p>
 * 
 * 这个目前只有4个level
 * <ul>
 * <li>default</li>
 * <li>info</li>
 * <li>warning</li>
 * <li>error</li>
 * </ul>
 * 它的content是图标的名称。
 * 目前图标名称是用的font-awsome的名字。 是否合适？待定！
 * @author clariones type="font-icon"
 */
public class FontIconViewComponent extends BaseViewComponent {
    protected String level = "default";

    public FontIconViewComponent() {
	this("info-circle", "default");
    }

    public FontIconViewComponent(String iconName) {
	this(iconName, "default");
    }

    public FontIconViewComponent(String iconName, String level) {
	super();
	this.setComponentType("font-icon");
	this.setContent(iconName);
    }

    public String getLevel() {
	return level;
    }

    public void setLevel(String level) {
	this.level = level;
    }

}
