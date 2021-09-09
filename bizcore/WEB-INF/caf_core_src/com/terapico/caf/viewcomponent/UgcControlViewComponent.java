package com.terapico.caf.viewcomponent;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户内容控制功能组件。目前为屏蔽和举报
 * <p>
 * componentType=ugc-control
 * </p>
 * 
 * content为折叠后显示的标题。<br/>
 * title4Block为‘屏蔽’功能所对应的按键文本。 如果为空，表示不需要屏蔽功能。<br/>
 * title4Report为‘举报’功能所对应的按键文本。如果为空，表示不需要举报功能。<br/>
 * linkToUrl是一个api url，第一个参数为举报对象ID，目前由后台负责填写好。 第二个参数为功能类型，可以为“report”或者“block”。
 * 后续为其他参数，需要调用者和后台提供者协商。
 * 
 * @author clariones
 */
public class UgcControlViewComponent extends BaseViewComponent {
    protected String title4Block;
    protected String title4Report;
    public String getTitle4Block() {
        return title4Block;
    }
    public void setTitle4Block(String title4Block) {
        this.title4Block = title4Block;
    }
    public String getTitle4Report() {
        return title4Report;
    }
    public void setTitle4Report(String title4Report) {
        this.title4Report = title4Report;
    }
    public UgcControlViewComponent() {
        super();
        this.setComponentType("ugc-control");
    }

    @Override
    public List<BaseViewComponent> getChildren() {
        this.children = new ArrayList<BaseViewComponent>();
        if (title4Block != null) {
            TextViewComponent child = new TextViewComponent(title4Block);
            child.setLinkToUrl(this.getLinkToUrl()+"block/");
            children.add(child);
        }
        if (title4Report != null) {
            TextViewComponent child = new TextViewComponent(title4Report);
            child.setLinkToUrl(this.getLinkToUrl()+"report/");
            children.add(child);
        }
        return children;
    }
    
    
    
}
