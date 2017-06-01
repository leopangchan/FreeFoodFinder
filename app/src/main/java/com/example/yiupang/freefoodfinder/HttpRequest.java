package com.example.yiupang.freefoodfinder;

import android.os.AsyncTask;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by yiupang on 5/27/2017.
 *
 */
class HttpRequest extends AsyncTask<HttpCall, String, String>
{
    private static final String UTF_8 = "UTF-8";

    /**
     * Handle the input and result of the HTTP call
     *
     * @param params - The parameters of the asynchronous task from the caller are passed to this step
     * */
    @Override
    protected String doInBackground(HttpCall... params)
    {
        HttpURLConnection urlConnection = null;
        StringBuilder response = new StringBuilder();

        try
        {
            HttpCall httpCall = params[0];
            URL url;
            OutputStream os;
            BufferedWriter writer;
            int responseCode;

            url = new URL(httpCall.getUrl());
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod(HttpCall.methodToStr(httpCall.getMethodType()));
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);

            if(httpCall.getBody() != null && httpCall.getMethodType() != HttpCall.GET)
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
            if(responseCode == HttpURLConnection.HTTP_OK)
            {
                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                while ((line = br.readLine()) != null)
                {
                    response.append(line);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
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
        try
        {
            ObjectMapper mapper = new ObjectMapper();
            TypeFactory typeFactory = mapper.getTypeFactory();
            List<Event> events = mapper.readValue(s, typeFactory.constructCollectionType(List.class, Event.class));/*Parse to Event Objs*/
            onResponse(events);
        }
        catch (IOException e)
        {
            List<Event> eventsError = new LinkedList<>();
            eventsError.add(new Event("Error", "Error", "Error"));
            onResponse(eventsError);
        }
    }

    /**
     * It needs to be overwritten by the caller to handle the response
    * */
    public void onResponse(List<Event> response)
    {

    }

    /**
     * Create the string for parameters in the URL based on the attributes and data passed by the caller
     * */
    private String getDataString(HashMap<String, String> params, int methodType) throws UnsupportedEncodingException
    {
        StringBuilder result = new StringBuilder();
        boolean isFirst = true;
        for(Map.Entry<String, String> entry : params.entrySet())
        {
            if(isFirst)
            {
                isFirst = false;
                if(methodType == HttpCall.GET)
                    result.append("?");
                else
                    result.append("&");
                result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            }
        }
        return result.toString();
    }
}
