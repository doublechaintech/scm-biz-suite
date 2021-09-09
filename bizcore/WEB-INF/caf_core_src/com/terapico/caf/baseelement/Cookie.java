package com.terapico.caf.baseelement;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cookie {
	protected long maxAge;
	protected Date expires;
	protected String path;
	protected String domain;
	protected Map<String,String>otherProperties;
	
	public long getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(long maxAge) {
		this.maxAge = maxAge;
	}
	public Cookie maxAge(long maxAge){
		setMaxAge( maxAge);
		return this;
	}
	
	public Cookie property(String name, String value){
		
		if(otherProperties == null){
			otherProperties = new HashMap<String,String>();
		}
		otherProperties.put(name, value);
		return this;
	}
	public Date getExpires() {
		return expires;
	}

	public void setExpires(Date expires) {
		this.expires = expires;
		//FIXME: format it
		this.property("expires", expires.toLocaleString());
	}
	public Cookie expires(Date expires){
		setExpires(expires);
		return this;
	}
	public String getPath() {
		return path;
	}
	public Cookie path(String path){
		setPath(path);
		return this;
	}
	public void setPath(String path) {
		this.property("path", path);
		this.path = path;
	}
	public Cookie domain(String domain){
		setDomain(domain);
		return this;
	}
	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.property("domain", domain);
		this.domain = domain;
	}

	//Set-Cookie: <name>=<value>[; <Max-Age>=<age>]
	//[; expires=<date>][; domain=<domain_name>]
	//		[; path=<some_path>][; secure][; HttpOnly]
	//from https://www.owasp.org/index.php/HttpOnly
	public Cookie() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	protected String extractPropeties(){
		if(otherProperties == null){
			return null;
		}
		Set<Map.Entry<String, String>> entrySet = otherProperties.entrySet();
		if(entrySet.isEmpty()){			
			return null;			
		}
		StringBuilder value = new StringBuilder();
		
		int index = 0;
		for(Map.Entry<String, String> entry: entrySet){
			if(index > 0){
				value.append("; ");
				
			}
			value.append(entry.getKey());
			value.append('=');
			value.append(entry.getValue());
			index++; 
			
		}
		return value.toString();
		
	}
	public String toString(){
		
		
		
		return extractPropeties();
	}

}
