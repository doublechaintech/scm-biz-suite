package com.terapico.utils;

import java.io.IOException;
import java.io.PrintStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class DebugUtil {
    private static ObjectMapper _mapper = null;
    private static final NumberFormat cashFormat = new DecimalFormat("#,##0.00");
    
    public static String dumpAsJson(Object object, boolean pretty) throws Exception {
        ObjectMapper mapper = getObjectMapper();
        String jsonStr = null;
        if (pretty) {
            jsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } else {
            jsonStr = mapper.writeValueAsString(object);
        }
        System.out.println(jsonStr);
        return jsonStr;
    }

    public static ObjectMapper getObjectMapper() {
        if (_mapper != null) {
            return _mapper;
        }
        _mapper = new ObjectMapper();
        _mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        _mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        _mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        return _mapper;
    }
    
    public static Map<String, Object> toMap(Object data, String className) throws IOException {
    	ObjectMapper mapper = new ObjectMapper();
    	mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    	mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    	String jsonStr = mapper.writeValueAsString(data);
    	if (className != null && className.endsWith("Form")) {
    		if (data instanceof Map && ((Map) data).containsKey("form")) {
    			System.out.println("新BaseViewPage对象,跳过包装");
    		}else {
	    		Map<String, Object> mapResult = new HashMap<>();
	    		mapResult.put("form", mapper.readValue(jsonStr, Map.class));
	    		return mapResult;
    		}
    	}
    	return mapper.readValue(jsonStr, Map.class);
    }
    public static void renderHashMap(Map<String, Object> map, Writer out, int level) throws IOException {
    	if (map == null || map.isEmpty()) {
    		out.write( "<div class='empty_value_container'>(empty map)</div>" );
    		return;
    	}
    	String template = "<div class='map_value_container map_level_%d'>";
    	out.write(String.format(template, level));
    	template = "<div class='toggle_show_flag' onclick='toggleShow(this)'>"+getIconHtml()+"</div>";
    	out.write(String.format(template));
    	
    	List<String> dispkeys = new ArrayList<>();
    	dispkeys.addAll(map.keySet());
    	Collections.sort(dispkeys);
    	for(String key : dispkeys) {
//    	while(it.hasNext()) {
    		// Entry<String, Object> ent = it.next();
    		// String key = ent.getKey();
    		Object value = map.get(key);
    		
    		if (value instanceof Map && (key.toLowerCase().endsWith("form") && !key.toLowerCase().endsWith("platform"))) {
    			Map<String, Object> form = (Map<String, Object>) value;
    			template = "<div class=\"form-container\">";
    			out.write(String.format(template));
    			template = "<form method=\"post\">";
    			out.write(String.format(template));
    			template = "<lable ondblclick='handleDbClick(this)'>%s</lable>";
    			out.write(String.format(template, form.get("title")));
    			Map<String, Object> fields = (Map<String, Object>) form.get("fields");
    			List<String> keys = new ArrayList<>(fields.keySet());
    			Collections.sort(keys);
    			for(String fieldName : keys) {
    				Map<String, Object> fieldValue = (Map<String, Object>) fields.get(fieldName);
    				template = "<div>(%s)<lable ondblclick='handleDbClick(this)'>%s</lable>";
    				out.write(String.format(template,fieldValue.get("type"), fieldValue.get("name")));
    				template = "<input data-type=\"%s\" name=\"%s\" value=\"%s\"/>";
    				out.write(String.format(template, fieldValue.get("type"), fieldValue.get("name"), 
    						fieldValue.get("value")==null?"":fieldValue.get("value")));
    				Object candidateValues = fieldValue.get("candidateValues");
    				template = "</div>";
    				out.write(String.format(template));
    				if (candidateValues != null) {
    					template = "<div class=\"candidate_values\">Candidate values:<br/> %s</div>";
        				out.write(String.format(template, getObjectMapper().writeValueAsString(candidateValues)));
    				}
    			}
    			List<Map<String, Object>> actionList = (List<Map<String, Object>>) form.get("actionList");
    			for(Map<String, Object> action: actionList) {
    				template = "<button type=\"button\" data-url=\"%s\" code=\"%s\" onclick=\"formButtonClicked(this)\">%s</button>";
    				out.write(String.format(template, action.get("linkToUrl"), action.get("code"), action.get("title")));
    			}
    			template = "</form>";
    			out.write(String.format(template));
    			continue;
    		}
    		if (value instanceof Map) {
    			template = "<div class='kv_row map_row'>";
            	out.write(String.format(template));
				if (putArchor(key, out)) {
					template = "<div><div class='map_value_title' ondblclick='handleDbClick(this)'>%s</div><span class='item_count'>(%d members)</span></div>";
					out.write(String.format(template, key, ((Map) value).size()));
					out.write("</a>");
				} else {
					template = "<div><div class='map_value_title' ondblclick='handleDbClick(this)'>%s</div><span class='item_count'>(%d members)</span></div>";
					out.write(String.format(template, key, ((Map) value).size()));
				}
    			template = "<div class='toggle_show_flag' onclick='toggleShow(this)'>"+getIconHtml()+"</div>";
            	out.write(String.format(template));
    			renderObject(key, value, out, level+1);
    			template = "</div>";
            	out.write(String.format(template));
    			continue;
    		}
    		
    		if (value instanceof List) {
    			template = "<div class='kv_row list_row'>";
            	out.write(String.format(template));
            	template = "<div class='toggle_show_flag' onclick='toggleShow(this)'>"+getIconHtml()+"</div>";
            	out.write(String.format(template));
    			template="<div><div class='list_value_title' ondblclick='handleDbClick(this)'>%s</div><span class='item_count'>(%d items)</span></div>" ;
    			out.write(String.format(template, key, ((List) value).size()));
    			List<Object> list = (List<Object>) value;
    			for(Object obj : list) {
    				renderObject(key, obj, out, level+1);
    			}
    			template = "</div>";
            	out.write(String.format(template));
    			continue;
    		}
    		template = "<div class='kv_row'>";
        	out.write(String.format(template));
    		template="<div class='common_value_title' ondblclick='handleDbClick(this)'>%s</div>" ;
			out.write(String.format(template, key));
			renderObject(key, value, out, level+1);
			template = "</div>";
        	out.write(String.format(template));
    	}
    	template = "</div>";
    	out.write(String.format(template));
    }

    private static String getIconHtml() {
		return "<i class=\"fa fa-folder-open-o\"></i>";
	}

	private static boolean putArchor(String key, Writer out) throws IOException {
		Matcher m = ptnDataIdIndex.matcher(key);
		if (!m.matches()) {
			return false;
		}
		out.write("<a name='" + key +"'>");
		return true;
	}

	private static Pattern ptnDataIdIndex = Pattern.compile("^[a-zA-Z0-9]+_[A-Z]+\\d+$");
	private static void renderObject(String key, Object value, Writer out, int level) throws IOException {
		if (putArchorLink(key, value, out)) {
			String template = "<a href=\"javascript:;\" onclick=\"gotoAnchor('%s');\">%s</a>";
			out.write(String.format(template, value, value));
			return;
		}
		String template="<div class='common_value_content'>%s</div>" ;
		if (isImageData(key, value)) {
			template = "<image class='image_value' src='%s?x-oss-process=style/small'/>";
			out.write(String.format(template, value));
			return;
		}
		
		if (key.equals("linkToUrl") || key.endsWith("LinkToUrl") || key.equals("nextPageUrl")) {
			template = "<div><span ondblclick='handleDbClick(this)'>%s</span><a href='%s'>[GO]</a></div>";
			out.write(String.format(template, value, value));
			return;
		}
		
		
		
		if (value instanceof Map) {
			renderHashMap((Map<String, Object>) value, out, level);
			return;
		}
		if (value instanceof List) {
			List<Object> list = (List<Object>) value;
			for(Object obj : list) {
				renderObject(key, obj, out, level);
			}
			return;
		}
		if (value instanceof Number && (key.toLowerCase().endsWith("time") || key.toLowerCase().endsWith("date"))) {
			template = "<div class='common_value_content' ondblclick='handleDbClick(this)'>%s</div>";
			out.write(String.format(template, DateTimeUtil.formatDate(new Date(((Number)value).longValue()), null)));
			return;
		}
		if (value instanceof Number && (key.toLowerCase().endsWith("price") || key.toLowerCase().endsWith("date"))) {
			template = "<div class='common_value_content' ondblclick='handleDbClick(this)'>%s</div>";
			out.write(String.format(template, cashFormat.format(new BigDecimal(value.toString()))));
			return;
		}
		template="<div class='common_value_content' ondblclick='handleDbClick(this)'>%s</div>" ;
		out.write(String.format(template, value));
	}

	public static boolean isImageData(String key, Object value) {
		if ( key.equals("imageUrl") || key.toLowerCase().endsWith("image")) {
			return true;
		}
		
		if (key.endsWith("Logo")) {
			return true;
		}
		
		return false;
	}

	private static boolean putArchorLink(String key, Object value, Writer out) throws IOException {
		if (!key.equals("id")) {
			return false;
		}
		if (!(value instanceof String)) {
			return false;
		}
		
		String strVal = (String) value;
		Matcher m = ptnDataIdIndex.matcher(strVal);
		if (!m.matches()) {
			return false;
		}
//		out.write("(to: "+value+")");
		return true;
	}

	public static void dumpFullStackTrace(Throwable t, PrintStream s) {
		if (s == null) {
			s = System.out;
		}
		s.println(t.getClass().getCanonicalName()+": " + t.getMessage());
		if (t.getStackTrace() != null) {
			for(StackTraceElement st : t.getStackTrace()) {
				s.println("    at " + st.getClassName()+"." + st.getMethodName()+"("+st.getFileName()+":"+st.getLineNumber()+")");
			}
		}
		t = t.getCause();
		while(t != null) {
			s.println("Caused by: " + t.getClass().getCanonicalName()+": " + t.getMessage());
			if (t.getStackTrace() != null) {
				for(StackTraceElement st : t.getStackTrace()) {
					s.println("    at " + st.getClassName()+"." + st.getMethodName()+"("+st.getFileName()+":"+st.getLineNumber()+")");
				}
			}
			t = t.getCause();
		}
	}
}
