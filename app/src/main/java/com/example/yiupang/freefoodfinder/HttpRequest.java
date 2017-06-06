package com.example.yiupang.freefoodfinder;

import android.os.AsyncTask;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by yiupang on 5/27/2017.
 *
 */
class HttpRequest extends AsyncTask<HttpCall, String, String>
{
    private static final String UTF_8 = "UTF-8";

    private Object response;
    private int responseCode;

    /**
     * Handle the input and result of the HTTP call
     *
     * @param params - The parameters of the asynchronous task from the caller are passed to this step
     * */
    @Override
    protected String doInBackground(HttpCall... params)
    {
        HttpURLConnection urlConnection = null;
        Logger logger = Logger.getLogger(HttpRequest.class.getName());
        try
        {

            HttpCall httpCall = params[0];
            URL url;
            OutputStream os;
            BufferedWriter writer;

            url = new URL(httpCall.getUrl() + getDataString(httpCall.getQueryParams()));
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod(HttpCall.methodToStr(httpCall.getMethodType()));
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);

            if (httpCall.getBody() != null && httpCall.getMethodType() != HttpCall.GET)
            {
                urlConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                os = urlConnection.getOutputStream();
                writer = new BufferedWriter(new OutputStreamWriter(os, UTF_8));
                writer.append(httpCall.getBody().toString());
                writer.flush();
                writer.close();
                os.close();
            }

            /*Handle the response*/
            responseCode = urlConnection.getResponseCode();
            if (responseCode < 300)
            {
                ObjectMapper mapper = new ObjectMapper();
                response = mapper.readTree(urlConnection.getInputStream());
            }
            else
            {
                response = urlConnection.getResponseMessage();
            }
        }
        catch (Exception e)
        {
            logger.log(Level.FINE,"context",e);
            if(urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        return response.toString();
    }

    /**
     * Invoke on the UI thread after the background computation finishes.
     *
     * @param s - the returned value from doInBackground()
     * */
    @Override
    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);
        onResponse(response, responseCode);
    }


    public void onResponse(Object response, int code)
    {
         //It needs to be overwritten by the caller to handle the response
    }

    /**
     * Create the string for parameters in the URL based on the attributes and data passed by the caller
     * */
    public String getDataString(Map<String, String> params) throws UnsupportedEncodingException
    {
        if (params == null)
        {
            return "";
        }
        StringBuilder result = new StringBuilder();
        boolean isFirst = true;
        for(Map.Entry<String, String> entry : params.entrySet())
        {
            result.append(isFirst? "?":"&");
            isFirst = false;
            result.append(URLEncoder.encode(entry.getKey(), UTF_8));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(),UTF_8));
        }
        return result.toString();
    }
}
