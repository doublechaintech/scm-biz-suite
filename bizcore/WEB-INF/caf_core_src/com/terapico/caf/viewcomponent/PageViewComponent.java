package com.terapico.caf.viewcomponent;

import java.util.HashMap;
import java.util.Map;

import com.terapico.utils.RandomUtil;

/**
 * 页面组件。
 * <p>
 * componentType=page
 * </p>
 * 
 * content 是页面的title。
 *
 * @author clariones
 */
public class PageViewComponent extends BaseViewComponent {
    protected String frontColor;
    protected String backgroundColor;
    
    
    public String getFrontColor() {
        return frontColor;
    }

    public void setFrontColor(String frontColor) {
        this.frontColor = frontColor;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public PageViewComponent() {
        this(null);
    }

    public PageViewComponent(String title) {
        super();
        this.setContent(title);
        this.setComponentType("page");
    }

    public void fixLayoutTypeNames() {
        Map<String, Integer> initialLayoutLevels = new HashMap<String, Integer>();
        initialLayoutLevels.put(new ContainerViewComponent().getComponentType(), 0);
        // initialLayoutLevels.put(new
        // HorizontalContainerViewComponent().getComponentType(), 0);
        // initialLayoutLevels.put(new
        // VerticalContainerViewComponent().getComponentType(), 0);

        fixTypeName(this, initialLayoutLevels);
    }

    private void fixTypeName(BaseViewComponent view, Map<String, Integer> initialLayoutLevels) {
        String myType = view.getComponentType();
        if (initialLayoutLevels.containsKey(myType)) {
            int curLevel = initialLayoutLevels.get(myType);
            view.setComponentType(myType + "-l" + (curLevel + 1));
            initialLayoutLevels.put(myType, curLevel + 1);
            if (view.getChildren() != null) {
                for (BaseViewComponent child : view.getChildren()) {
                    fixTypeName(child, initialLayoutLevels);
                }
            }
            initialLayoutLevels.put(myType, curLevel);
            return;
        }
        if (view.getChildren() != null) {
            for (BaseViewComponent child : view.getChildren()) {
                fixTypeName(child, initialLayoutLevels);
            }
        }
    }

}
