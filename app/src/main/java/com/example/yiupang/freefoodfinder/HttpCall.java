package com.example.yiupang.freefoodfinder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by yiupang on 5/27/2017.
 *
 */

class HttpCall
{
    static final int GET = 1;
    static final int POST = 2;
    static final int PUT = 3;
    static final int DELETE = 4;

    private static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
    }

    public static String methodToStr(int method)
    {
        switch (method)
        {
            case GET:
                return "GET";
            case POST:
                return "POST";
            case PUT:
                return "PUT";
            case DELETE:
                return "DELETE";
            default:
                throw new IllegalArgumentException("Invalid method code");
        }
    }

    private String url;
    private int methodType;
    private JsonNode body;

    String getUrl() {
        return url;
    }

    void setUrl(String url) {
        this.url = url;
    }

    int getMethodType() {
        return methodType;
    }

    void setMethodType(int methodType) {
        this.methodType = methodType;
    }

    JsonNode getBody() {
        return body;
    }

    public void setBody(JsonNode params) {
        this.body = params;
    }

    public void setBody(Object params) {
        this.body = mapper.valueToTree(params);
    }
}
