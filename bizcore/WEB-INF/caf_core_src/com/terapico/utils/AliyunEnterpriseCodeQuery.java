package com.terapico.utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

public class AliyunEnterpriseCodeQuery extends AliyunApiCall{
    protected String url = "https://businessfuzzy.shumaidata.com/getbusinessfuzzy";

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public Response queryForResponse(String keyword) throws Exception {
        OkHttpClient client = new OkHttpClient();
        if (TextUtil.isBlank(keyword)){
            keyword="中国";
        }
        URL url = new URL("https://businessfuzzy.shumaidata.com/getbusinessfuzzy?keyword=" + URLEncoder.encode(keyword, "utf-8"));
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();

        return getResponse(client, request);
    }

    public Map<String, Object> query(String keyword) throws Exception {
        Response response = queryForResponse(keyword);
        if (response.code() != 200){
            String returnedMessage = tryToGetErrorMessage(response);
            if (TextUtil.isBlank(returnedMessage)) {
                throw new Exception("调用失败,code=" + response.code() + "\r\n" + response.body().string());
            }
            throw new RuntimeException(returnedMessage);
        }
        return DebugUtil.getObjectMapper().readValue(response.body().string(), Map.class);
    }

    private String tryToGetErrorMessage(Response response) {
        try {
            Map<String, Object> data = DebugUtil.getObjectMapper().readValue(response.body().string(), Map.class);
            return (String) data.get("msg");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
