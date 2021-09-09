package com.terapico.utils;

import freemarker.cache.StringTemplateLoader;
import freemarker.core.ParseException;
import freemarker.template.*;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

public class FreemarkerUtil {
    public static String render(String templatePath, Map<String, Object> data) {
        try {
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
            cfg.setClassForTemplateLoading(FreemarkerUtil.class, "/template");
            cfg.setDefaultEncoding("UTF-8");
            Template template = null;
            template = cfg.getTemplate(templatePath);
            StringWriter out = new StringWriter();
            template.process(data, out);
            return out.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public static String stringRender(String strTemplate, Map<String, Object> data) throws Exception{
        try {
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
            StringTemplateLoader stringLoader = new StringTemplateLoader();
            stringLoader.putTemplate("SimpleStringTemplate", strTemplate);
            cfg.setTemplateLoader(stringLoader);

            Template template = cfg.getTemplate("SimpleStringTemplate");
            StringWriter out = new StringWriter();
            template.process(data, out);
            return out.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return strTemplate;
        }
    }

}
