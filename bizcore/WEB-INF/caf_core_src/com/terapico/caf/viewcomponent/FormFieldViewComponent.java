package com.terapico.caf.viewcomponent;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.terapico.utils.DebugUtil;
import com.terapico.utils.MapUtil;

/**
 * 表单字段组件。
 * <p>
 * type=form-field
 * </p>
 * 
 * 表单字段的属性比较多，沿袭之前的设计。 核心的字段说明：
 * <ul>
 * <li>type：字段类型。 参见{@link FormFieldViewComponent#type 字段类型}</li>
 * <li>candidateValues：字段候选值。 参见{@link FormFieldViewComponent#candidateValues
 * 候选值}</li>
 * </ul>
 * 
 * @author clariones
 *
 */
@JsonPropertyOrder({ "componentType", "type", "label", "content", "placeholder" })
public class FormFieldViewComponent extends BaseViewComponent {
    public static final String TYPE_TEXT = "text";
    public static final String TYPE_LONG_TEXT = "longtext";
    public static final String TYPE_DATE = "date";
    public static final String TYPE_DATE_TIME = "date_time";
    public static final String TYPE_MONEY = "money";
    public static final String TYPE_URL = "url";
    public static final String TYPE_IMAGE = "image";
    public static final String TYPE_PASSWORD = "password";
    public static final String TYPE_NUMBER = "number";
    public static final String TYPE_SELECT = "select";
    public static final String TYPE_RADIO = "radio";
    public static final String TYPE_SWITCH = "switch";
    public static final String TYPE_CHECK_BOX = "checkbox";
    public static final String TYPE_VERIFY_CODE = "vcode";
    public static final String TYPE_HIDDEN = "hidden";

    /** 标签。显示该字段的提示名称. 也可能为空。例如 checkbox 类型的输入自带值说明，所以字段标签可能会被忽略 */
    protected String label;
    /** i18n 使用 */
    protected String localeKey;
    /** 对应的表单字段名. MUST */
    protected String parameterName;
    /**
     * 字段类型。
     * 
     * 这个字段表明字段该如何接收输入数据。
     * <ol>
     * <li>text: 普通的文本输入字段。</li>
     * <li>longtext： 大段文本的输入字段。</li>
     * <li>date：日期选择器</li>
     * <li>date_time：日期+时间选择器</li>
     * <li>money：金额输入字段。</li>
     * <li>url：URL输入字段。</li>
     * <li>image：图像字段。应具备上传/预览/删除的基本功能</li>
     * <li>password：口令输入字段。</li>
     * <li>number：数字输入字段。</li>
     * <li>select: 有限集合内选择之一输入的字段。典型的是下拉列表。</li>
     * <li>radio: 有限集合内选择之一输入的字段。但是全部显示出来。</li>
     * <li>switch：在 真/假 之间选择的字段。</li>
     * <li>checkbox：在有限集合内，可以多选的字段。典型的是一组多选框。</li>
     * <li>vcode：短信校验码的特定输入字段。背后ajax调用发送短信码等操作是OOTB的。</li>
     * </ol>
     */
    protected String type;
    /** 空值占位符. 只有支持placeholder的元素才有效。 */
    protected String placeholder;
    /** 初始值。 */
    protected String defaultValue;
    /** 字段描述 */
    protected String description;
    /** 字段分组。 暂时不用，忽略 */
    protected String fieldGroup;
    /** 最小值。 暂时不用，忽略 */
    protected String minValue = "0";
    /** 最大值。 暂时不用，忽略 */
    protected String maxValue = "128";
    /** 是否必填字段。 缺省false */
    protected boolean required = false;
    /** 是否禁止编辑 */
    protected boolean disabled = false;
    /** 字段关联的信息内容。可能没有 */
    protected String fieldMessage;
    /** 字段关联信息的级别。 包括：default, info, warning, error */
    protected String fieldMessageLevel;
    /** 富文本内容。 用于具备简单样式的表单输入的场景。例如选择项时，给出更详细的说明。 */
    protected String richContent;
    /**
     * 候选值
     * 
     * 对<b>select</b>的类型的字段，格式为一个简单Map对象：。<br/>
     * <ul>
     * <li>value:要输入的值。 String</li>
     * <li>displayText:界面上显示的值。 String</li>
     * </ul>
     * 例如： <br>
     * [{"value":"13800000001","displayText":"张师傅(接车代审员)"},<br/>
     * <br>
     * {"value":"13800000003","displayText":"李师傅(接单员)"}]</br>
     * <p>
     * </p>
     * 
     * 对<b>checkbox</b>的类型的字段，格式为一个简单Map对象：。<br/>
     * <ul>
     * <li>value:要输入的值。 String</li>
     * <li>displayText:界面上显示的值。String</li>
     * <li>checked:是否被选中， Boolean</li>
     * </ul>
     * 例如： <br>
     * [{"value":"game","displayText":"玩游戏","checked":false},</br>
     * <br>
     * {"value":"reading","displayText":"读书","checked":true},</br>
     * <br>
     * {"value":"work","displayText":"有正当职业","checked":true}]</br>
     * <p>
     * </p>
     */
    protected List<Map<String, Object>> candidateValues;
    /** 建议值。 逗号分隔的字符串。 目前不支持type-ahead. 暂不考虑其定义细节。 */
    protected String suggestValues;
    /** 显示的最大行数. 没有则不限制 */
    protected Integer maxLine;
    
    
    public String getRichContent() {
		return richContent;
	}

	public void setRichContent(String richContent) {
		this.richContent = richContent;
	}

	public Integer getMaxLine() {
        return maxLine;
    }

    public void setMaxLine(Integer maxLine) {
        this.maxLine = maxLine;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLocaleKey() {
        return localeKey;
    }

    public void setLocaleKey(String localeKey) {
        this.localeKey = localeKey;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getType() {
        return type;
    }

    public void setType(String dataType) {
        this.type = dataType;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
        this.content = defaultValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFieldGroup() {
        return fieldGroup;
    }

    public void setFieldGroup(String fieldGroup) {
        this.fieldGroup = fieldGroup;
    }

    public String getMinValue() {
        return minValue;
    }

    public void setMinValue(String minValue) {
        this.minValue = minValue;
    }

    public String getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(String maxValue) {
        this.maxValue = maxValue;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public List<Map<String, Object>> getCandidateValues() {
        return candidateValues;
    }

    public void setCandidateValues(List<Map<String, Object>> candidateValues) {
        this.candidateValues = candidateValues;
    }

    public String getSuggestValues() {
        return suggestValues;
    }

    public void setSuggestValues(String suggestValues) {
        this.suggestValues = suggestValues;
    }

    @Override
    public void setContent(Object content) {
        super.setContent(content);
        if (content == null) {
            this.defaultValue = null;
            return;
        }
        if (isDateTypeField()) {
            this.defaultValue = new SimpleDateFormat("yyyy-MM-dd").format(content);
            this.content = defaultValue;
            return;
        }
        if (isDateTimeTypeField()) {
            this.defaultValue = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(content);
            this.content = defaultValue;
            return;
        }
        this.defaultValue = String.valueOf(content);
    }

    private boolean isDateTypeField() {
        return "date".equals(this.getType());
    }
    private boolean isDateTimeTypeField() {
        return "date_time".equals(this.getType());
    }

    public FormFieldViewComponent() {
        super();
        this.setComponentType("form-field");
    }

    public String getFieldMessage() {
        return fieldMessage;
    }

    public void setFieldMessage(String fieldMessage) {
        this.fieldMessage = fieldMessage;
    }

    public String getFieldMessageLevel() {
        return fieldMessageLevel;
    }

    public void setFieldMessageLevel(String fieldMessageLevel) {
        this.fieldMessageLevel = fieldMessageLevel;
    }

    public Map<String, Object> addCandidateValue(String value, String displayText) {
        ensureCandidateValues();
        Map<String, Object> cVal = MapUtil.newMap(MapUtil.$("value", value), MapUtil.$("displayText", displayText));
        candidateValues.add(cVal);
        return cVal;
    }

    public Map<String, Object> addCandidateValue(String value, String displayText, boolean checked) {
        ensureCandidateValues();
        Map<String, Object> cVal = MapUtil.newMap(MapUtil.$("value", value), MapUtil.$("displayText", displayText),
                MapUtil.$("checked", checked));
        candidateValues.add(cVal);
        return cVal;
    }

    private void ensureCandidateValues() {
        if (candidateValues == null) {
            candidateValues = new ArrayList<Map<String, Object>>();
        }
    }


	@Override
	protected String getNodeHashcodeStr() {
		return super.getNodeHashcodeStr()+this.getType()+";"+this.getLabel()+";"+appendCandidateValue();
	}

	private String appendCandidateValue() {
		try {
			return DebugUtil.getObjectMapper().writeValueAsString(this.getCandidateValues());
		} catch (JsonProcessingException e) {
			return String.valueOf(this.getCandidateValues());
		}
	}

	protected String labelImage;


	public String getLabelImage() {
		return labelImage;
	}

	public void setLabelImage(String labelImage) {
		this.labelImage = labelImage;
	}
	
	
}
