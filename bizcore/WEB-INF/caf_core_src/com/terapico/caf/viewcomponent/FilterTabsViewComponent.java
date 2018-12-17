package com.terapico.caf.viewcomponent;

import static com.terapico.utils.MapUtil.$;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import com.terapico.utils.MapUtil;
import com.terapico.utils.TextUtil;

/**
 * Tabs 组件.
 * <p>
 * componentType=filter-tabs
 * </p>
 * 
 * <p>
 * 每个tab对应一个Filter，用户过滤用户数据。
 * </p>
 * 
 * <ul>
 * <li>content是一个列表。 每个列表元素有以下属性：
 * <ol>
 * <li>code：tab页的代码</li>
 * <li>link：点击触发的url</li>
 * <li>text: 要显示的tab名称。暂时不支持图像。 如果有需要，content 格式要重新定义。</li>
 * <li>selected: 是否被选中。</li>
 * <li>tips: 角注。例如对应的内容总条目数，有些情况下，需要显示一个数量在Tab标题上。也可以是"hot!"这类的短小文字</li>
 * </ol>
 * </li>
 * <li>Tab和内容无关，约定其互动规则为：点击tab后，返回新的页面。对应Tab的内容由后台提供。</li>
 * </ul>
 * 
 * @author clariones
 */
public class FilterTabsViewComponent extends BaseViewComponent {
    protected String activeTab;
    protected String classSelected;
    protected String classUnselected;

    public String getActiveTab() {
        return activeTab;
    }

    public void setActiveTab(String activeTab) {
        this.activeTab = activeTab;
    }

    public String getClassSelected() {
        return classSelected;
    }

    public void setClassSelected(String classSelected) {
        this.classSelected = classSelected;
    }

    public String getClassUnselected() {
        return classUnselected;
    }

    public void setClassUnselected(String classUnselected) {
        this.classUnselected = classUnselected;
    }

    public FilterTabsViewComponent() {
        super();
        this.setComponentType("filter-tabs");
    }

    private List<Map<String, Object>> ensureContent() {
        if (!(content instanceof List)) {
            this.content = new ArrayList<Map<String, Object>>();
        }
        return (List<Map<String, Object>>) this.content;
    }

    public void addTab(String code, String displayText, String link, String tips) {
        List<Map<String, Object>> list = ensureContent();
        Map<String, Object> newMap = MapUtil.newMap($("code", code), $("text", displayText));
        list.add(newMap);
        if (!TextUtil.isBlank(tips)) {
        	newMap.put("tips", tips);
        }
        if (!TextUtil.isBlank(link)) {
        	newMap.put("link", link);
        }
    }
    
    public void addTab(String code, String displayText, String link) {
    	addTab(code, displayText, link, null);
    }

    public void addTab(String value, String displayText) {
        addTab(value, displayText, null);
    }

    @Override
    public Object getContent() {
        if(this.content == null) {
            return null;
        }
        List<Map<String, Object>> contentList = (List<Map<String, Object>>) content;
        
        boolean setSelected = false;
        for(Map<String, Object> item: contentList) {
            String link = (String) item.get("link");
            String code = (String) item.get("code");
            item.put("statInPage", this.isStatInPage());
            if (link == null || !link.startsWith(linkToUrl)) {
                link = concatUrl(linkToUrl, code) +"/";
                item.put("linkToUrl", link);
            }else {
            	item.put("linkToUrl", link);
            }
            if (code.equals(this.getActiveTab())) {
                item.put("selected", true);
                item.put("classes", this.getClassSelected());
                setSelected = true;
            }else {
                item.remove("selected");
                item.put("classes", this.getClassUnselected());
            }
        }
        
        if (!setSelected) {
            contentList.get(0).put("selected", true);
            contentList.get(0).put("classes", this.getClassSelected());
        }
        return content;
    }

    @Override
    public String getLinkToUrl() {
        return null;
    }

	public void setTabTips(String tabCode, String tips) {
		List<Map<String, Object>> list = ensureContent();
		Optional<Map<String, Object>> item = list.stream().filter(it->{
			return tabCode.equals(it.get("code"));
		}).findFirst();
		
		if (item.isPresent()) {
			item.get().put("tips", tips);
		}else {
			throw new RuntimeException("Tab code " + tabCode +" not found");
		}
	}
    
    
}
