package com.example.yiupang.freefoodfinder;

import java.util.HashMap;

/**
 * Created by yiupang on 5/27/2017.
 *
 */

class HttpCall
{
    static final int GET = 1;
    static final int POST = 2;

    private String url;
    private int methodType;
    private HashMap<String, String> params;

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

    HashMap<String, String> getParams() {
        return params;
    }

    public void setParams(HashMap<String, String> params) {
        this.params = params;
    }
}
