package com.terapico.caf.viewcomponent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.terapico.utils.TextUtil;

/**
 * 文本组件
 * <p>
 * componentType=text
 * </p>
 * 
 * content为要显示的内容。<p/>
 * format 为显示格式。
 * 目前这个格式只有3种，主要用于限制文字长度的。
 * format="3,...,3": 取前三个，后3个，中间用...替代
 * format="3,...": 取前3个，后面还有的用...替代
 * format="...,3"：取后3个，前面的用...替代
 * @author clariones
 */
public class TextViewComponent extends BaseViewComponent {
    protected String format;
    protected int maxLine = -1;

    public int getMaxLine() {
        return maxLine;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setMaxLine(int maxLine) {
        this.maxLine = maxLine;
    }

    public TextViewComponent() {
        this(null);
    }

    public TextViewComponent(String content) {
        this(content, null);
    }

    public TextViewComponent(String content, String classes) {
        this(content, classes, null);
    }

    public TextViewComponent(String content, String classes, String tag) {
        this.setContent(content);
        this.setClasses(classes);
        this.setTag(tag);
        this.setComponentType("text");
    }

    @Override
    public Object getContent() {
        if(TextUtil.isBlank(format) || content == null) {
            return super.getContent();
        }
        return formatedText();
    }

    private static final Pattern ptnFmt1 = Pattern.compile("^(\\d+),(.*?),(\\d+)$");
    private static final Pattern ptnFmt2 = Pattern.compile("^(\\d+),(.*?)$");
    private static final Pattern ptnFmt3 = Pattern.compile("^$(.*?),^\\d+");
    private String formatedText() {
        String orgStr = String.valueOf(content);
        Matcher m = ptnFmt1.matcher(format);
        if (m.matches()) {
            return TextUtil.shrink(orgStr, Integer.parseInt(m.group(1)),Integer.parseInt(m.group(3)), m.group(2));
        }
        m = ptnFmt2.matcher(format);
        if (m.matches()){
            return TextUtil.shrink(orgStr, Integer.parseInt(m.group(1)),0, m.group(2));
        }
        m = ptnFmt3.matcher(format);
        if (m.matches()) {
            return TextUtil.shrink(orgStr, 0,Integer.parseInt(m.group(2)), m.group(1));
        }
        return orgStr;
    }
    
}
