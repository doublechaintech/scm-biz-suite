package com.terapico.utils;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class DebugUtil {
    private static ObjectMapper _mapper = null;

    public static void dumpAsJson(Object object, boolean pretty) throws Exception {
        ObjectMapper mapper = getObjectMapper();
        String jsonStr = null;
        if (pretty) {
            jsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } else {
            jsonStr = mapper.writeValueAsString(object);
        }
        System.out.println(jsonStr);
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
    
    public static void renderHashMap(Map<String, Object> map, Writer out, int level) throws IOException {
    	if (map == null || map.isEmpty()) {
    		out.write( "<div class='empty_value_container'>(empty map)</div>" );
    		return;
    	}
    	String template = "<div class='map_value_container map_level_%d'>";
    	out.write(String.format(template, level));
    	template = "<div class='toggle_show_flag' onclick='toggleShow(this)'>"+getIconHtml()+"</div>";
    	out.write(String.format(template));
    	Iterator<Entry<String, Object>> it = map.entrySet().iterator();
    	while(it.hasNext()) {
    		Entry<String, Object> ent = it.next();
    		String key = ent.getKey();
    		Object value = ent.getValue();
    		
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
		if (key.equals("imageUrl")) {
			template = "<image class='image_value' src='%s'/>";
			out.write(String.format(template, value));
			return;
		}
		
		if (key.equals("linkToUrl") || key.endsWith("LinkToUrl")) {
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
		template="<div class='common_value_content' ondblclick='handleDbClick(this)'>%s</div>" ;
		out.write(String.format(template, value));
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

}
