package com.terapico.caf.baseelement;

import java.util.ArrayList;
import java.util.List;

public class MenuItem {
	List<MenuItem> submenuItems;
	private String beanName;
	private String methodName;

	public String getBeanName() {
		return beanName;
	}
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
	public boolean isLeafItem()
	{
		if(this.submenuItems==null){
			return true;
		}
		if(this.submenuItems.size()==0){
			return true;
		}
		return false;
		
	}
	public String getMethodName() {
		return methodName;
	}
	public void setLink(String methodName) {
		this.methodName = methodName;
	}
	public List<MenuItem> getSubmenuItems() {
		if(submenuItems==null){
			submenuItems=new ArrayList<MenuItem>();
		}
		return submenuItems;
	}
	public void addSubmenuItem(MenuItem item) {
		getSubmenuItems().add(item);
	}
	
	public void setSubmenuItems(List<MenuItem> submenuItems) {
		this.submenuItems = submenuItems;
	}
}
