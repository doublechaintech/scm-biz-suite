package com.terapico.utils;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class AliyunApiCall {
    protected String appKey;
    protected String appSecret;
    protected String appCode;

    public String getAppKey() {
        return appKey;
    }
    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }
    public String getAppSecret() {
        return appSecret;
    }
    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }
    public String getAppCode() {
        return appCode;
    }
    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    protected Request signatureRequest(Request request) throws Exception{
        List<String> addedHeaders = new ArrayList<>();
        String stringToSign = makeStringToSign(request, addedHeaders);
        String signStr = sign(stringToSign);
        return addSignHeaders(request, signStr, addedHeaders);
    }

    protected Request addSignHeaders(Request request, String signStr, List<String> addedHeaders) {
        return request.newBuilder().addHeader("X-Ca-Key", getAppKey())
                .addHeader("X-Ca-Signature-Method", "HmacSHA256")
                .addHeader("X-Ca-Signature-Headers",String.join(",", addedHeaders))
                .addHeader("X-Ca-Signature", signStr)
                .build()
                ;
    }

    protected  String sign(String stringToSign) throws Exception {
        Mac hmacSha256 = Mac.getInstance("HmacSHA256");
        byte[] keyBytes = getAppSecret().getBytes(StandardCharsets.UTF_8);
        hmacSha256.init(new SecretKeySpec(getAppSecret().getBytes(StandardCharsets.UTF_8), 0, keyBytes.length, "HmacSHA256"));
        byte[] md5Result = hmacSha256.doFinal(stringToSign.getBytes(StandardCharsets.UTF_8));
        String sign = Base64.getEncoder().encodeToString(md5Result);
        return sign;
    }

    protected  String makeStringToSign(Request request,List<String> addedHeaders) throws Exception {
        return makeStringToSign(request, null, addedHeaders);
    }
    protected  String makeStringToSign(Request request, List<String> selectedHeaders, List<String> addedHeaders) throws Exception{

        StringBuilder sb = new StringBuilder();
        sb.append(pickHttpMethod(request)).append("\n");
        sb.append(pickAccept(request, addedHeaders)).append("\n");
        sb.append(pickContentMD5(request, addedHeaders)).append("\n");
        sb.append(pickContentType(request, addedHeaders)).append("\n");
        sb.append(pickDate(request, addedHeaders)).append("\n");
        sb.append(pickHeaders(request, selectedHeaders, addedHeaders));
        sb.append(pickPathAndParameters(request));
        String x = sb.toString();
//        System.out.println("makeStringToSign=" + x);
        return x;
    }

    protected  String pickPathAndParameters(Request request) {
        StringBuilder path = new StringBuilder(request.url().encodedPath());
        Set<String> qns = request.url().queryParameterNames();
        if (qns.isEmpty()){
            return path.toString();
        }
        List<String> names = new ArrayList<>(qns);
        Collections.sort(names);
        String sepChar = "?";
        for(String name: names){
            String value = request.url().queryParameter(name);
            if (TextUtil.isBlank(value)){
                path.append(sepChar).append(name);
            }else {
                path.append(sepChar).append(name).append("=").append(value);
            }
            sepChar = "&";
        }
        String x = path.toString();
//        System.out.println("pickPathAndParameters=" + x);
        return x;
    }

    protected  String pickHeaders(Request request, List<String> selectedHeaders, List<String> addedHeaders) {
        StringBuilder sb = new StringBuilder();
        if (selectedHeaders != null) {
            selectedHeaders.removeAll(addedHeaders);
            selectedHeaders.remove("Accept");
            selectedHeaders.remove("Content-MD5");
            selectedHeaders.remove("Content-Type");
            selectedHeaders.remove("Date");
            selectedHeaders.remove("X-Ca-Key");
            selectedHeaders.remove("X-Ca-Signature-Method");
            for (String headerName : selectedHeaders) {
                sb.append(pickHeaderValueByName(request, headerName, addedHeaders));
            }
        }
        sb.append("X-Ca-Key:").append(getAppKey()).append("\nX-Ca-Signature-Method:HmacSHA256\n");
        addedHeaders.add("X-Ca-Key");
        addedHeaders.add("X-Ca-Signature-Method");
        return sb.toString();
    }

    protected  String pickDate(Request request, List<String> addedHeaders) {
        return pickHeaderByName(request, "Date", addedHeaders);
    }

    protected  String pickContentType(Request request, List<String> addedHeaders) {
        return pickHeaderByName(request, "Content-Type", addedHeaders);
    }

    protected  String pickContentMD5(Request request, List<String> addedHeaders) {
        return pickHeaderByName(request, "Content-MD5", addedHeaders);
    }

    protected  String pickAccept(Request request, List<String> addedHeaders) {
        return pickHeaderByName(request, "Accept", addedHeaders);
    }

    protected  String pickHeaderByName(Request request, String headerName, List<String> addedHeaders) {
        String v = request.header(headerName);
        if (v == null){
            v = request.header(headerName.toLowerCase());
        }
        if (v == null){
            return "";
        }
        addedHeaders.add(headerName);
        return v;
    }
    protected  String pickHeaderValueByName(Request request, String headerName, List<String> addedHeaders) {
        String v = request.header(headerName);
        if (v == null){
            v = request.header(headerName.toLowerCase());
        }
        if (v == null){
            return "";
        }
        addedHeaders.add(headerName);
        return String.format("%s:%s\n",headerName, v);
    }

    protected  String pickHttpMethod(Request request) {
        return request.method().toUpperCase();
    }

    protected Response getResponse(OkHttpClient client, Request request) throws Exception {
        Request req = signatureRequest(request);
        Call call = client.newCall(req);

        return call.execute();
    }
}
