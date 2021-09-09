package com.terapico.utils;

import java.io.File;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MessageTemplateUtil {
	public static class MessageTemplate {
		protected Map<String, Integer> declaration;
		protected String template;
		protected Map<String, String> i18nTemplates;
		
		public Map<String, Integer> getDeclaration() {
			return declaration;
		}
		public void setDeclaration(Map<String, Integer> declaration) {
			this.declaration = declaration;
		}
		public String getTemplate() {
			return template;
		}
		public void setTemplate(String tempalte) {
			this.template = tempalte;
		}
		public Map<String, String> getI18nTemplates() {
			return i18nTemplates;
		}
		public void setI18nTemplates(Map<String, String> i18nTemplates) {
			this.i18nTemplates = i18nTemplates;
		}
		
	}
	
	protected static Map<String, MessageTemplate> templates;
	protected static Date loadedTime;
	
	public static String getMessage(String templateName, Locale language, Map<String, ? extends Object> params) {
		ensureTemplates();
		MessageTemplate tmpl = templates.get(templateName);
		if (tmpl == null) {
			throw new RuntimeException("Template ["+templateName+"] not defined");
		}
		String templateStr = findTemplateString(tmpl, language);
		List<Object> arguments = convertParams(tmpl, params);
		return MessageFormat.format(templateStr, arguments.toArray());
	}

	private static List<Object> convertParams(MessageTemplate tmpl, Map<String, ? extends Object> params) {
		ArrayList<Object> list =new ArrayList<>();
		if (tmpl.getDeclaration() == null || params == null) {
			return list;
		}
		params.forEach((key,val)->{
			if(tmpl.getDeclaration() == null || tmpl.getDeclaration().isEmpty()) {
				return;
			}
			if (!tmpl.getDeclaration().containsKey(key)) {
				return;
			}
			int idx = tmpl.getDeclaration().get(key);
			CollectionUtils.addItem(list, idx, val);
		});
		return list;
	}

	private static String findTemplateString(MessageTemplate tmpl, Locale language) {
		if (language == null) {
			return tmpl.getTemplate();
		}
		Map<String, String> i18nTemplates = tmpl.getI18nTemplates();
		if (i18nTemplates == null || i18nTemplates.isEmpty()) {
			return tmpl.getTemplate();
		}
		String key = language.getLanguage()+"_"+language.getCountry();
		String it = i18nTemplates.get(key);
		if (it != null) {
			return it;
		}
		key = language.getLanguage();
		it = i18nTemplates.get(key);
		if (it != null) {
			return it;
		}
		return tmpl.getTemplate();
	}

	protected static void ensureTemplates() {
		if (loadedTime == null || templates == null) {
			loadTemplates();
			return;
		}
		if (fileChanged()) {
			loadTemplates();
			return;
		}
	}

	protected static boolean fileChanged() {
		String fileName = getFileName();
		File file = new File(fileName);
		return file.lastModified() > loadedTime.getTime();
	}

	protected static void loadTemplates() {
		String fileName = getFileName();
		File file = new File(fileName);
		if (!file.exists()) {
			throw new RuntimeException(String.format("文件%s不存在, 你可以设置MESSAGE_TEMPLATE_FILE以指定文件位置",file.getAbsolutePath()));
		}
		if (fileName.startsWith("/")) {
			fileName = "/"+fileName;  // Spring的缺陷work around
		}
		ApplicationContext context = new FileSystemXmlApplicationContext(fileName);
		templates = (Map<String, MessageTemplate>) context.getBean("templates");
		loadedTime = new Date();
	}

	protected static String getFileName() {
		return TextUtil.getExtVariable("MESSAGE_TEMPLATE_FILE", "./message_templates.xml");
	}
	
	public static String getMessage(List<String> templateSegments, Map<String, Object> params) {
		if (templateSegments == null || templateSegments.isEmpty()) {
			return "";
		}
		StringBuilder rstSb = new StringBuilder();
		for(String tmpSeg: templateSegments) {
			rstSb.append(renderLine(tmpSeg, params));
		}
		return rstSb.toString();
	}

	private static Pattern ptnParamExp = Pattern.compile("\\$\\s*\\{[^}]+\\}");
	private static Pattern ptnParamExpContent = Pattern.compile("\\$\\s*\\{([^}]+)\\}");
	private static String renderLine(String tmpSeg, Map<String, Object> params) {
		if (TextUtil.isBlank(tmpSeg)) {
			return "";
		}
		List<String> paramExps = TextUtil.findAllMatched(tmpSeg, ptnParamExp);
		if (paramExps == null || paramExps.isEmpty()) {
			return tmpSeg;
		}
		Map<String, Object> oldValue = new HashMap<>(params);
		for(String paramExp : paramExps) {
			Matcher m = ptnParamExpContent.matcher(paramExp);
			if (!m.matches()) {
				continue;
			}
			String exp = m.group(1);
			System.out.println("do work for: " + paramExp +"="+exp);
			int pos = exp.indexOf(':');
			if (pos < 0) {
				// 没有表达式，直接替换
				tmpSeg = Pattern.compile(paramExp, Pattern.LITERAL).matcher(tmpSeg)
						.replaceFirst(Matcher.quoteReplacement(String.valueOf(params.get(exp))));
				continue;
			}
			String expression = exp.substring(pos+1);
			String paramName = exp.substring(0,pos);
			Object value = params.get(paramName);
			switch (expression) {
			case "++":
			{
				Number nValue = (Number) value;
				params.put(paramName, nValue.intValue()+1);
				tmpSeg = Pattern.compile(paramExp, Pattern.LITERAL).matcher(
						tmpSeg).replaceFirst(Matcher.quoteReplacement(String.valueOf(params.get(paramName))));
			}
			break;
			case "?":
			{
				if (value == null) {
					params.putAll(oldValue);
					return "";
				}
				tmpSeg = Pattern.compile(paramExp, Pattern.LITERAL).matcher(
						tmpSeg).replaceFirst(Matcher.quoteReplacement(String.valueOf(params.get(paramName))));
			}
			break;
			default:
				throw new RuntimeException("不支持表达式:"+expression);
			}
		}
		return tmpSeg;
	}
	
}
