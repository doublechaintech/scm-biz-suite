package com.skynet.bootstrap;
import com.google.common.collect.Iterables;
import com.google.common.collect.ObjectArrays;

import org.apache.commons.io.IOUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ContentType;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Purpose of this class is to make getParameter() return post data AND also be able to get entire
 * body-string. In native implementation any of those two works, but not both together.
 */
public class MultiReadHttpServletRequest extends HttpServletRequestWrapper {
    public static final String UTF8 = "UTF-8";
    public static final Charset UTF8_CHARSET = Charset.forName(UTF8);
    private ByteArrayOutputStream cachedBytes;
    private Map<String, String[]> parameterMap;

    public MultiReadHttpServletRequest(HttpServletRequest request) {
        super(request);
    }

    public static void toMap(Iterable<NameValuePair> inputParams, Map<String, String[]> toMap) {
        for (NameValuePair e : inputParams) {
            String key = e.getName();
            String value = e.getValue();
            if (toMap.containsKey(key)) {
                String[] newValue = ObjectArrays.concat(toMap.get(key), value);
                toMap.remove(key);
                toMap.put(key, newValue);
            } else {
                toMap.put(key, new String[]{value});
            }
        }
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        if (cachedBytes == null) cacheInputStream();
        return new CachedServletInputStream();
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    private void cacheInputStream() throws IOException {
        /* Cache the inputStream in order to read it multiple times. For
         * convenience, I use apache.commons IOUtils
         */
        cachedBytes = new ByteArrayOutputStream();
        IOUtils.copy(super.getInputStream(), cachedBytes);
    }

    @Override
    public String getParameter(String key) {
        Map<String, String[]> parameterMap = getParameterMap();
        String[] values = parameterMap.get(key);
        return values != null && values.length > 0 ? values[0] : null;
    }

    @Override
    public String[] getParameterValues(String key) {
        Map<String, String[]> parameterMap = getParameterMap();
        return parameterMap.get(key);
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        if (parameterMap == null) {
            Map<String, String[]> result = new LinkedHashMap<String, String[]>();
            decode(getQueryString(), result);
            decode(getPostBodyAsString(), result);
            parameterMap = Collections.unmodifiableMap(result);
        }
        return parameterMap;
    }

    private void decode(String queryString, Map<String, String[]> result) {
        if (queryString != null) toMap(decodeParams(queryString), result);
    }

    private Iterable<NameValuePair> decodeParams(String body) {
        Iterable<NameValuePair> params = URLEncodedUtils.parse(body, UTF8_CHARSET);
        try {
            String cts = getContentType();
            if (cts != null) {
                ContentType ct = ContentType.parse(cts);
                if (ct.getMimeType().equals(ContentType.APPLICATION_FORM_URLENCODED.getMimeType())) {
                    List<NameValuePair> postParams = URLEncodedUtils.parse(IOUtils.toString(getReader()), UTF8_CHARSET);
                    params = Iterables.concat(params, postParams);
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        return params;
    }

    public String getPostBodyAsString() {
        try {
            if (cachedBytes == null) cacheInputStream();
            return cachedBytes.toString(UTF8);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* An inputStream which reads the cached request body */
    public class CachedServletInputStream extends ServletInputStream {
        private ByteArrayInputStream input;

        public CachedServletInputStream() {
            /* create a new input stream from the cached request body */
            input = new ByteArrayInputStream(cachedBytes.toByteArray());
        }

        @Override
        public int read() throws IOException {
            return input.read();
        }

        @Override
        public boolean isFinished() {
            return input.available() <= 0;
        }

        @Override
        public boolean isReady() {
            // TODO Auto-generated method stub
            return true;
        }

        @Override
        public void setReadListener(ReadListener arg0) {

        }
        public int available() throws IOException {
            return input.available();
        }

    }


}