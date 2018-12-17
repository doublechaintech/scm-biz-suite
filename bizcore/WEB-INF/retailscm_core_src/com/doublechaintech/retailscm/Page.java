package com.doublechaintech.retailscm;

public class Page extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String title;
	String link;
	boolean disabled;
	boolean selected;
	int pageNumber;
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public boolean isDisabled() {
		return disabled;
	}
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String toString(){
		
		if(link.isEmpty()){
			return title;
		}
		if(this.selected){
			return title+"(!)";
		}
		return title;
		//return title+"("+link+")";
	}
	
}

