package com.skynet.infrastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class BlockChainAdvancer {
    private String server = "http://222.209.207.27:8080/hfgw/channelManager/invokeChaincode/";
    private String callBack = "https://www.doublechaintech/%s/updateHash/%s/";
    private String app = "A000005";
    private String chaincode = "CC000005";

    public String getServer() {
        return server;
    }

    public void setServer(String pServer) {
        server = pServer;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String pApp) {
        app = pApp;
    }

    public String getChaincode() {
        return chaincode;
    }

    public void setChaincode(String pChaincode) {
        chaincode = pChaincode;
    }

    public String getCallBack() {
        return callBack;
    }

    public void setCallBack(String pCallBack) {
        callBack = pCallBack;
    }

    public String formatCallUrl(String type, String id){
        return String.format(callBack, type, id);
    }

    public void deploy(String key, Object entity, String callBackUrl) throws Exception {
        ObjectMapper om = new ObjectMapper();
        String value = om.writeValueAsString(entity);
        Map<String, Object> req = new HashMap<>();
        List<String> parameters = new ArrayList<>();
        parameters.add("set");
        parameters.add(key);
        parameters.add(value);
        req.put("appid", app);
        req.put("ccid", chaincode);
        req.put("parameters", parameters);
        req.put("callBackUrl", callBackUrl);

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody requestBody = RequestBody.create(mediaType,  om.writeValueAsString(req));
        Request request = new Request
                .Builder()
                .url(server)
                .put(requestBody)
                .build();
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.newCall(request).execute();
    }
}
