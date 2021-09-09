package com.skynet.infrastructure;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLDecodeUtils {
	private static final String TEXT = "__text";

	public static Map<String, Object> decodeXmlString(String messageXmlStr) {
		try {
			return decodeToMap(messageXmlStr, true);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private static Map<String, Object> decodeToMap(String messageXmlStr, boolean doTrim) throws Exception{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(new ByteArrayInputStream(messageXmlStr.getBytes(StandardCharsets.UTF_8)));
		NodeList msgParamNodes = doc.getDocumentElement().getChildNodes();
		Object[] results = decodeNodeToMap(doc.getDocumentElement(), doTrim);
		if (results == null || results.length < 2){
			return null;
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put((String) results[0], results[1]);
		return result;
	}

	/**
	 * 
	 * @param documentElement
	 * @return
	 * @throws Exception 0-key, 1-value
	 */
	private static Object[] decodeNodeToMap(Node node, boolean doTrim) throws Exception{
//		System.out.println("Now read node " + node.getNodeName()+"("+node.getNodeType()+"), value="+node.getNodeValue());
		short nodeType = node.getNodeType();
		switch (nodeType){
		case Node.ENTITY_REFERENCE_NODE:
		case Node.DOCUMENT_FRAGMENT_NODE:
		case Node.DOCUMENT_TYPE_NODE:
		case Node.NOTATION_NODE:
		case Node.PROCESSING_INSTRUCTION_NODE:
			return null;
			// 忽略以上类型的ｎｏｄｅ
		case Node.ATTRIBUTE_NODE:
			return new Object[]{node.getNodeName(), node.getNodeValue()};
		case Node.TEXT_NODE:
		case Node.CDATA_SECTION_NODE:
			String nodeValue = node.getNodeValue();
			if (StringUtils.isBlank(nodeValue)){
				return null;
			}
			return new Object[]{TEXT, nodeValue};
		case Node.ENTITY_NODE:
		case Node.DOCUMENT_NODE:
		case Node.ELEMENT_NODE:
			default:
				break;
		}
		NodeList children = node.getChildNodes();
		if (children == null){
			return new Object[]{node.getNodeName(), null};
		}
		
		Map<String, Object> result = new HashMap<String, Object>();
		NamedNodeMap attrs = node.getAttributes();
		if (attrs != null){
			for (int i = 0; i < attrs.getLength(); i++) {
				Node attrNode = attrs.item(i);
				result.put(attrNode.getNodeName(), doTrim?attrNode.getNodeValue().trim():attrNode.getNodeValue());
			}
		}
		for (int i = 0; i < children.getLength(); i++) {
//			System.out.println(result);
			Node childNode = children.item(i);
			Object[] childValue = decodeNodeToMap(childNode, doTrim);
			if (childValue == null || childValue.length < 2){
				continue;
			}
//			System.out.println("Now read node " + childValue[0]+", value="+childValue[1]);
			String key = (String) childValue[0];
			if (TEXT.equals(key)){
				String oldValue = (String) result.get(key);
				if (StringUtils.isBlank(oldValue)){
					result.put(key, childValue[1]);
				}else{
					result.put(key, oldValue+"\r\n"+childValue[1]);
				}
				continue;
			}
			Object existedValue = result.get(key);
			Object newValue = childValue[1];
			if (doTrim && newValue instanceof String){
				newValue = newValue.toString().trim();
			}
			if (existedValue == null){
				result.put(key, newValue);
				continue;
			}
			if (existedValue instanceof List){
				((List) existedValue).add(newValue);
				continue;
			}
			List<Object> listValue = new LinkedList<Object>();
			listValue.add(existedValue);
			listValue.add(newValue);
			result.put(key, listValue);
		}
		if (result.size() == 1 && result.containsKey(TEXT)){
			return new Object[]{node.getNodeName(), result.get(TEXT)};
		}
		return new Object[]{node.getNodeName(), result};
	}

}
