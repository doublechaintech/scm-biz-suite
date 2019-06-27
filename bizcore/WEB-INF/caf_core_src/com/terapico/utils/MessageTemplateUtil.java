package com.terapico.utils;

import java.io.File;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
	
	public static String getMessage(String templateName, Locale language, Map<String, Object> params) {
		ensureTemplates();
		MessageTemplate tmpl = templates.get(templateName);
		if (tmpl == null) {
			throw new RuntimeException("Template ["+templateName+"] not defined");
		}
		String templateStr = findTemplateString(tmpl, language);
		List<Object> arguments = convertParams(tmpl, params);
		return MessageFormat.format(templateStr, arguments.toArray());
	}

	private static List<Object> convertParams(MessageTemplate tmpl, Map<String, Object> params) {
		ArrayList<Object> list =new ArrayList<>();
		if (tmpl.getDeclaration() == null || params == null) {
			return list;
		}
		params.forEach((key,val)->{
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
}
