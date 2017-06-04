package com.example.yiupang.freefoodfinder;

import android.widget.ListView;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.List;

/**
 * Created by yiupang on 6/1/2017.
 *
 */
public class TestHttpRequest
{
    @Test
    public void testGetCall()
    {
        final String expected = "200";

        HttpCall httpCall = new HttpCall();
        httpCall.setMethodType(HttpCall.GET);
        httpCall.setUrl("http://free-food-finder.herokuapp.com/events");
        new HttpRequest(){
            @Override
            public void onResponse(Object response, int code)
            {
                super.onResponse(response, code);
                assertEquals(expected, Integer.toString(code));
            }
        }.execute(httpCall);
    }

    @Test
    public void testDoInBackground()
    {

    }
}
