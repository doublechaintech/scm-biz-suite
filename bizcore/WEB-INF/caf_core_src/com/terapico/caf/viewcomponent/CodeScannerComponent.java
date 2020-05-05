package com.terapico.caf.viewcomponent;

/**
 * 二维码、条码扫描组件
 * <p>
 * componentType=code-scanner
 * </p>
 * 
 * content 缺省为空。
 * 
 * @author clariones
 */
public class CodeScannerComponent extends BaseInputViewComponent {
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

    public CodeScannerComponent() {
        this(null);
    }

    public CodeScannerComponent(String restUrl) {
        this(restUrl, null);
    }

    public CodeScannerComponent(String restUrl, String classes) {
        super();
        this.setApi(restUrl);
        this.setClasses(classes);
        this.setComponentType("code-scanner");
    }

}
