package com.terapico.caf.viewcomponent;

/**
 * 搜索框组件
 * <p>
 * componentType=search
 * </p>
 * 
 * content 是搜索关键字，用于需要在刷新页面后，保留搜索关键字的场景。 对弈复杂的搜索，需要制作独立的组件，这个组件用于OOTB的简单全文搜索。
 * 
 * @author clariones
 */
public class SearchViewComponent extends BaseInputViewComponent {
    /**
     * 搜索功能对应的后台接口。 这个通常是一个URL的前缀。后续参数需要组件自己拼接。 例如
     * api="./cis/searchService/searchContract/", 实际发送的请求是：
     * "./cis/searchService/searchContract/XX洗车店/"。
     * 拼接的参数个数和含义是固定的，目前只有一个，就是"search-content"
     */
    protected String api;

    public String getApi() {
	return api;
    }

    public void setApi(String api) {
	this.api = api;
    }
    
    public SearchViewComponent() {
	this(null, null);
    }

    public SearchViewComponent(String placeHolder, String restUrl) {
	this(placeHolder, restUrl, null);
    }

    public SearchViewComponent(String placeHolder, String restUrl, String classes) {
	super();
	this.setPlaceHolder(placeHolder);
	this.setApi(restUrl);
	this.setClasses(classes);
	this.setComponentType("search");
    }

}
