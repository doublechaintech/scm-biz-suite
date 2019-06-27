package com.terapico.caf.viewcomponent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.util.TextUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.terapico.utils.DebugUtil;
import com.terapico.utils.RandomUtil;
import com.terapico.utils.TextUtil;

/**
 * 基础组件类。
 * 
 * 这里只是集中了公共字段。 具体每个组件会有特殊的字段，请参见各组件文档。
 * 
 * @author clariones
 *
 */
@JsonPropertyOrder({ "componentType", "content" })
public abstract class BaseViewComponent {
    /** 组件对象的ID。这个ID设计用于交互时，用来关联参与交互的对象。不涉及交互的组件对象，该值为空。 */
    protected String id;
    /** 组件类型名称。MUST。 各种组件的具体值，详见各组件文档 */
    protected String componentType;
    /**
     * 组件使用的CSS类名称列表，用空格分开。例如“btn btn-primary”, 有些没有class，例如“form”,“hidden”这种不可见元素。
     */
    protected String classes;
    /** 互动操作。 目前暂不使用 */
    protected Interaction interaction;
    /** 组件的内容。例如对"Text"就是要显示的文字，对“IMAGE”就是图片的URL。对 FormField 就是“缺省值”。 详见各组件具体文档 */
    protected Object content;
    /** 子组件列表 */
    protected List<BaseViewComponent> children;
    /** 组件的语义化名称。暂时不考虑，因为目前JSP渲染部分有用到，就把这个名字先保留下来，这里只是占个名字。 */
    protected String tag;
    /** 是否可见。MUST. 大部分组件是true。有些组件出于互动需要会初始为false，例如pop的消息。 */
    protected boolean visiable = true;
    /** 是否容器类组件。container，form等组件会为true。详见各个组件具体文档 */
    protected boolean beContaniner = false;
    /** 该组件点击后跳转的url. 这个只是简单的跳转，有条件的跳转或者需要计算的跳转，不在这里表示，而是使用 interaction */
    protected String linkToUrl;
    /** 内部使用。不会传递到前台 */
    @JsonIgnore
    protected transient boolean inputable = false; // MUST。这个随各个具体的元素变化，form field会是true。其他都是false。
    // 方便检查后台传递的数据是否正常的。和显示无关。
    /** i18n 使用。暂时未使用 */
    protected String localKey;
    
    protected boolean statInPage;
    
    protected boolean active = true;
    protected String pathHashcode = null;
    protected String nodeHashcode = null;
    
    
    public String getPathHashcode() {
    	if (pathHashcode != null) {
    		return pathHashcode;
    	}
    	String pathHashcodeStr = getPathHashcodeStr();
    	pathHashcode = calcStrHashCode(pathHashcodeStr);
    	return pathHashcode;
	}

    protected String calcStrHashCode(String str) {
		return String.format("%08X", ("hashcode"+str).hashCode());
	}

	protected String getPathHashcodeStr() {
		StringBuilder sb = new StringBuilder();
		sb.append(getNodeHashcodeStr());
		if (children != null) {
			for(BaseViewComponent child : children) {
				sb.append("&").append(child.getPathHashcode());
			}
		}
		return sb.toString();
	}

	public String getNodeHashcode() {
		if (nodeHashcode != null) {
			return nodeHashcode;
		}
		String nodeHashcodeStr = getNodeHashcodeStr();
		nodeHashcode = calcStrHashCode(nodeHashcodeStr);
    	return nodeHashcode;
	}

	protected String getNodeHashcodeStr() {
		StringBuilder sb = new StringBuilder();
		sb.append("$").append(this.getComponentType()).append(";").append(this.getLinkToUrl()).append(";")
				.append(this.isActive()).append(this.isVisiable()).append(";").append(getContextStrForCalcHashCode());
		return sb.toString();
	}

	protected Object getContextStrForCalcHashCode() {
		ObjectMapper mapper = DebugUtil.getObjectMapper();
		try {
			return mapper.writeValueAsString(this.getContent());
		} catch (JsonProcessingException e) {
			return String.valueOf(this.getContent());
		}
	}

	public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isStatInPage() {
        return statInPage;
    }

    public void setStatInPage(boolean statInPage) {
        this.statInPage = statInPage;
    }

    public boolean isBeContaniner() {
        return beContaniner;
    }

    public void setBeContaniner(boolean beContaniner) {
        this.beContaniner = beContaniner;
    }

    public String getLocalKey() {
        return localKey;
    }

    public void setLocalKey(String localKey) {
        this.localKey = localKey;
    }

    public String getId() {
    	if (id != null && !id.isEmpty()) {
    		return id;
    	}
        return genRamdomId();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComponentType() {
        return componentType;
    }

    public void setComponentType(String componentType) {
        this.componentType = componentType;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public Interaction getInteraction() {
        return interaction;
    }

    public void setInteraction(Interaction interaction) {
        this.interaction = interaction;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public List<BaseViewComponent> getChildren() {
        return children;
    }

    public void setChildren(List<BaseViewComponent> children) {
        this.children = children;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public boolean isVisiable() {
        return visiable;
    }

    public void setVisiable(boolean visiable) {
        this.visiable = visiable;
    }

    public boolean isInputable() {
        return inputable;
    }

    public void setInputable(boolean inputable) {
        this.inputable = inputable;
    }

    // 包装一些setter
    public BaseViewComponent assignId(String id) {
        this.setId(id);
        return this;
    }

    public BaseViewComponent assignClasses(String classes) {
        this.setClasses(classes);
        return this;
    }

    public BaseViewComponent assignContent(Object content) {
        this.setContent(content);
        return this;
    }

    public BaseViewComponent assignTag(String tag) {
        this.setTag(tag);
        return this;
    }

    public BaseViewComponent assignLinkToUrl(String url) {
        this.setLinkToUrl(url);
        return this;
    }

    public String getLinkToUrl() {
        return linkToUrl;
    }

    public void setLinkToUrl(String linkToUrl) {
        this.linkToUrl = linkToUrl;
    }

    // 下面是一些语法糖

    /**
     * 添加一个子组件。 子组件将会添加到本组件的子组件列表的最后，并返回本组件。
     * 
     * @param childComponent
     * @return
     */
    public BaseViewComponent addChild(BaseViewComponent childComponent) {
        if (childComponent == null) {
            return this;
        }
        ensureChilder();
        children.add(childComponent);
        return this;
    }

    /**
     * 新建一个子组件。 子组件将会添加到本组件的子组件列表的最后，并返回新添加的子组件。
     * 
     * @param childComponent
     * @return 子组件
     */
    public <T extends BaseViewComponent> T newChild(T childComponent) {
        if (childComponent == null) {
            return null;
        }
        ensureChilder();
        children.add(childComponent);
        return childComponent;
    }

    protected void ensureChilder() {
        if (children != null) {
            return;
        }
        children = new ArrayList<BaseViewComponent>();
    }

    protected String getExtVariable(String key, String defaultValue) {
        String val = System.getProperty(key);
        if (val != null) {
            return val;
        }
        val = System.getenv(key);
        if (val != null) {
            return val;
        }
        return defaultValue;
    }

    protected String concatUrl(String prefix, String uri) {
        if (TextUtil.isBlank(prefix)) {
            return uri;
        }
        if (TextUtils.isBlank(uri)) {
            return prefix;
        }
        boolean hasEnd = prefix.endsWith("/");
        boolean hasLead = uri.startsWith("/");
        if (!hasEnd && !hasLead) {
            return prefix + "/" + uri;
        }
        if (hasEnd != hasLead) {
            return prefix + uri;
        }
        return prefix + uri.substring(1);
    }

    public void copyTo(BaseViewComponent other) {
        // other is null, will throw exception. this should be called with control
        other.id = id;
        other.componentType = componentType;
        other.classes = classes;
        other.interaction = interaction;
        other.content = content;
        other.children = children;
        other.tag = tag;
        other.visiable = visiable;
        other.beContaniner = beContaniner;
        other.linkToUrl = linkToUrl;
        other.inputable = inputable;
        other.localKey = localKey;

    }

    public void addClass(String moreClasses) {
        if (this.getClasses() == null) {
            this.setClasses(moreClasses);
            return;
        }
        this.setClasses(this.getClasses()+" " + moreClasses);
    }

    public BaseViewComponent() {
        super();
//        this.setId());
    }

//    public String getKey() {
//        return getId();
//    }

    public String genRamdomId() {
    	return String.format("GI%08X_%S", System.currentTimeMillis(), RandomUtil.randomNumAndChars(6));
    }
    
    public Map<String, Object> toMap() {
    	ObjectMapper mapper = DebugUtil.getObjectMapper();
    	try {
			String jstr = mapper.writeValueAsString(this);
			return mapper.readValue(jstr, Map.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new HashMap<String, Object>() {{put("exception",e);}};
		}
    }
}
