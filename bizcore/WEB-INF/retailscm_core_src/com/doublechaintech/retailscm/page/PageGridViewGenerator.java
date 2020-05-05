
package com.doublechaintech.retailscm.page;
import com.doublechaintech.retailscm.AccessKey;

import com.doublechaintech.retailscm.BaseGridViewGenerator;

public class PageGridViewGenerator extends BaseGridViewGenerator{
	
	

	private static final long serialVersionUID = 1L;
	
	
	
	protected void throwExceptionIfListNotFount(String listName) {
		String message=String.format("List '%s' is not found for Page", listName);
		throw new IllegalArgumentException(message);
	}
	
	protected String [] getHeaderKeys(String listName) {
		
		if(Page.SLIDE_LIST.equals(listName)){
			return new String[]{"id","name","display_order","image_url","video_url","link_to_url","page","version"};
		}
		if(Page.UI_ACTION_LIST.equals(listName)){
			return new String[]{"id","code","icon","title","display_order","brief","image_url","link_to_url","extra_data","page","version"};
		}
		if(Page.SECTION_LIST.equals(listName)){
			return new String[]{"id","title","brief","icon","display_order","view_group","link_to_url","page","version"};
		}
		
		throwExceptionIfListNotFount(listName);
		return new String[]{}; // place holder, code will never go here!!!
		
		
	}
	protected String  getObjectKey(String listName) {
		if(Page.SLIDE_LIST.equals(listName)){
			return "slide";
		}
		if(Page.UI_ACTION_LIST.equals(listName)){
			return "ui_action";
		}
		if(Page.SECTION_LIST.equals(listName)){
			return "section";
		}
		

		throwExceptionIfListNotFount(listName);
		return ""; // place holder, code will never go here!!!
	}

}





